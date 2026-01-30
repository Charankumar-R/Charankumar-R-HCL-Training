package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class SelectProductPage {

    private WebDriverWait wait;
    private Locators locator;

    public SelectProductPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean selectProduct() {
        try {
        	locator.productLink.click();
            wait.until(ExpectedConditions.visibilityOf(locator.backToProducts));
            return locator.backToProducts.getText().equals("Back to products");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
