package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.Locators;

public class CustomerInformationPage {
	WebDriver driver;
	public CustomerInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addCustomerDetails() {
		String verifyInformationPage = driver.findElement(Locators.verifyInformationPage).getText();
		Assert.assertEquals(verifyInformationPage, "Checkout: Your Information");
		driver.findElement(Locators.informationFirstName).sendKeys("Charankumar");
		driver.findElement(Locators.informationLastName).sendKeys("R");
		driver.findElement(Locators.informationPostalCode).sendKeys("631001");
		driver.findElement(Locators.informationConfirm).click();
	}
}
