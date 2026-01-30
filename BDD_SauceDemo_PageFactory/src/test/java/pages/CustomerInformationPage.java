package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.*;

public class CustomerInformationPage {

    private WebDriverWait wait;
    private Locators locator;

    public CustomerInformationPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        locator = new Locators();
        PageFactory.initElements(driver, locator);
    }

    public boolean addCustomerDetails(String first, String last, String pin) {
        try {
        	locator.firstName.sendKeys(first);
        	locator.lastName.sendKeys(last);
        	locator.postalCode.sendKeys(pin);
            locator.continueBtn.click();
            wait.until(ExpectedConditions.visibilityOf(locator.pageTitle));
            return locator.pageTitle.getText().equals("Checkout: Overview");
        } catch (TimeoutException e) {
            return false;
        }
    }
}
