package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLocators {

    /* =========================
       A. LOGIN PAGE
       ========================= */

	@FindBy(xpath = "//a[@title='Login']")
	public WebElement loginBtn;

    @FindBy(className = "c3Bd2c")
    public WebElement mobileNumber;

    /* =========================
       B. REQUEST OTP PAGE
       ========================= */

    @FindBy(xpath = "//div/button[text()='Request OTP']")
    public WebElement requestOtpBtn;

    @FindBy(xpath = "//a/span")
    public WebElement userLoginValidation;

    /* =========================
       C. SEARCH PAGE
       ========================= */

    @FindBy(css = ".lNPl8b")
    public WebElement searchBox;

    @FindBy(css = ".kV1UjG")
    public WebElement searchIcon;

    @FindBy(xpath = "//a[@class='GD4sye ECYCDD']")
    public WebElement searchResultHeader;

    /* =========================
       D. PRODUCTS PAGE
       ========================= */

    @FindBy(css = "div[data-id]")
    public List<WebElement> productCards;

    /* =========================
       E. PRODUCT DETAILS PAGE
       ========================= */

    @FindBy(xpath = "//span[contains(text(),'ASUS Vivobook')]")
    public WebElement productDetails;

    @FindBy(css = ".dSM5Ub.ugg2XR.IUmgrZ")
    public WebElement addToCartBtn;

    /* =========================
       F. CART PAGE
       ========================= */

    @FindBy(css = ".dSM5Ub.JMrpad.KcXDCU")
    public WebElement placeOrderBtn;

    /* =========================
       G. ADDRESS PAGE
       ========================= */

    @FindBy(css = ".dSM5Ub.gRSEA4.KcXDCU")
    public WebElement deliveryAddressBtn;

    @FindBy(css = ".dSM5Ub.tzUB8K.KcXDCU")
    public WebElement continueBtn;

    @FindBy(css = ".dSM5Ub.ZjNM9b.KtnAdx")
    public WebElement acceptAndContinueBtn;

    /* =========================
       H. PAYMENT PAGE
       ========================= */

    @FindBy(css = "h5[data-testid='page-title']")
    public WebElement paymentPageTitle;

    @FindBy(css = "[fdprocessedid='j554f9']")
    public WebElement exitBtn;

    @FindBy(xpath = "//a/span")
    public WebElement homeUserValidation;

    /* =========================
       CONSTRUCTOR
       ========================= */

    public FlipkartLocators(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
