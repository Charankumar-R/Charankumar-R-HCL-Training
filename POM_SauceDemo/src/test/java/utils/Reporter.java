package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {

//	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
//		if (status.equals(Status.PASS)) {
//			System.out.println("The step: " + stepMessage + " is passed");
//			extTest.log(status, stepMessage);
//		} else if (status.equals(Status.FAIL)) {
//			System.out.println("The step: " + stepMessage + " is failed");
//			String screenShotError = getScreenShotImage(driver, stepMessage);
//			extTest.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenShotError).build());
//			extTest.log(status, stepMessage,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotError).build());
//		}
//	}
//
//	public static String getScreenShotImage(WebDriver driver, String error) {
//
//		String time = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());
//
//		String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
//
//		TakesScreenshot screen = (TakesScreenshot) driver;
//		File src = screen.getScreenshotAs(OutputType.FILE);
//
//		String screenshotPath = screenshotDir + "login_" + time + "_" + error + ".png";
//		File target = new File(screenshotPath);
//
//		try {
//			FileUtils.copyFile(src, target);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return screenshotPath;
//	}
//	

	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {

		if (status == Status.PASS) {
			extTest.pass(stepMessage);
		} else if (status == Status.FAIL) {
			String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			extTest.fail(stepMessage, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
		}
	}
}
