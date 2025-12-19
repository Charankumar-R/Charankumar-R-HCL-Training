package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon {

    @Test
    public void f() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");

            // Wait for and click the "Sign in" / main button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement goin = wait.until(
                    ExpectedConditions.elementToBeClickable(By.className("a-button-text")));
            goin.click();

            // Wait until anchors are present after navigation / DOM change
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));

            List<WebElement> anchorTags = driver.findElements(By.tagName("a"));

            for (int i = 0; i < anchorTags.size(); i++) {
                //try {
                    WebElement link = anchorTags.get(i);
                    // getAttribute is enough for href
                    String href = link.getAttribute("href");
                    if (href != null && !href.isBlank()) {
                        System.out.println(href);
//                    }
//                } catch (StaleElementReferenceException e) {
//                    // If this element became stale, refetch anchors and retry this index
//                    anchorTags = driver.findElements(By.tagName("a"));
//                    i--; // step back one position to retry with fresh reference
                }
            }
        } finally {
            driver.quit();
        }
    }
}
