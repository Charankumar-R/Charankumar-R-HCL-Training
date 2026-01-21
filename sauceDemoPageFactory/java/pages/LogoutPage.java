package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class LogoutPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LogoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean validateLogout() {
		try {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
			driver.findElement(By.id("logout_sidebar_link")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginButton));
			return true;
		} catch (TimeoutException te) {
			return false;
		}
		
	}
}
