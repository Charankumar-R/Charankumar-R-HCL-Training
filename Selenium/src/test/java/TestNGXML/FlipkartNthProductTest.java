package TestNGXML;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlipkartNthProductTest {

    @Test
    public void flipkartNthProductTest() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.flipkart.com/");

        searchAndPrintNthProduct(driver, wait, "Laptop", 7);
        searchAndPrintNthProduct(driver, wait, "TV", 13);
        searchAndPrintNthProduct(driver, wait, "Smart Phone", 2);

        driver.quit();
    }

    private void searchAndPrintNthProduct(WebDriver driver, WebDriverWait wait,
                                          String productName, int n) {


        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(By.name("q")));

        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("div[data-id]"), n - 1));

        List<WebElement> cards = driver.findElements(By.cssSelector("div[data-id]"));

        System.out.println();
        System.out.println("Searching for: " + productName);
        System.out.println("Total product cards: " + cards.size());

        if (cards.size() < n) {
            System.out.println("Less than " + n + " produc̥ts available for: " + productName);
            return;
        }

        WebElement nthCard = cards.get(n - 1);
        WebElement titleLink = nthCard.findElement(By.cssSelector("a[href*='/p/']"));

        String nthProductName = titleLink.getText().trim();

        System.out.println("The " + n + "th product is:");
        System.out.println(nthProductName);
    }
}