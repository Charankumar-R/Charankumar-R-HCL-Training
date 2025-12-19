package SeleniumAssignments;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	@Test
	public void f() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser name (chrome / edge / firefox): ");
		String browserName = sc.nextLine();
		sc.close();

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name: " + browserName);
			return;
		}

		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/"); 

		System.out.println("Opened URL: " + driver.getCurrentUrl());
		System.out.println("Page title: " + driver.getTitle());

		driver.quit();
	}
}