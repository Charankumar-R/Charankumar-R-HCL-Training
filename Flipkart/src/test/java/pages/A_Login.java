package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class A_Login {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public A_Login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.loc = new FlipkartLocators(driver);
    }

    public boolean loginPopupOpen() {
        try {
            // 1️⃣ Wait until element is visible
            wait.until(ExpectedConditions.visibilityOf(loc.loginBtn));

            // 2️⃣ Scroll into view (IMPORTANT for headless)
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", loc.loginBtn);

            // 3️⃣ Try normal click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(loc.loginBtn)).click();
            } catch (Exception e) {
                // 4️⃣ Fallback → JS click (industry standard)
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", loc.loginBtn);
            }

            // 5️⃣ Validate OTP button appears
            wait.until(ExpectedConditions.visibilityOf(loc.requestOtpBtn));

            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}
