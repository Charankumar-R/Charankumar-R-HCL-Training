package TestNGXML;
import org.testng.annotations.Test;

public class Flipkart {
  
  @Test(groups = {"New", "Not"})
  public void fLogin() {
	  System.out.println("This is  Flipkart Login Page");
  }

  @Test(groups = {"New", "More"})
  public void fSearchProduct() {
	  System.out.println("This is Flipkart Search Page");
  } 
  
  @Test(groups = {"Not", "Some"})
  public void fSelectProduct() {
	  System.out.println("This is Flipkart Display products page");
  }
  
}

