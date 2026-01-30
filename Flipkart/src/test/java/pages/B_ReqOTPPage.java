package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class B_ReqOTPPage {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public B_ReqOTPPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.loc = new FlipkartLocators(driver);
    }

    public boolean requestOtp(String mobile) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            wait.until(ExpectedConditions.visibilityOf(loc.mobileNumber))
                .sendKeys(mobile);
            loc.requestOtpBtn.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
