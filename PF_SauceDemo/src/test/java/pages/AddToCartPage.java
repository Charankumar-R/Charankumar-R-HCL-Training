package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class AddToCartPage {

    private WebDriverWait wait;
    private Locators locator;

    public AddToCartPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean clickAddToCart() {
        try {
        	locator.addToCartBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.removeBtn));
            return locator.removeBtn.getText().equals("Remove");
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean clickCartIcon() {
        try {
        	locator.cartIcon.click();
            wait.until(ExpectedConditions.visibilityOf(locator.pageTitle));
            return locator.pageTitle.getText().equals("Your Cart");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
