package AlertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFramesTest {
	@Test
	public void frameHandleTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/7/docs/api/");
		
		System.out.println(driver.findElements(By.tagName("frame")).size());
		System.out.println(driver.findElement(By.tagName("frame")).getDomAttribute("src"));
	
//		driver.switchTo().frame(2);
		driver.switchTo().frame("classFrame");
		System.out.println(driver.findElement(By.cssSelector("div>h1")).getText());
	}
}
