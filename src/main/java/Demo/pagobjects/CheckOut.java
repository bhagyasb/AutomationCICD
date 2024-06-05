package Demo.pagobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhagya.AbstractComponent.AbstractComponent;

public class CheckOut extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		super(driver);
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='input txt text-validated'])[2]")
	WebElement Country;
	
	@FindBy(xpath="(//input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy(xpath="(//input[@class='input txt'])[2]")
	WebElement NameOnTheCard;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	
	
	public void cxheckout() {
		Actions a = new Actions(driver);
		a.sendKeys(Country, "India").build()
				.perform();
		cvv.sendKeys("123");
		NameOnTheCard.sendKeys("abc");
		placeOrder.click();
	}

}
