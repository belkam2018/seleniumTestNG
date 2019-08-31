package html_report_selenium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void beforTest() {
		
		//String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch() {
		 driver.get("https://google.com");
         driver.findElement(By.name("q")).sendKeys("Automation");
         
         driver.findElement(By.name("btnK")).click();
	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
