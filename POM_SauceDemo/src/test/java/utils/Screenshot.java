package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
		
	public void takeScreenShot(String step, WebDriver driver) {
		String time = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File targetDir = new File("screenshot/stepFailed" + time + ".png");
		try {
			FileUtils.copyFile(src, targetDir);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}