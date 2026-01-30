package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {

    // Login Page
    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = ".submit-button")
    public WebElement loginButton;

    @FindBy(css = "[data-test='title']")
    public WebElement pageTitle;

    // Product Selection
    @FindBy(id = "item_4_title_link")
    public WebElement productLink;

    @FindBy(id = "back-to-products")
    public WebElement backToProducts;

    // Add to Cart
    @FindBy(id = "add-to-cart")
    public WebElement addToCartBtn;

    @FindBy(id = "remove")
    public WebElement removeBtn;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartIcon;

    // Checkout
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    // Customer Information
    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    // Overview
    @FindBy(id = "finish")
    public WebElement finishBtn;

    // Logout
    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutBtn;
}
