package UITesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	
	public static void main (String[] args) {
		
	BaseClass base = new BaseClass();
        base.setup();
        
        WebDriverWait wait = new WebDriverWait(base.getDriver(),Duration.ofSeconds(10));
        base.getDriver().findElement(By.xpath("//a[text()='Alerts']")).click();
       
        WebElement showAlertButton = base.getDriver().findElement(By.id("alertButton"));
        WebElement btnConfirm = base.getDriver().findElement(By.id("confirmButton"));
        WebElement btnPrompt = base.getDriver().findElement(By.id("promptButton"));
        
        showAlertButton.click();
        base.getDriver().switchTo().alert().accept();
        
        btnConfirm.click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().accept();
        
        wait.until(ExpectedConditions.alertIsPresent());
        String alertResponseText = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().accept();
        
        System.out.println(alertText+" "+ alertResponseText);
        
        btnConfirm.click();
        wait.until(ExpectedConditions.alertIsPresent());
        String alert2Text = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().dismiss();
        
        wait.until(ExpectedConditions.alertIsPresent());
        String alertResponse2Text = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().accept();
        
        System.out.println(alert2Text+" "+ alertResponse2Text);
        
        btnPrompt.click();
        wait.until(ExpectedConditions.alertIsPresent());
        String promptTxt = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().sendKeys("cat");
        base.getDriver().switchTo().alert().accept();
        
        wait.until(ExpectedConditions.alertIsPresent());
        String promptResponseTxt = base.getDriver().switchTo().alert().getText();
        base.getDriver().switchTo().alert().accept();
        
        System.out.println(promptTxt);
        System.out.println(promptResponseTxt);
        
        base.tearDown();
	}
	
}
