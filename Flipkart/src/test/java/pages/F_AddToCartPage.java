package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class F_AddToCartPage {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public F_AddToCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.loc = new FlipkartLocators(driver);
    }

    public boolean placeOrder() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loc.placeOrderBtn)).click();
            wait.until(ExpectedConditions.visibilityOf(loc.deliveryAddressBtn));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
