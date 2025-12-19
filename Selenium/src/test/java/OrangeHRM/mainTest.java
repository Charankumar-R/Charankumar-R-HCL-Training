package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class mainTest {
	@Test
	public void f() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("");
	}
}
