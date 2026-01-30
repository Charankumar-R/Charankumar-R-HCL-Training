package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class C_SearchPage {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public C_SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        this.loc = new FlipkartLocators(driver);
    }

    public boolean searchProduct(String product) {
        try {
            wait.until(ExpectedConditions.visibilityOf(loc.searchBox))
                .sendKeys(product);
            loc.searchIcon.click();
            wait.until(ExpectedConditions.visibilityOf(loc.searchResultHeader));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
