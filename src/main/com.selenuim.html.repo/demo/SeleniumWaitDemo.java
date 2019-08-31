package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) {
		
		seleniumWaits();
	}
	
	public static void seleniumWaits() {
	System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
	WebDriver driver = new ChromeDriver();
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://google.com");
    driver.findElement(By.name("q")).sendKeys("Automation Testing");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.name("btnK")).click();
    
    WebDriverWait wait = new WebDriverWait(driver ,15);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
    
    driver.findElement(By.name("abcd")).click();
    
	
	}
}
