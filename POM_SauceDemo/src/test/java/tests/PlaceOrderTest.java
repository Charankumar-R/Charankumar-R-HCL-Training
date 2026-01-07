package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.Base;

public class PlaceOrderTest extends Base{
	@BeforeClass
	public void setUp() {
		launchBrowser();
	}

	@Test
	public void f() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@AfterClass
	public void afterClass() {
	}

}