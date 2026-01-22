package stepdefinitions;

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

public class LoginSteps {

	LoginPage loginPage;
    SelectProductPage selectProductPage;
    AddToCartPage addToCartPage;
    CheckoutPage checkoutPage;
    CustomerInformationPage customerInfoPage;
    OverviewPage overviewPage;
    LogoutPage logoutPage;

	@Given("user opens SauceDemo application")
	public void user_opens_sauce_demo_login_page() {
		loginPage = new LoginPage(Hooks.driver, Hooks.wait);
		Hooks.scenarioTest.info("User logged in successfully");

	}

	@When("user logs in with {string} and {string}")
	public void user_logs_in(String username, String password) {
	    boolean result = loginPage.validateLogin(username, password);
	    Hooks.scenarioTest.info("Attempting login with user: " + username);

	    if (!result) {
	        Hooks.scenarioTest.fail("Login failed");
	        throw new AssertionError("Login failed");
	    }
	}


	@And("user selects a product {string}")
	public void user_selects_a_product(String string) {
		selectProductPage = new SelectProductPage(Hooks.driver, Hooks.wait);
		boolean result = selectProductPage.selectProduct();
		if (!result) {
			throw new AssertionError("Product selection failed");
		}
	}

    @And("user adds product to cart")
    public void user_adds_product_to_cart() {
        addToCartPage = new AddToCartPage(Hooks.driver, Hooks.wait);

        if (!addToCartPage.clickAddToCart()) {
            throw new AssertionError("Add to cart failed");
        }

        if (!addToCartPage.clickCartIcon()) {
            throw new AssertionError("Cart page not opened");
        }
    }


    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkoutPage = new CheckoutPage(Hooks.driver, Hooks.wait);
        boolean result = checkoutPage.clickCheckout();
        if (!result) {
            throw new AssertionError("Checkout failed");
        }
    }

    @And("user enters customer details {string} {string} {string}")
    public void user_enters_customer_details(String first, String last, String pin) {
        customerInfoPage = new CustomerInformationPage(Hooks.driver, Hooks.wait);
        boolean result = customerInfoPage.addCustomerDetails(first, last, pin);
        if (!result) {
            throw new AssertionError("Customer information step failed");
        }
    }


    @And("user completes the order")
    public void user_completes_the_order() {
        overviewPage = new OverviewPage(Hooks.driver, Hooks.wait);
        boolean result = overviewPage.clickFinish();
        if (!result) {
            throw new AssertionError("Order completion failed");
        }
    }


    @Then("user should be logged out successfully")
    public void user_should_be_logged_out() {
        logoutPage = new LogoutPage(Hooks.driver, Hooks.wait);
        boolean result = logoutPage.validateLogout();
        if (!result) {
            throw new AssertionError("Logout failed");
        }
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
