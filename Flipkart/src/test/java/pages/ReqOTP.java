package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.Locators;

public class ReqOTP {
	private WebDriver driver;
	WebDriverWait wait;

	public ReqOTP(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
	}
	public boolean Reqmethod()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c3Bd2c"))).sendKeys("7200217417");
		driver.findElement(By.xpath("//div/button[text()='Request OTP']")).click();
		boolean isFound;
		try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
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
