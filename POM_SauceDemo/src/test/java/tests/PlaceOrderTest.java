package tests;

import java.util.List;

import org.testng.annotations.Test;

import pages.*;
import utils.AssertUtils;
import utils.Base;

public class PlaceOrderTest extends Base {

    @Test
    public void testPlaceOrder() {

        log.info("===== Test Started: PlaceOrderTest =====");

        AssertUtils.reset();

        List<String> steps = List.of(
            "Login",
            "Select Product",
            "Add To Cart",
            "Cart Page",
            "Checkout",
            "Customer Information",
            "Overview",
            "Logout"
        );

        log.info("Step 1: Login");
        AssertUtils.assertStep(
            new LoginPage(driver, wait)
                .validateLogin("standard_user", "secret_sauce"),
            driver, extTest,
            "Login successful", "Login failed",
            steps
        );

        log.info("Step 2: Select Product");
        AssertUtils.assertStep(
            new SelectProductPage(driver, wait).selectProduct(),
            driver, extTest,
            "Product Page opened successfully", "Product unavailable",
            steps
        );

        AddToCartPage cart = new AddToCartPage(driver, wait);

        log.info("Step 3: Add To Cart");
        AssertUtils.assertStep(
            cart.clickAddToCart(),
            driver, extTest,
            "Add to Cart button working", "Add to Cart failed",
            steps
        );

        log.info("Step 4: Cart Page");
        AssertUtils.assertStep(
            cart.clickCartIcon(),
            driver, extTest,
            "Cart page shown", "Cart page not processing",
            steps
        );

        log.info("Step 5: Checkout");
        AssertUtils.assertStep(
            new CheckoutPage(driver, wait).clickCheckout(),
            driver, extTest,
            "Checkout page opened", "Checkout failed",
            steps
        );

        log.info("Step 6: Customer Information");
        AssertUtils.assertStep(
            new CustomerInformationPage(driver, wait).addCustomerDetails(),
            driver, extTest,
            "Overview page shown", "Customer info failed",
            steps
        );

        log.info("Step 7: Finish Order");
        AssertUtils.assertStep(
            new OverviewPage(driver, wait).clickFinish(),
            driver, extTest,
            "Order completed", "Finish failed",
            steps
        );

        log.info("Step 8: Logout");
        AssertUtils.assertStep(
            new LogoutPage(driver, wait).validateLogout(),
            driver, extTest,
            "Logout successful", "Logout failed",
            steps
        );

        log.info("===== Test Completed: PlaceOrderTest =====");
    }
}
