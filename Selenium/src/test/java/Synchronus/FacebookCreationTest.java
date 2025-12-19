package Synchronus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookCreationTest {
	@Test
	public void facebookTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("[id^='u_0_0_']")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Charankumar");
		driver.findElement(By.name("lastname")).sendKeys("R");
		
		
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("18");
	
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByContainsVisibleText("Ma");
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2005");
		
        List<WebElement> radios = driver.findElements(By.id("sex"));
        if (!radios.isEmpty()) {
            WebElement radio1 = radios.get(1);
            radio1.click();
        } 
        
        driver.findElement(By.xpath("//input[starts-with(@id, 'u_0_h_')]")).sendKeys("Charankumar10@gmail.com");
        driver.findElement(By.xpath("//input[starts-with(@id, 'password_step_input')]")).sendKeys("Charan#1001");
    }
}
