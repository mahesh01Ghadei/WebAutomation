package UITesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void setup() {
		driver = new ChromeDrive();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.uitestingplayground.com/");
	}
	
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}

	
	
	public void takeScreenshot(String fileName) throws IOException {
		
		File targetDir = new File("screenshots");
		if (!targetDir.exists()) {
		    targetDir.mkdir(); 
		}
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File(targetDir, fileName));
	}
	
}
