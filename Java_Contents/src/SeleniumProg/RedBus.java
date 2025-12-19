package SeleniumProg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver chromedriver = new ChromeDriver();
//		WebDriver chromiumdriver = new ChromeDriver();
//		WebDriver edgedriver = new EdgeDriver();
//		WebDriver firedriver = new FirefoxDriver();
		
		chromedriver.manage().window().maximize();
		chromedriver.get("https://www.redbus.in/");
//		edgedriver.get("https://www.redbus.in/");
//		firedriver.get("https://www.redbus.in/");
//		chromiumdriver.get("https://www.redbus.in/");
		
		//chromedriver.close();
	}

}
