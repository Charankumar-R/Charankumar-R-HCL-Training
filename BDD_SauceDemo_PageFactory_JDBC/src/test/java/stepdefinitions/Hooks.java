package stepdefinitions;

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
import utils.DBUtils;
import utils.SimpleEmailSender;
import utils.TestContext;

public class Hooks {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentSparkReporter extSparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");;
	public static ExtentReports extReports = new ExtentReports();
	public static ExtentTest extTest;

	@Before
	public void beforeScenario(Scenario scenario) {

		extReports.attachReporter(extSparkReporter);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--headless=new");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		DBUtils.connect();
	}

	@After
	public void afterScenario(Scenario scenario) {
        DBUtils.close();
		driver.quit();
		extReports.flush();
		SimpleEmailSender.sendReport(); // email
	}
}
