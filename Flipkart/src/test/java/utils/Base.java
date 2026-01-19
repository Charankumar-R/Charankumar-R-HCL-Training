package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	protected WebDriver driver;
	protected Properties prop;
	protected WebDriverWait wait;
	
	public void launchBrowser() {
		prop = PropertyReader.readProperty();
		String browserName = prop.getProperty("Browser");
		String url = prop.getProperty("URL");
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@BeforeClass
	public void setUp() {
		
	}
	
	@AfterClass
	public void tearDown() {
		
	}
	
	@BeforeMethod
	public void setUpMethod() {
		launchBrowser();
//		AssertUtils.reset();
	}
	
	@AfterMethod
	public void tearDownMethod() {
		driver.quit();
	}
}
