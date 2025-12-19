package Selenium_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/practice");

        driver.findElement(By.linkText("Home")).click();
        System.out.println("Clicked on link using linkText: Home");
        System.out.println("After Home click, URL = " + driver.getCurrentUrl());


        driver.findElement(By.partialLinkText("Practice")).click();
        System.out.println("Clicked on link using partialLinkText: Practice");
        System.out.println("After Practice click, URL = " + driver.getCurrentUrl());

        //driver.quit();
    }
}
