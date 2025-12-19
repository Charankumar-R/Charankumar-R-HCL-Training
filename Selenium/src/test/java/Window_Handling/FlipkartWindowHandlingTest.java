package Window_Handling;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlipkartWindowHandlingTest {
	@Test
	public void flipkartHandlingTest() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

		searchBox.sendKeys(Keys.CONTROL + "a");
		searchBox.sendKeys(Keys.DELETE);
		searchBox.sendKeys("asus vivobook s16 oled 2025");
		searchBox.sendKeys(Keys.ENTER);
		
		WebElement lap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='RG5Slk' and contains(text(), 'Snapdragon')]")));
		lap.click();
		
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String handle: allWindow) {
			if(!handle.equals(currentWindow)) {
				driver.switchTo().window(handle);				
			}
		}
		
		driver.findElement(By.xpath("//button[contains(@class, 'IUmgrZ')]")).click();
		
	}
}
