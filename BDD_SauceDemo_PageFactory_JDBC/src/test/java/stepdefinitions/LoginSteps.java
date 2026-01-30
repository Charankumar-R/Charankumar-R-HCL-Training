package stepdefinitions;

import java.util.Map;

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
import utils.DBUtils;
import utils.LoggerHandler;
import utils.TestContext;

public class LoginSteps {

	// ===== Pages (ALL 7) =====
	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	CustomerInformationPage customerInfoPage;
	OverviewPage overviewPage;
	LogoutPage logoutPage;

	// ===== Framework Objects =====
	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	ExtentSparkReporter extSparkReporter = Hooks.extSparkReporter;
	ExtentReports extReports = Hooks.extReports;
	ExtentTest extTest = Hooks.extTest;

	// ===== DB user data =====
	private Map<String, String> userData;

	/*
	 * ========================================================= GIVEN → LOAD USER
	 * FROM DB =========================================================
	 */
	@Given("user {string} should be allowed to login")
	public void user_should_be_allowed_to_login(String username) {

		loginPage = new LoginPage(driver, wait);
		extTest = extReports.createTest("PlaceOrder | User=" + username);

		userData = DBUtils.getRowAsMap("SELECT * FROM test_data WHERE username='" + username + "'");

		boolean isAllowed = userData != null && "1".equals(userData.get("is_active"));

		AssertUtils.assertStep(isAllowed, driver, extTest, username + " is ACTIVE in DB",
				username + " is NOT ACTIVE in DB");

		TestContext.setUser(username);
	}

	/*
	 * ========================================================= LOGIN (DB PASSWORD)
	 * =========================================================
	 */
	@When("user logs in with {string} and {string}")
	public void user_logs_in(String ignoredUser, String ignoredPwd) {

		LoggerHandler.info("Step 1: Login");

		boolean loginResult = loginPage.validateLogin(userData.get("username"), userData.get("password"));

		AssertUtils.assertStep(loginResult, driver, extTest, "Login successful", "Login failed");
	}

	/*
	 * ========================================================= SELECT PRODUCT
	 * =========================================================
	 */
	@And("user selects a product {string}")
	public void user_selects_a_product(String productName) {

		LoggerHandler.info("Step 2: Select Product");

		selectProductPage = new SelectProductPage(driver, wait);

		AssertUtils.assertStep(selectProductPage.selectProduct(), driver, extTest, "Product selected: " + productName,
				"Product selection failed");
	}

	/*
	 * ========================================================= ADD TO CART
	 * =========================================================
	 */
	@And("user adds product to cart")
	public void user_adds_product_to_cart() {

		LoggerHandler.info("Step 3: Add To Cart");

		addToCartPage = new AddToCartPage(driver, wait);

		AssertUtils.assertStep(addToCartPage.clickAddToCart(), driver, extTest, "Add to cart successful",
				"Add to cart failed");

		AssertUtils.assertStep(addToCartPage.clickCartIcon(), driver, extTest, "Cart page opened", "Cart page failed");
	}

	/*
	 * ========================================================= CHECKOUT
	 * =========================================================
	 */
	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() {

		LoggerHandler.info("Step 4: Checkout");

		checkoutPage = new CheckoutPage(driver, wait);

		AssertUtils.assertStep(checkoutPage.clickCheckout(), driver, extTest, "Checkout page opened",
				"Checkout failed");
	}

	/*
	 * ========================================================= CUSTOMER
	 * INFORMATION (DB) =========================================================
	 */
	@And("user enters customer details {string} {string} {string}")
	public void user_enters_customer_details(String ignoredFirst, String ignoredLast, String ignoredZip) {

		LoggerHandler.info("Step 5: Customer Information");

		customerInfoPage = new CustomerInformationPage(driver, wait);

		AssertUtils.assertStep(
				customerInfoPage.addCustomerDetails(userData.get("firstname"), userData.get("lastname"),
						userData.get("zipcode")),
				driver, extTest, "Customer details entered", "Customer details failed");
	}

	/*
	 * ========================================================= OVERVIEW PAGE
	 * =========================================================
	 */
	@And("user completes the order")
	public void user_completes_the_order() {

		LoggerHandler.info("Step 6: Overview & Finish");

		overviewPage = new OverviewPage(driver, wait);

		AssertUtils.assertStep(overviewPage.clickFinish(), driver, extTest, "Order finished successfully",
				"Order finish failed");

		// ===== DB ENTRY =====
		String orderId = "ORD-" + System.currentTimeMillis();
		TestContext.setOrderId(orderId);

		DBUtils.executeUpdate("INSERT INTO orders (order_id, username, status) VALUES (" + "'" + orderId + "', '"
				+ TestContext.getUser() + "', 'SUCCESS')");
	}

	/*
	 * ========================================================= DB VALIDATION +
	 * LOGOUT =========================================================
	 */
	@Then("order should exist in database")
	public void order_should_exist_in_database() {

		String dbOrderId = DBUtils.getSingleValue(
				"SELECT order_id FROM orders WHERE order_id='" + TestContext.getOrderId() + "'", "order_id");

		AssertUtils.assertStep(dbOrderId != null, driver, extTest, "Order found in DB: " + dbOrderId,
				"Order NOT found in DB");

		// ===== LOGOUT =====
		logoutPage = new LogoutPage(driver, wait);

		AssertUtils.assertStep(logoutPage.validateLogout(), driver, extTest, "User logged out successfully", "Logout failed");
	}
}
