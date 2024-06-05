package Demo;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch  {
	

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver  driver;
		String ProductName="ZARA COAT 3";
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	  driver.get("https://rahulshettyacademy.com/client");
	  driver.manage().window().maximize();
	  
	     Base base=new Base(driver);
	  

//	  driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sbhagya685@gmail.com");
	  driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("bhagB@99");
	  driver.findElement(By.xpath("//input[@id='login']")).click();
	  
	  Thread.sleep(15000);
	  
	      List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	      
	 WebElement  prod = products.stream().filter(product->
	 product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findAny().orElse(null);
	
	 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	 
	  Thread.sleep(5000);
	  driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	  
	  List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	  
	  boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(ProductName));
	  
	  driver.findElement(By.cssSelector(".totalRow button")).click();
	  Assert.assertTrue(match);
	  
	  Actions a=new Actions(driver);
	  a.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")),"India").build().perform();
	  
	    WebElement cvv = driver.findElement(By.xpath("(//input[@class='input txt'])[1]"));
	    cvv.sendKeys("123");
	    
	    WebElement NameOnTheCard = driver.findElement(By.xpath("(//input[@class='input txt'])[2]"));
	    NameOnTheCard.sendKeys("abc");
	    
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    
	  

	}

}
