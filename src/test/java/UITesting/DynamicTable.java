package UITesting;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		
		BaseClass base = new BaseClass();
		base.setup();
		
		String component = "Chrome";
		String dataOf = "CPU";
		int dataindex = -1;
		
		base.getDriver().findElement(By.xpath("//a[text()='Dynamic Table']")).click();
		List<WebElement> columnheader = base.getDriver().findElements(By.xpath("//div[@role='row']/span[@role='columnheader']"));

		for (int i = 0; i < columnheader.size(); i++) {
		    String headerText = columnheader.get(i).getText().trim();
		    if (headerText.equalsIgnoreCase("CPU")) {
		    	dataindex = i ; 
		        break;
		    }
		}
		WebElement txtDynamicTableData = base.getDriver().findElement(By.xpath("//*[@aria-label='Tasks']//*[text()='"+component+"']/following-sibling::span["+dataindex+"]"));
		
		String txtDataExtractedFromTable = component+" "+dataOf+": "+txtDynamicTableData.getText();
		String dataExpected = base.getDriver().findElement(By.xpath("//*[@aria-label='Tasks']/following-sibling::p")).getText();
		
		System.out.println(txtDataExtractedFromTable.equals(dataExpected)? "Got the correct data": "Extracted the wrong data");
				
		base.tearDown();

	}

}
