package SeleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorDemo {

    @Test
    public void f() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");

        WebElement emailField = driver.findElement(By.cssSelector("#username"));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("DummyPassword123");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn__primary--large"));
        signInButton.click();

        System.out.println("CSS Selector with id and class demonstrated on LinkedIn login page.");

        //driver.quit();
    }
}
