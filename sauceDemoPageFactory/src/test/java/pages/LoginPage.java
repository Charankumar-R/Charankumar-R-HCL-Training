package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class LoginPage {

    private WebDriverWait wait;
    private Locators locator;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean validateLogin(String user, String pwd) {
        try {
        	locator.userName.sendKeys(user);
        	locator.password.sendKeys(pwd);
        	locator.loginButton.click();
            wait.until(ExpectedConditions.visibilityOf(locator.pageTitle));
            return locator.pageTitle.getText().equals("Products");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
