package UITesting;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ShadowDOM {
	public static void main(String[] args) throws InterruptedException {
		
	BaseClass base = new BaseClass();
        base.setup();
        
        base.getDriver().findElement(By.xpath("//a[text()='Shadow DOM']")).click();
        
        SearchContext shadowRoot = base.getDriver().findElement(By.cssSelector("guid-generator")).getShadowRoot();
        WebElement btnGUIDGenerator = shadowRoot.findElement(By.id("buttonGenerate"));
        btnGUIDGenerator.click();
        
        WebElement inputGUIDEditField = shadowRoot.findElement(By.id("editField"));
        System.out.println(inputGUIDEditField.getDomProperty("value"));
        
		base.tearDown();

	}

}
