package Synchronus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitTest {
	@Test
	public void implicitWait() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/flights.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explcit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement dropdown = driver.findElement(By.id("FromSector_show"));
		dropdown.click();
		
		WebElement input = driver.findElement(By.id("a_FromSector_show"));
		input.sendKeys("Beng");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='fromautoFill']/ul/li[1]")));
		driver.findElement(By.xpath("//div[@id='fromautoFill']/ul/li[1]")).click();
		
		
//		WebElement dropdownTo = driver.findElement(By.id("Editbox13_show"));
//		dropdownTo.click();
		
		WebElement inputTo = driver.findElement(By.id("a_Editbox13_show"));
		inputTo.sendKeys("Chen");
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("spnChennai")));
		driver.findElement(By.id("spnChennai")).click();
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("fiv_3_31/12/2025")));
		driver.findElement(By.id("fiv_3_31/12/2025")).click();
		
		driver.findElement(By.id("rdatelbl")).click();
		
		driver.findElement(By.id("fst_5_02/01/2026")).click();
		
		driver.findElement(By.id("trvlr_colm")).click();
				
		driver.findElement(By.xpath("//button[contains(@class,'plus_box1')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'plus_boxChd')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'plus_box1Inf')]")).click();
		
		driver.findElement(By.id("rbFirst")).click();
		
		
	}
}
