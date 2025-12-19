package AlertHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandlingTest {
	@Test
	public void alertHandlingTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//ul/li[1]/button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		driver.findElement(By.xpath("//ul/li[2]/button")).click();
		alert.dismiss();
		
		driver.findElement(By.xpath("//ul/li[3]/button")).click();
		alert.sendKeys("Hi");
		alert.accept();
	}
}
