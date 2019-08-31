package utilitis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;
//	public static void main(String[] args) {
//		
//		testData("/Users/wsgak/eclipse-workspace/html_report_selenium/excel/excelData1.xlsx","data");		
//	}
	
//	@Test(dataProvider = "test1data")
//	public void test1(String firstName, String lastName, String salary) {
//		System.out.println(firstName +" | "+lastName+" | "+salary);
//	}
	
	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username +" | "+password+" | ");
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "/Users/wsgak/eclipse-workspace/html_report_selenium/excel/excelData2.xlsx";
	
		Object data[][] = testData(excelPath,"data2");
		return data;
	}
	public static Object[][] testData(String excelPath, String sheetName ) {
		
		ExcelUtlities excel = new ExcelUtlities(excelPath,sheetName);
		
		int rowCount = excel.rowCount();
		int colCount = excel.columnCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			//System.out.println("---------------------------------");
			for (int j = 0; j < colCount; j++) {
				
			String cellData	= excel.getCellData(i, j);
			
			//System.out.print(cellData+" | ");
			data[i-1][j]= cellData;
			}
			//System.out.println();
		}return data;
	}

}
