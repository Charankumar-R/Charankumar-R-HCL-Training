package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.Locators;

public class OverviewPage {
	WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickFinish() {
		String verifyOverview = driver.findElement(Locators.verifyOverview).getText();
		Assert.assertEquals(verifyOverview, "Checkout: Overview");
		driver.findElement(Locators.finishButton).click();
	}
}
