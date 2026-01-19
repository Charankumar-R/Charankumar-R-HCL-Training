package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class Login {
	private WebDriver driver;
	WebDriverWait wait;

	public Login(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
	}
	public boolean Loginmethod()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']"))).click();
		
		
		boolean isFound;
		try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()='Request OTP']")));
		String actualResult = driver.findElement(Locators.reqButton).getText();
		isFound=actualResult.equals("Request OTP");
		return isFound;
		}
		catch(TimeoutException te)
		{
			isFound=false;
			return isFound;
		}

	}
}
