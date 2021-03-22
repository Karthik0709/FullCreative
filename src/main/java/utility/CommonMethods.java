package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CommonMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 5);
	}
	
	public void clickWhenVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
