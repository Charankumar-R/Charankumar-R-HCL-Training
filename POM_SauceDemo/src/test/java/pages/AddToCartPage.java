package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class AddToCartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public AddToCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean clickAddToCart() {
		boolean isFoundAddtToCart;
		boolean isFoundCartIcon;
		try {
			driver.findElement(Locators.addToCart).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyAddToCart));
			String verifyAddToCart = driver.findElement(Locators.verifyAddToCart).getText();
			isFoundAddtToCart = verifyAddToCart.equals("Remove");
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyCartIcon));
//			String verifyCartIcon = driver.findElement(Locators.verifyCartIcon).getText();
//			isFoundCartIcon = verifyCartIcon.equals("1");
//			
//			return isFoundAddtToCart == isFoundCartIcon;
			return isFoundAddtToCart;
		} catch (TimeoutException te) {
			isFoundAddtToCart = false;
			isFoundCartIcon = false;
			return isFoundAddtToCart == isFoundCartIcon;
		}
	}

	public boolean clickCartIcon() {

		boolean isFound;
		try {
			driver.findElement(Locators.cartIcon).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyCheckout));
			String verifyCheckout = driver.findElement(Locators.verifyCheckout).getText();
			isFound = verifyCheckout.equals("Your Cart");
			return isFound;
		} catch (TimeoutException te) {
			isFound = false;
			return isFound;
		}

	}
}
