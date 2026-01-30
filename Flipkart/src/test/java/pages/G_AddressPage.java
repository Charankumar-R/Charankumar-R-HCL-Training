package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class G_AddressPage {

	WebDriver driver;
	WebDriverWait wait;
	FlipkartLocators loc;

	public G_AddressPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.loc = new FlipkartLocators(driver);
	}

	public boolean confirmAddress() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(loc.deliveryAddressBtn)).click();
			wait.until(ExpectedConditions.elementToBeClickable(loc.continueBtn)).click();

			try {
				wait.until(ExpectedConditions.elementToBeClickable(loc.acceptAndContinueBtn)).click();
			} catch (Exception ignored) {
				// Button may not always appear
			}

			// ✅ Correct validation
			wait.until(ExpectedConditions.visibilityOf(loc.paymentPageTitle));

			return loc.paymentPageTitle.getText().equalsIgnoreCase("Complete Payment");

		} catch (Exception e) {
			return false;
		}
	}
}
