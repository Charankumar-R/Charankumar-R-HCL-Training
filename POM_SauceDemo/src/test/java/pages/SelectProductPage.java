package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.Locators;

public class SelectProductPage {
	WebDriver driver;

	public SelectProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectProduct() {
		driver.findElement(Locators.selectProduct).click();
		String verifySelectProduct = driver.findElement(Locators.verifySelectProduct).getText();
		Assert.assertEquals(verifySelectProduct, "Back to products");
	}
}
