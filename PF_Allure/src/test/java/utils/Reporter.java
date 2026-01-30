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


		if (status == Status.PASS) {
			extTest.pass(stepMessage);
			Allure.step(stepMessage);			
			
		} else if (status == Status.FAIL) {

			if (driver != null) {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

				extTest.fail(stepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
				Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");

			} else {
				extTest.fail(stepMessage + " (Driver was null, screenshot not captured)");
			}
			Allure.step(stepMessage);
		} else if (status == Status.SKIP) {
			extTest.skip(stepMessage);
			Allure.step(stepMessage);
		}

	}

}
