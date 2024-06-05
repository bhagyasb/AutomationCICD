package bhagya.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Demo.pagobjects.CartPage;

public class AbstractComponent {

	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	public void goToCartPage() throws InterruptedException {
		Thread.sleep(4000);
		cart.click();
		
	}
}
