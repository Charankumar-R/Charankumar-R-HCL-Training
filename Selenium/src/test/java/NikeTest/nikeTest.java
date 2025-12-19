package NikeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class nikeTest {

	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void productSearch() {
		Actions actions = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//a[contains(text(), 'Men')]"));
		actions.moveToElement(menu).perform();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'shoes')])[1]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shoes"))).click();
		
		WebElement product24 = driver.findElement(By.xpath("//div[@data-product-position='124']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView()", product24);
		
//		String nth_title = driver.findElement(By.xpath("//div[@data-product-position='24']//div//figure//a")).getText();
		String nth_title_with_price = driver.findElement(By.xpath("//div[@data-product-position='124']")).getText();
		
//		System.out.println(nth_title);
		System.out.println(nth_title_with_price);
		
		driver.findElement(By.xpath("//div[@data-product-position='124']")).click();

	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nike.com/in/");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
