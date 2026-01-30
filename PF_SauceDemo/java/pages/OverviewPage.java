package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class OverviewPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public OverviewPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean clickFinish() {
		boolean isFound;
		try {
			driver.findElement(Locators.finishButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyLogoutPage));
			String verifyLogouString = driver.findElement(Locators.verifyLogoutPage).getText();
			isFound = verifyLogouString.equals("Checkout: Complete!");
			return isFound;
		} catch (TimeoutException te) {
			isFound = false;
			return isFound;
		}
	}
}
