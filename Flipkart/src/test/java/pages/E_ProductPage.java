package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class E_ProductPage {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public E_ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.loc = new FlipkartLocators(driver);
    }

    public boolean addToCart() {
        try {
            for (String win : driver.getWindowHandles()) {
                driver.switchTo().window(win);
            }
            wait.until(ExpectedConditions.elementToBeClickable(loc.addToCartBtn)).click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
