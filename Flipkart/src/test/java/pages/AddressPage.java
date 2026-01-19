package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class AddressPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public AddressPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public boolean clickDeliveryHere() {
		
		boolean isfound;
		try {
			driver.findElement(Locators.Deliveryaddress).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.continuebtn));
		
			driver.findElement(Locators.continuebtn).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.AcceptAndContinue));
			
			driver.findElement(Locators.AcceptAndContinue).click();
			String actualText = driver.findElement(Locators.CheckPaymentValidateText).getText();
			isfound = actualText.equals("Complete Payment");
			return isfound;
 			
		}catch(TimeoutException te) {
			isfound=false;
			return isfound;
		}
		
	}

}
