package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class SelectProductPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public SelectProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean selectProduct() {
		boolean isFound;
		try {
			driver.findElement(Locators.selectProduct).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifySelectProduct));
			String verifySelectProduct = driver.findElement(Locators.verifySelectProduct).getText();
			isFound = verifySelectProduct.equals("Back to products");
		} catch (TimeoutException te) {
			isFound = false;
		}
		return isFound;

	}
}
