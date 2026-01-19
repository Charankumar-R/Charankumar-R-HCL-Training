package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class LastPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public LastPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	
	public boolean getBackHome() {
		boolean isfound;
		try {
			driver.findElement(Locators.clickExit).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HomePageText));
			String actualText = driver.findElement(Locators.HomePageText).getText();
			isfound = actualText.equals("Bharath");
			return isfound;
		}catch(TimeoutException te) {
			isfound = false;
			return isfound;
		}
	}

}
