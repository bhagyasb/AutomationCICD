package Demo.pagobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bhagya.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	 By checkout=By.cssSelector(".totalRow button");
	
	
	 public  List<WebElement> CartProductList() throws InterruptedException { 
		  Thread.sleep(1000);
	  return cartproducts;
	  
	  }

	public CheckOut cartProducts(String ProductName) throws InterruptedException {
//		boolean match = CartProductList().stream()
//				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(ProductName));
		Thread.sleep(7000);
		Actions a= new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
		a.click(ele).build().perform();
		
//		Assert.assertTrue(match);
		CheckOut checkout=new CheckOut(driver);
		return checkout;

	}

}
