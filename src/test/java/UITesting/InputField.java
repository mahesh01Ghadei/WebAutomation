package UITesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InputField extends BaseClass {

	public static void main(String[] args) {


		
		BaseClass base = new BaseClass();
		base.setup();
		
		String newTxt = "New Button Text";
		base.getDriver().findElement(By.xpath("//a[text()='Text Input']")).click();
		base.getDriver().findElement(By.id("newButtonName")).sendKeys(newTxt);
		
		WebElement btnChangeText = base.getDriver().findElement(By.id("updatingButton"));
		btnChangeText.click();
		String btnText = btnChangeText.getText();
		
		System.out.println(btnText.equals(newTxt)? "Successfully updated text content of the button":"Failed to update the text content of the button");
		
		base.tearDown();

	}

}
