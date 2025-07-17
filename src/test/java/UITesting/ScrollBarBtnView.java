package UITesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollBarBtnView extends BaseClass{
	public static void main(String[] agrs) throws InterruptedException, IOException {
		
		BaseClass base = new BaseClass();
		base.setup();
		
		base.getDriver().findElement(By.xpath("//a[text()='Scrollbars']")).click();		
		WebElement btnAfterScroll = base.getDriver().findElement(By.id("hidingButton"));
		
		((JavascriptExecutor) base.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnAfterScroll);
		Thread.sleep(2000);
		btnAfterScroll.click();
		
		base.takeScreenshot("btnScrollview.png");
		
		base.tearDown();
		
	}
	
}
