package UITesting;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisabledInput {
	
	public static void main (String[] args) {
		
		BaseClass base = new BaseClass();
		base.setup();
		
		base.getDriver().findElement(By.xpath("//a[text()='Disabled Input']")).click();
		WebElement btnDelayEnable = base.getDriver().findElement(By.id("enableButton"));
		btnDelayEnable.click();
		
		WebDriverWait wait = new WebDriverWait(base.getDriver(),Duration.ofSeconds(10));
		WebElement inputField = wait.until(new Function <WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					WebElement element = driver.findElement(By.id("inputField"));
			        return element.isEnabled() ? element : null;
				}
		});
				
		inputField.sendKeys("Input field is enabled.");
		base.tearDown();
		
	}
	
}
