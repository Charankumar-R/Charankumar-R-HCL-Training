package TestNGXML;

import org.testng.annotations.Test;

public class Amazon {
	@Test (groups = {"Some", "More"})
	public void aLogin() {
		System.out.println("This is Amazon Login Page");
	}

	@Test(groups = {"New", "More"})
	public void aSearchProduct() {
		System.out.println("This is Amazon Search Page");
	}

	@Test(groups = {"Some", "New"})
	public void aSelectProduct() {
		System.out.println("This is Amazon Display products page");
	}
}