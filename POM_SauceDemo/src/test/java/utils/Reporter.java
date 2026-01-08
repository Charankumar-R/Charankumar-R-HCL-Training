package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {
	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {

		if (extTest == null)
			return;

		if (status == Status.PASS) {
			extTest.pass(stepMessage);
		} else if (status == Status.FAIL) {

			if (driver != null) {
				String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

				extTest.fail(stepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
			} else {
				extTest.fail(stepMessage + " (Driver was null, screenshot not captured)");
			}
		} else if (status == Status.SKIP) {
			extTest.skip(stepMessage);
		}

	}

}
