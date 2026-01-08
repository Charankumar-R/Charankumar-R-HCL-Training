package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class takeScreenShotTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void screenShotTest() {

		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("secret_sauce1");

		WebElement login = driver.findElement(By.id("login-button"));
		login.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

		} catch (TimeoutException te) {
			System.out.println("Taking Screenshot for login Failure");
			
			//1. Create Everything Seperatly to assign later
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
			String timeStamp = sdf.format(date);
			
			//2. Create in one line
			String time = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());

			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			File targetDir = new File("screenshot/login" + time + ".png");
			try {
				FileUtils.copyFile(src, targetDir);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
		String actResult = driver.findElement(By.className("title")).getText();

		Assert.assertEquals("Products", actResult);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
