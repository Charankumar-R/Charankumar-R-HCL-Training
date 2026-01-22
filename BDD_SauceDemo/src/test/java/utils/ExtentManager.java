package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");

		reporter.config().setReportName("SauceDemo Automation");
		reporter.config().setDocumentTitle("BDD Execution Report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		return extent;
	}
}
