package UITesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AJAXComponentTest {

	public static void main(String [] args) {
		
		BaseClass base = new BaseClass();
        base.setup();
        
        base.getDriver().findElement(By.xpath("//a[text()='AJAX Data']")).click();
		base.getDriver().findElement(By.id("ajaxButton")).click();
		
		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(20));
		Boolean lbl = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='content']//p"), "Data loaded with AJAX get request."));

	    System.out.println(lbl? "AJAX data fetched successfully":"Failed to fetch AJAX data");
			
	    base.tearDown();
		
		
	}
	
}
