package Demo.pagobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhagya.AbstractComponent.AbstractComponent;

public class Base extends AbstractComponent {
	
	
   WebDriver driver;
   
   public Base(WebDriver driver) {
	   super(driver);
	   this.driver=driver;
	  PageFactory.initElements(driver, this);
	   
   }
	
    @FindBy(id="userEmail")
    WebElement userEmail;
    
    @FindBy(id="userPassword")
    WebElement Password;
    
    @FindBy(id="login")
    WebElement submit;
    
    public productCatalogue loginApplication(String email,String password) {
    	userEmail.sendKeys(email);
    	Password.sendKeys(password);
    	submit.click();
    	productCatalogue productcatalogue = new productCatalogue(driver);
    	return productcatalogue;
    }  
    
    public void goTo() {
    	driver.get("https://rahulshettyacademy.com/client");
    	
    }
    
    
    
}