package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlipkartLocators;

public class D_ProductsPage {

    WebDriver driver;
    WebDriverWait wait;
    FlipkartLocators loc;

    public D_ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.loc = new FlipkartLocators(driver);
    }

    public boolean selectNthProduct(int n) {
        try {
            loc.productCards.get(n - 1).click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
