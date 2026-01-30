package stepdefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.SimpleEmailSender;

public class Hooks {

	// ===== Selenium =====
	public static WebDriver driver;
	public static WebDriverWait wait;

	// ===== Extent =====
	public static ExtentSparkReporter extSparkReporter;
	public static ExtentReports extReports;
	public static ExtentTest extTest;

	@Before
	public void beforeScenario(Scenario scenario) {

		// -------- Extent setup (ONCE per scenario) --------
		extSparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(extSparkReporter);

		extTest = extReports.createTest(scenario.getName());

		// -------- Chrome options --------
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--headless=new"); // remove if UI needed

		// -------- Driver init --------
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.get("https://www.flipkart.com/");
	}

	@After
	public void afterScenario(Scenario scenario) {
//		driver.quit();
		extReports.flush();
		// -------- Send Email --------
		SimpleEmailSender.sendReport();
	}
}
