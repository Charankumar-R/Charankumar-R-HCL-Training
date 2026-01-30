package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class CheckoutPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CheckoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	}
	
	public boolean clickCheckout() {
		boolean isFound;
		try {
			driver.findElement(Locators.checkout).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyInformationPage));
			String verifyInformationPage = driver.findElement(Locators.verifyInformationPage).getText();
			isFound = verifyInformationPage.equals("Checkout: Your Information");
			return isFound;
		} catch (TimeoutException te) {
			isFound = false;
			return isFound;
		}
		
	}
}
