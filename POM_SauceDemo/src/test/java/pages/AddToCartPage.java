package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.Locators;

public class AddToCartPage {

	private WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddToCart() {
		driver.findElement(Locators.addToCart).click();
		String verifyAddToCart = driver.findElement(Locators.verifyAddToCart).getText();
		Assert.assertEquals(verifyAddToCart, "Remove");
	}

	public void clickCartIcon() {
		String verifyCartIcon = driver.findElement(Locators.verifyCartIcon).getText();
		Assert.assertEquals(verifyCartIcon, "1");
		driver.findElement(Locators.cartIcon).click();

	}
}
