package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objectRepository.Locators;

public class LogoutPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public LogoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void validateLogout() {
		String verifySelectProduct = driver.findElement(Locators.verifySelectProduct).getText();
		Assert.assertEquals(verifySelectProduct, "Back Home");
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
}
