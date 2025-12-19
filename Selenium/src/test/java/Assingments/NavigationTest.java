package Assingments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigationTest {

    @Test
    public void navigationTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        driver.navigate().to("https://www.youtube.com");

        driver.navigate().back();

        driver.navigate().to("https://www.google.com");

        driver.navigate().refresh();

        //driver.quit();
        
    }
}
