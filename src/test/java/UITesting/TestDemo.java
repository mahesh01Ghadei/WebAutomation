package UITesting;


import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {
	public static void main(String [] args) {
		
        BaseClass base = new BaseClass();
        base.setup();
        base.tearDown();
	}
	
}
