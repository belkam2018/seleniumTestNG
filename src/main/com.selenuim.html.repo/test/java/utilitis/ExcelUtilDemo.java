package utilitis;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilDemo {
	
	public static void main(String[] args) {
		
		ExcelUtils excel = new ExcelUtils("/Users/wsgak/eclipse-workspace/html_report_selenium/excel/excelData1.xlsx","data");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(8, 2);
		excel.getCellDataString(8, 1);
		

	}

}
