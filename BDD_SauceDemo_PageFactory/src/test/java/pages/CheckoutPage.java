package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class CheckoutPage {

    private WebDriverWait wait;
    private Locators locator;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean clickCheckout() {
        try {
        	locator.checkoutBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.pageTitle));
            return locator.pageTitle.getText().equals("Checkout: Your Information");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
