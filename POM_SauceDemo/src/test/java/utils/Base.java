package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	protected WebDriver driver;
	protected Properties prop;
	protected WebDriverWait wait;
	protected ExtentSparkReporter extSparkReporter;
	protected ExtentReports extReports;
	protected ExtentTest extTest;
	protected static Logger log = Logger.getLogger(Base.class);

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

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);

	}

	@BeforeClass
	public void setUp() {

		AssertUtils.reset();   
		
	    extSparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
	    extReports = new ExtentReports();
	    extReports.attachReporter(extSparkReporter);

	    extTest = extReports.createTest(getClass().getSimpleName());

	    launchBrowser();
	}


	@AfterClass
	public void afterClass() {

	    if (extReports != null) {
	        extReports.flush();
	    }

	    if (driver != null) {
	        driver.quit();
	    }
	}

}