package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class H_LastPage {

	WebDriver driver;
	WebDriverWait wait;
	FlipkartLocators loc;

	public H_LastPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.loc = new FlipkartLocators(driver);
	}

	public boolean backToHome(String userName) {
		try {
			loc.exitBtn.click();
			wait.until(ExpectedConditions.visibilityOf(loc.homeUserValidation));
			return loc.homeUserValidation.getText().equals(userName);
		} catch (TimeoutException e) {
			return false;
		}
	}
}
