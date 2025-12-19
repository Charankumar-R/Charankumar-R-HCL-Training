package TestNGXML;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AnchorHrefPrint {
	@Test
	public void f() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://github.com/");

		List<WebElement> anchorTags = driver.findElements(By.tagName("a"));
		System.out.println("List of href values:");

		for (WebElement link : anchorTags) {
			try {
                String href = link.getAttribute("href");
                if (href != null && !href.isBlank()) {
                    System.out.println(href);
                }
            } catch (StaleElementReferenceException e) {
                // If element becomes stale, just skip this one
            }
		}
		System.out.println("\nTotal number of <a> tags: " + anchorTags.size());

		driver.quit();
	}
}
