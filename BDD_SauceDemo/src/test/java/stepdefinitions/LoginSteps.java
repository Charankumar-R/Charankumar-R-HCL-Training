package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;
import utils.AssertUtils;
import utils.LoggerHandler;

public class LoginSteps {

	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	CustomerInformationPage customerInfoPage;
	OverviewPage overviewPage;
	LogoutPage logoutPage;

	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	ExtentSparkReporter extSparkReporter = Hooks.extSparkReporter;
	ExtentReports extReports = Hooks.extReports;
	ExtentTest extTest = Hooks.extTest;

	@Given("user opens SauceDemo application")
	public void user_opens_sauce_demo_login_page() {
		loginPage = new LoginPage(driver, Hooks.wait);
	}

	@When("user logs in with {string} and {string}")
	public void user_logs_in(String username, String password) {
		extTest = extReports.createTest("PlaceOrderTest | User=" + username);
		LoggerHandler.info("Step 1: Login");
		AssertUtils.assertStep(new LoginPage(driver, wait).validateLogin(username, password), driver, extTest,
				"Login successful", "Login failed");
	}

	@And("user selects a product {string}")
	public void user_selects_a_product(String string) {
		LoggerHandler.info("Step 2: Select Product");
		AssertUtils.assertStep(new SelectProductPage(driver, wait).selectProduct(), driver, extTest,
				"Product Page opened successfully", "Product unavailable");

	}

	@And("user adds product to cart")
	public void user_adds_product_to_cart() {
        addToCartPage = new AddToCartPage(driver, wait);

		LoggerHandler.info("Step 3: Add To Cart");
		AssertUtils.assertStep(addToCartPage.clickAddToCart(), driver, extTest, "Add to Cart button working",
				"Add to Cart failed");

		LoggerHandler.info("Step 4: Cart Page");
		AssertUtils.assertStep(addToCartPage.clickCartIcon(), driver, extTest, "Cart page shown",
				"Cart page not processing");
	}

	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
		LoggerHandler.info("Step 5: Checkout");
		AssertUtils.assertStep(new CheckoutPage(driver, wait).clickCheckout(), driver, extTest, "Checkout page opened",
				"Checkout failed");
	}

	@And("user enters customer details {string} {string} {string}")
	public void user_enters_customer_details(String first, String last, String pin) {
		LoggerHandler.info("Step 6: Customer Information");
		AssertUtils.assertStep(new CustomerInformationPage(driver, wait).addCustomerDetails(first, last, pin), driver,
				extTest, "Overview page shown", "Customer info failed");

	}

	@And("user completes the order")
	public void user_completes_the_order() {
		LoggerHandler.info("Step 7: Finish Order");
		AssertUtils.assertStep(new OverviewPage(driver, wait).clickFinish(), driver, extTest, "Order completed",
				"Finish failed");

	}

	@Then("user should be logged out successfully")
	public void user_should_be_logged_out() {
		LoggerHandler.info("Step 8: Logout");
		AssertUtils.assertStep(new LogoutPage(driver, wait).validateLogout(), driver, extTest, "Logout successful",
				"Logout failed");

	}
}
//	
//	@Then("login result should be {string}")
//	public void login_result_should_be(String result) {
//
//		if (result.equalsIgnoreCase("success")) {
//
//			Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("inventory"),
//					"Expected successful login but failed");
//
//			Assert.assertEquals(locator.pageTitle.getText(), "Products", "Products title not displayed");
//
//			homePage.logout();
//
//		} else {
//
//			Assert.assertTrue(locator.errorMessage.isDisplayed(), "Expected login failure but error message not shown");
//
//			Assert.assertTrue(locator.errorMessage.getText().contains("Epic sadface"), "Incorrect error message");
//		}
//	}
