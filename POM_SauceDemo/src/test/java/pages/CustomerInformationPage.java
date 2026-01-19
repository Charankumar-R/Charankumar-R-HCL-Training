package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class CustomerInformationPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CustomerInformationPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean addCustomerDetails(String first, String last, String pin) {
		boolean isFound;
		try {
			driver.findElement(Locators.informationFirstName).sendKeys(first);
			driver.findElement(Locators.informationLastName).sendKeys(last);
			driver.findElement(Locators.informationPostalCode).sendKeys(pin);
			driver.findElement(Locators.informationConfirm).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyOverview));
			String verifyOverview = driver.findElement(Locators.verifyOverview).getText();
			isFound = verifyOverview.equals("Checkout: Overview");
			return isFound;
		} catch (TimeoutException te) {
			isFound = false;
			return isFound;
		}
	}
}
