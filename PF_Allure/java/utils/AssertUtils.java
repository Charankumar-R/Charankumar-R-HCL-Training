package utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AssertUtils {

	private static int stepIndex = 0;
	private static final Logger log = Logger.getLogger(AssertUtils.class);

	public static void assertStep(boolean condition, WebDriver driver, ExtentTest extTest, String passMsg,
			String failMsg, List<String> steps) {

		if (condition) {
			Reporter.generateReport(driver, extTest, Status.PASS, passMsg);
			log.info(passMsg); // ✅ Log4j
			stepIndex++;
		} else {
			Reporter.generateReport(driver, extTest, Status.FAIL, failMsg);
			log.error("TEST FAILED: " + failMsg); // ✅ Log4j

			// log skipped steps to BOTH Extent and Log4j
			for (int i = stepIndex + 1; i < steps.size(); i++) {
				String skipMsg = steps.get(i) + " skipped due to previous failure";

				Reporter.generateReport(driver, extTest, Status.SKIP, skipMsg);
				log.warn(skipMsg); // ✅ THIS WAS MISSING
			}

			// ⛔ stop execution
			throw new AssertionError(failMsg);
		}
	}

	public static void reset() {
		stepIndex = 0;
	}
}
