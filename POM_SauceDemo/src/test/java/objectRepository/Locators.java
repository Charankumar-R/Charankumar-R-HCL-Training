package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	
	//Locators for Login Page
	public static  By userName = By.id("user-name");
	public static By password = By.name("password");
	public static By loginButton = By.cssSelector(".submit-button");
	public static By verifyLogin = By.cssSelector("[data-test='title']");
	
	//Locator for Select Product Page
	public static By selectProduct = By.id("item_4_title_link");
	public static By verifySelectProduct = By.cssSelector("[id='back-to-products']");

	
	//Locators for Add to Cart Page
	public static By addToCart = By.id("add-to-cart");
	public static By cartIcon = By.id("shopping_cart_container");
	public static By verifyAddToCart = By.id("remove");
	public static By verifyCartIcon = By.cssSelector("[data-test='shopping-cart-badge']");
	public static By verifyCartPage = By.cssSelector("[data-test='title']");
	
	//Locators for Checkout Page
	public static By checkout = By.id("checkout");
	public static By verifyCheckout = By.cssSelector("[data-test='title']");
	
	//Locators for Customer Information Page
	public static By verifyInformationPage = By.cssSelector("[data-test='titles']");
	public static By informationFirstName = By.id("first-name");
	public static By informationLastName = By.id("last-name");
	public static By informationPostalCode= By.id("postal-code");
	public static By informationConfirm= By.id("continue");
	
	//Locators for Overview Page
	public static By verifyOverview = By.cssSelector("[data-test='titles']");
	public static By finishButton = By.id("finish");
	
	//Locators for Logout Page
	public static By verifyLogoutPage = By.cssSelector("[data-test='title']");
	public static By menuButton = By.id("react-burger-menu-btn");
	public static By logoutButton = By.id("logout_sidebar_link");
	
}
