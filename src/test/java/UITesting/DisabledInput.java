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
		
		WebDriverWait inputFieldWait = new WebDriverWait(base.getDriver(),Duration.ofSeconds(10));
		WebElement enabledInputField = inputFieldWait.until(new Function <WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					WebElement inputElement = driver.findElement(By.id("inputField"));
			        return inputElement.isEnabled() ? inputElement : null;
				}
		});
				
		enabledInputField.sendKeys("Input field is enabled.");
		base.tearDown();
		
	}
	
}
