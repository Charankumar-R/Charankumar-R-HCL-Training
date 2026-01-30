package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertUtils {

	private static final Logger log = Logger.getLogger(AssertUtils.class);

	public static void assertStep(boolean condition, WebDriver driver, ExtentTest extTest, String passMsg,
			String failMsg) {

		if (condition) {
			Reporter.generateReport(driver, extTest, Status.PASS, passMsg);
			log.info(passMsg); // ✅ Log4j
		} else {
			Reporter.generateReport(driver, extTest, Status.FAIL, failMsg);
			log.error("TEST FAILED: " + failMsg);
			io.qameta.allure.Allure.step("Test failed: " + failMsg);
			io.qameta.allure.Allure.addAttachment("Failure Reason", failMsg);
			throw new AssertionError(failMsg); // 🔴 THIS causes Allure failure
		}

	}
}
