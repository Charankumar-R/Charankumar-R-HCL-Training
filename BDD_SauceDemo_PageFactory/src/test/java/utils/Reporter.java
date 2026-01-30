package utils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Allure;

public class Reporter {

	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {

		// -------- PASS --------
		if (status == Status.PASS) {
			extTest.pass(stepMessage);
			Allure.step(stepMessage);
		}

		// -------- FAIL --------
		else if (status == Status.FAIL) {

			if (driver != null) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

				// Extent screenshot
				extTest.fail(stepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(
						((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());

				// Allure screenshot
				Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");

			} else {
				extTest.fail(stepMessage + " (Driver was null)");
			}

			Allure.step(stepMessage);
		}

		// -------- SKIP --------
		else if (status == Status.SKIP) {
			extTest.skip(stepMessage);
			Allure.step(stepMessage);
		}
	}
}
