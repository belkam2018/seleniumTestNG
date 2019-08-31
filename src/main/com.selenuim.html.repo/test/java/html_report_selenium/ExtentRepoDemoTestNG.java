package html_report_selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilitis.ScreenUtils;

public class ExtentRepoDemoTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void beforTest() {
		
		//String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws Exception {

		ExtentTest test = extent.createTest("MyFirstTest","Simple description");
		driver.get("https://google.com");
        ScreenUtils.captureScreenshot(driver, "BrowserStarted");
        test.pass("Navigate test to google.com");
        
        driver.manage().window().maximize();
        ScreenUtils.captureScreenshot(driver, "Window MAX");
        test.pass("Window is Maximize");
		
       
//		test.log(Status.INFO, "This step shows usage of log(status,description)");
//		test.info("This step shows usage of info(details)");
//		test.fail("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//		test.addScreenCaptureFromPath("screenshot.png");
		 driver.findElement(By.name("q")).sendKeys("Automation");
         ScreenUtils.captureScreenshot(driver, "Type Something");

         test.pass("Entered text in Searchbox");
         driver.findElement(By.name("btnK")).click();
         ScreenUtils.captureScreenshot(driver, "Click to search");

         test.pass("Pressed Keyboard enter key");
         
         
	}

	@Test
	public void test2() throws Exception {

		ExtentTest test = extent.createTest("MySecondTest","Simple description");
		test.log(Status.INFO, "This step shows usage of log(status,description");
		test.info("This step shows usage of info(details)");
		test.pass("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		

	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

	@AfterSuite
	public void tearDown() {

		extent.flush();
	}



}
