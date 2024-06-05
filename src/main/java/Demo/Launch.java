package Demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Demo.pagobjects.Base;
import Demo.pagobjects.CartPage;
import Demo.pagobjects.CheckOut;
import Demo.pagobjects.productCatalogue;
import bhagya.TestComponents.test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch extends test  {

	WebDriver driver;
	String ProductName = "ZARA COAT 3";
	
	@Test(dataProvider="getData" , groups="purchaseorder")
	public void Login(HashMap<String,String> input) throws IOException {
		Base base=launchApplication();
		productCatalogue productcatalogue = base.loginApplication(input.get("username"),input.get("password"));
	}
	
	
	
	
	

	
   public  String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
	   
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    File file=new File(System.getProperty("user.dir") + "//reports//" +testcaseName+ ".png");
	    FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" +testcaseName+ ".png";
	}
	
	
//	@Test
//	public void submitOrder() throws IOException, InterruptedException {
//		Base base = launchApplication();
//		productCatalogue productcatalogue = base.loginApplication("sbhagya685@gmail.com", "bhagB@99");
//		List<WebElement> products = productcatalogue.getProductList();
//		productcatalogue.getProductName(ProductName);
//		CartPage cartpage = productcatalogue.addProductToCart(ProductName);
//		productcatalogue.goToCartPage();
//		CheckOut checkout = cartpage.cartProducts(ProductName);
//		Thread.sleep(5000);
//		checkout.cxheckout();
//
//	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		  Map<String,String> map=new HashMap<String,String>();
//		  map.put("username", "sbhagya685@gmail.com");
//		  map.put("password", "bhagB@99");
//		  
//		  Map<String,String> map1=new HashMap<String,String>();
//		  map.put("username", "bhagyabalakrishna04@gmail.com");
//		  map.put("password", "bhagB@99");
		List<HashMap<String,String>> data;
		
	 data=getJsonDataToMap((System.getProperty("user.dir")+"\\src\\main\\java\\bhagya\\data\\PurchaseOrder.json"));
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	

}
