package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean validateLogin(String user, String pwd) {
		driver.findElement(Locators.userName).sendKeys(user);
		driver.findElement(Locators.password).sendKeys(pwd);
		driver.findElement(Locators.loginButton).click();

		boolean isFound;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.verifyLogin));
			String actResult = driver.findElement(Locators.verifyLogin).getText();
			isFound = actResult.equals("Products");
			return isFound;
		} catch (TimeoutException te) {
			isFound = false;
			return isFound;
		}

	}
}
