package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
	private WebDriver driver;
	WebDriverWait wait;

	public Search(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait = wait;
	}
	public boolean Searchmethod()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"lNPl8b\"]"))).sendKeys("Laptop");
		driver.findElement(By.cssSelector("[class=\"kV1UjG\"]")).click();
		boolean isFound;
		try {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"GD4sye ECYCDD\"]")));
		String actualResult = driver.findElement(By.xpath("//a[@class=\"GD4sye ECYCDD\"]")).getText();
		isFound=actualResult.equals("Laptop");
		return isFound;
		}
		catch(TimeoutException te)
		{
			isFound=false;
			return isFound;
		}

	}

}
