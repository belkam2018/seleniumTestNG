package html_report_selenium;

import org.testng.annotations.Test;

import config.PropertiesFile;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {
	
	WebDriver driver = null;
	public static String browserName=null;
	
	@BeforeTest
	public void beforTest() {
		
		//String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","/Users/wsgak/Downloads/chromedriver3");
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","/Users/wsgak/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void googleSearch2() {
		 driver.get("https://google.com");
         driver.findElement(By.name("q")).sendKeys("Automation");
         
         driver.findElement(By.name("btnK")).click();
	}
	
	@Test
	public void googleSearch3() {
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
		PropertiesFile.setProperties();
	}

}
