package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	protected WebDriver driver;
	protected Properties prop;
	protected WebDriverWait wait;

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

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void takeScreenShot(String step) {
		String time = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File targetDir = new File("screenshot/stepFailed" + time + ".png");
		try {
			FileUtils.copyFile(src, targetDir);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@BeforeClass
	public void setUp() {
		launchBrowser();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}