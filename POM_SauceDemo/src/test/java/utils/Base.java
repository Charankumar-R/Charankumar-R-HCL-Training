package utils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	protected WebDriver driver;
	Properties prop;

	public void launchBrowser() {

		String browserName = null;
		String url = null;
		prop = PropertyReader.readProperty();
		browserName = prop.getProperty("Browser");
		url = prop.getProperty("URL");

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);

		if (browserName.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("Edge")) {

			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(options);

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}
}