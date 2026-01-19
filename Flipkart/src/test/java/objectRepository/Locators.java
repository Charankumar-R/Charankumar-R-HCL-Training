package objectRepository;

import org.openqa.selenium.By;

public class Locators {
	public static String name;
	
	public static By reqButton = By.xpath("//div/button[text()='Request OTP']");
	
	
	
	//Charan
	
	public static By productSelection = By.xpath("(//div[contains(@class,'T6hTMI')])[1]");
	
	public static By productDetails = By.xpath("//span[contains(normalize-space(.),'ASUS Vivobook S16')]");
	public static By addToCart = By.cssSelector("[class=\"dSM5Ub ugg2XR IUmgrZ\"]");
	
	public static By placeOrderButton = By.cssSelector("[class=\"dSM5Ub JMrpad KcXDCU\"]");
	
	
	
	//Bharath
	
	public static  By HomePageText = By.xpath("//a[span[text()='"+name+"']]/span");
	// delivery here btn
	public static By Deliveryaddress = By.cssSelector("[class=\"dSM5Ub gRSEA4 KcXDCU\"]");
	// continue button after delivery here btn
	public static By continuebtn =  By.cssSelector("[class=\"dSM5Ub tzUB8K KcXDCU\"]");
	public static By AcceptAndContinue = By.cssSelector("[class=\"dSM5Ub ZjNM9b KtnAdx\"]");
	
	public static By CheckPaymentValidateText = By.xpath("//h5[text()='Complete Payment']");
	
	
	public static By clickExit = By.cssSelector("[fdprocessedid=\"j554f9\"]");

}