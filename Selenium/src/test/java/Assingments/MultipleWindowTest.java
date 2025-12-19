package Assingments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindowTest  {
  @Test
  public void multipleWindowTest() {

      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.get("https://rahulshettyacademy.com/AutomationPractice/");

      String parentWindow = driver.getWindowHandle();

      driver.findElement(By.id("openwindow")).click();

      Set<String> windows1 = driver.getWindowHandles();

      for (String win : windows1) {
          if (!win.equals(parentWindow)) {
              driver.switchTo().window(win);
              System.out.println("Open Window Title: " + driver.getTitle());
              driver.close();
              break;
          }
      }

      driver.switchTo().window(parentWindow);

      driver.findElement(By.id("opentab")).click();

      Set<String> windows2 = driver.getWindowHandles();

      for (String win : windows2) {
          if (!win.equals(parentWindow)) {
              driver.switchTo().window(win);
              System.out.println("Open Tab Title: " + driver.getTitle());
              driver.close();
              break;
          }
      }

      driver.switchTo().window(parentWindow);

      driver.quit();
  }
}
