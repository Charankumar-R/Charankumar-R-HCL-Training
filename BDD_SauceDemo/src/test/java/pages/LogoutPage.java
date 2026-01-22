package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class LogoutPage {

    private WebDriverWait wait;
    private Locators locator;

    public LogoutPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean validateLogout() {
        try {
        	locator.menuBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.logoutBtn));
            locator.logoutBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.loginButton));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
