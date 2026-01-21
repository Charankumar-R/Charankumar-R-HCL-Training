package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class OverviewPage {

    private WebDriverWait wait;
    private Locators locator;

    public OverviewPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean clickFinish() {
        try {
        	locator.finishBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.pageTitle));
            return locator.pageTitle.getText().equals("Checkout: Complete!");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
