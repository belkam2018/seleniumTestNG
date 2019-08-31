package html_report_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsBasicDemo {
	
	static WebDriver driver = null;
	public static void main(String[] args) {
		
		
		 // initialize the HtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test1 = extent.createTest("Google Search Test One","this is test to validate google search functionality ");

        System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
         driver = new ChromeDriver();

        test1.log(Status.INFO, "Starting Test Case");
         driver.get("https://google.com");
         test1.pass("Navigate tesxt to google.com");

         driver.findElement(By.name("q")).sendKeys("Automation");
         test1.pass("Entered text in Searchbox");
         
         driver.findElement(By.name("btnK")).click();
         test1.pass("Pressed Keyboard enter key");

         driver.close();
         driver.quit();
           test1.pass("Close the browser");
           
           test1.info("Test Completed");

        extent.flush();
    }
	}


