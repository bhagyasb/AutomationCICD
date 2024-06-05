package Demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Demo.pagobjects.Base;
import Demo.pagobjects.CartPage;
import Demo.pagobjects.productCatalogue;
import bhagya.TestComponents.test;

public class addtoCart {

	WebDriver driver;
	String ProductName = "ZARA COAT 3";

	@Test(groups= {"Smoke"})
	public void ProductValidation() throws IOException, InterruptedException {
		test t=new test();
		Base base = t.launchApplication();
		productCatalogue productcatalogue = base.loginApplication("sbhagya685@gmail.com", "bhagB@99");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.getProductName(ProductName);
		CartPage cartpage = productcatalogue.addProductToCart(ProductName);
		productcatalogue.goToCartPage();
	}

	@Test
	public void getProductName() throws IOException, InterruptedException {
		test t=new test();
		Base base = t.launchApplication();
		productCatalogue productcatalogue = base.loginApplication("sbhagya685@gmail.com", "bhagB@99");
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.getProductName(ProductName);
		productcatalogue.addProductToCart(ProductName);

	}

}
