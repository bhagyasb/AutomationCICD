package Demo.pagobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhagya.AbstractComponent.AbstractComponent;

public class productCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public productCatalogue(WebDriver driver) {
		super(driver);
		 this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
	

	  @FindBy(css=".mb-3")
	   List<WebElement> products;
	  
	  
	  By addToCart=By.cssSelector(".card-body button:last-of-type");
	
	  
	  
	  public  List<WebElement> getProductList() throws InterruptedException { 
		  Thread.sleep(15000);
	  return products;
	  
	  }
	  
	  public WebElement getProductName(String ProductName) throws InterruptedException {
		  WebElement  prod = getProductList().stream().filter(product->
			 product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findAny().orElse(null);
		 return prod; 
	  }
	  
	  public CartPage addProductToCart(String ProductName) throws InterruptedException {
		 WebElement prod=getProductName(ProductName);
		 prod.findElement(addToCart).click();
		 CartPage cartpage = new CartPage(driver);
		 return cartpage;
	  }
}
