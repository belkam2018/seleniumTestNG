package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	
	public static void main(String[] args) throws Exception {
		
		test();
	}

	public static void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/wsgak/Downloads/chromedriver3");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
	    driver.findElement(By.name("q")).sendKeys("automation");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.name("btnK")).click();
	    
	    //driver.findElement(By.linkText("ABCD study completes enrollment, announces opportunities for ... - NIH")).click();
	    
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    	       .withTimeout(30, TimeUnit.SECONDS)
	    	       .pollingEvery(2, TimeUnit.SECONDS)
	    	       .ignoring(NoSuchElementException.class);

	    	   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	    	     public WebElement apply(WebDriver driver) {
	    	      // WebElement linkElement = driver.findElement(By.linkText("Automate Show"));
				   WebElement xpath = driver.findElement(By.xpath("//div[contains(text(),'Automation - IBM Automation | IBM')]"));
	    	       if (xpath.isEnabled()) {
	    	    	   System.out.println("Element Found");
					
				}
	    	       
	    	       return xpath;
	    	     }
	    	   });
	    	   
	    	   element.click();
	    	   
	    
	    Thread.sleep(3000);
	    driver.close();
	    driver.quit();
}
}
