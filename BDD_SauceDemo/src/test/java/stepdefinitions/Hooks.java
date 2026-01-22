package stepdefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentTest scenarioTest;

	@Before
	public void beforeScenario(Scenario scenario) {

		extent = ExtentManager.getInstance();
		scenarioTest = extent.createTest(scenario.getName());

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}

	@AfterStep
	public void afterEachStep(Scenario scenario) {

		if (scenario.isFailed()) {
			String base64 = ScreenshotUtil.captureBase64(driver);
			scenarioTest.fail("Step Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
		}
	}

	@After
	public void afterScenario(Scenario scenario) {

		if (!scenario.isFailed()) {
			scenarioTest.pass("Scenario passed successfully");
		}

		driver.quit();
		extent.flush();
	}
}
