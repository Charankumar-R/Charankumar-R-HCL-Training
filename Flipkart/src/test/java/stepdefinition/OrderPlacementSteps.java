package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.A_Login;
import pages.B_ReqOTPPage;
import pages.C_SearchPage;
import pages.D_ProductsPage;
import pages.E_ProductPage;
import pages.F_AddToCartPage;
import pages.G_AddressPage;
import pages.H_LastPage;
import utils.AssertUtils;

public class OrderPlacementSteps {

	A_Login login;
	B_ReqOTPPage otp;
	C_SearchPage search;
	D_ProductsPage products;
	E_ProductPage product;
	F_AddToCartPage cart;
	G_AddressPage address;
	H_LastPage last;

	@Given("user opens Flipkart application")
	public void open_app() {
		// Browser launch handled in Hooks
	}

	@When("user logs in with {string}")
	public void user_logs_in(String mobile) {

		login = new A_Login(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(login.loginPopupOpen(), Hooks.driver, Hooks.extTest, "Login popup opened",
				"Login popup failed");

		otp = new B_ReqOTPPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(otp.requestOtp(mobile), Hooks.driver, Hooks.extTest, "OTP requested successfully",
				"OTP request failed");
	}

	@And("user searches product {string}")
	public void user_searches_product(String productName) {

		search = new C_SearchPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(search.searchProduct(productName), Hooks.driver, Hooks.extTest,
				"Product searched: " + productName, "Product search failed");
	}

	@And("user selects {string} product from results")
	public void user_selects_product(String nth) {

		products = new D_ProductsPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(products.selectNthProduct(Integer.parseInt(nth)), Hooks.driver, Hooks.extTest,
				"Selected product number " + nth, "Product selection failed");
	}

	@And("user adds product to cart")
	public void user_adds_product_to_cart() {

		product = new E_ProductPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(product.addToCart(), Hooks.driver, Hooks.extTest, "Product added to cart",
				"Add to cart failed");
	}

	@And("user proceeds to checkout")
	public void user_proceeds_to_checkout() {

		cart = new F_AddToCartPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(cart.placeOrder(), Hooks.driver, Hooks.extTest, "Place Order clicked",
				"Place Order failed");
	}

	@And("user enters customer details")
	public void user_enters_customer_details() {

		address = new G_AddressPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(address.confirmAddress(), Hooks.driver, Hooks.extTest, "Address confirmed",
				"Address confirmation failed");
	}

	@And("user completes the order")
	public void user_completes_the_order() {
		// Payment validation already handled in Address page
	}

	@Then("user should be logged out successfully")
	public void user_should_be_logged_out_successfully() {

		last = new H_LastPage(Hooks.driver, Hooks.wait);
		AssertUtils.assertStep(last.backToHome("Bharath"), Hooks.driver, Hooks.extTest, "Returned to home page",
				"Logout / Home validation failed");
	}
}
