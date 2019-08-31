package utilitis;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenUtils {


	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File("./screenshots/"+screenshotName+".png"));
			
			System.out.println("Screenshot taken");
			
		} catch (IOException e) {
			
			System.out.println("Exception while taking screenshot "+ e.getMessage());
		}
		

	}

}
