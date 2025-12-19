package Assingments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SimpleMultiSelect {

    @Test
    public void multiSelectTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://demo.mobiscroll.com/select/multiple-select");

        WebElement input = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("multiple-select-input"))
        );
        input.sendKeys(Keys.ENTER);
        //input.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".mbsc-popup-anchored")
        ));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".mbsc-scroller-wheel-item[role='option']")
        ));

        List<WebElement> options = driver.findElements(
                By.cssSelector(".mbsc-scroller-wheel-item[role='option']")
        );

        List<String> toSelect = Arrays.asList("Books", "Movies, Music & Games", "Health & Beauty", "Sports & Outdoors");

        for (WebElement op : options) {
            if (op.isDisplayed()) {          
                String text = op.getText().trim();
                if (toSelect.contains(text)) {
                    op.click();
                }
            }
        }

        input.sendKeys(Keys.ESCAPE);

        //driver.quit();
    }
}
