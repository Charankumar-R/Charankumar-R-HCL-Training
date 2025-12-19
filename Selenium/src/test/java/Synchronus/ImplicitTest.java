package Synchronus;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitTest {
	@Test
	public void implicitWait() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Time and Memory Consuming So musn't use at any cost also no throws exception
//		Thread.sleep(5000);
		
		
		
		WebElement speaker = driver.findElement(By.id("speakersTxt"));
		System.out.println(speaker.getText());
		driver.quit();
	}
}
