package Demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Base{
	
		 WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver=driver;	
	}
	


	 driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sbhagya685@gmail.com");




}
