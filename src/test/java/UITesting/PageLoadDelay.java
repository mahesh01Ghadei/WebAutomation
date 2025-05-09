package UITesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadDelay extends BaseClass {

	public static void main(String[] args) {
		
		BaseClass base = new BaseClass();
		base.setup();
		
		base.getDriver().findElement(By.xpath("//a[text()='Load Delay']")).click();
		
		WebDriverWait wait = new WebDriverWait(base.getDriver(), Duration.ofSeconds(20));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
		
	    WebElement btnAfterpageLoad =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'btn-primary')]")));
	    btnAfterpageLoad.click();
	    
	    base.tearDown();

	}

}
