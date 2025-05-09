package UITesting;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBar {
	
	public static void main(String [] args) {
		
		BaseClass base = new BaseClass();
		base.setup();
		
		base.getDriver().findElement(By.xpath("//a[text()='Progress Bar']")).click();
		base.getDriver().findElement(By.id("startButton")).click();
		int expectedValue = 75;
		
		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(15));
		wait.until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver d) {
		        String progress = d.findElement(By.id("progressBar")).getText().replace("%", "").trim();
		        return Integer.parseInt(progress) >= expectedValue;
		    }
		});
		

		base.getDriver().findElement(By.id("stopButton")).click();
		System.out.println("Progress bar value: "+ base.getDriver().findElement(By.id("progressBar")).getText());
		
		base.tearDown();
	}
	
	
}
