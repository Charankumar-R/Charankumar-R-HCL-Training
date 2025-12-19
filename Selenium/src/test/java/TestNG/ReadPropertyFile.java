package TestNG;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.PropertyReader;

public class ReadPropertyFile {
	WebDriver driver;
	@Test
	public void testProperty() {
		
		Properties prop = PropertyReader.readProperty();
		String browserName = prop.getProperty("Browser");
		String url = prop.getProperty("URL");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name: " + browserName);
			return;
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
