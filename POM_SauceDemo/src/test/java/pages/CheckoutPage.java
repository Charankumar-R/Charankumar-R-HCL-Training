package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.Locators;

public class CheckoutPage {
	private WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}


	public void clickCheckout() {
		String verifyCheckout = driver.findElement(Locators.verifyCheckout).getText();
		Assert.assertEquals(verifyCheckout, "Your Cart");
		driver.findElement(Locators.checkout).click();
		
	}
}
