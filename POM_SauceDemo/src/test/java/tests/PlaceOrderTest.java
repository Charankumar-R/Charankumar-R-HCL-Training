package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;
import utils.Base;

public class PlaceOrderTest extends Base{

	@Test
	public void testPlaceOrder() {
		//1. Login step
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.validateLogin("standard_user","secret_sauce");
		
		//2. Select product step
		SelectProductPage selectProductPage = new SelectProductPage(driver);
		selectProductPage.selectProduct();
		
		//3. Add to cart step
		AddToCartPage addToCardPage = new AddToCartPage(driver);
		addToCardPage.clickAddToCart();
		addToCardPage.clickCartIcon();
		
		//4. Checkout Page
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.clickCheckout();
		
		//5. Customer Information Page
		CustomerInformationPage customerInformationPage = new CustomerInformationPage(driver);
		customerInformationPage.addCustomerDetails();
		
		//6. Overview Page
		OverviewPage overviewPage = new OverviewPage(driver);
		overviewPage.clickFinish();
		
		//7. Logout Page
		LogoutPage logout = new LogoutPage(driver, wait);
		logout.validateLogout();
		
	}
}
