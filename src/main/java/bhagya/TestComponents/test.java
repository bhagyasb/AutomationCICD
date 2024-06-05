package bhagya.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Demo.pagobjects.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\bhagya\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver.manage().window().setSize(new Dimension(1440,900));
			if(browserName.contains("headless")) {
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	
	@BeforeMethod
	public Base launchApplication() throws IOException {
		driver = initializeDriver();
		Base base = new Base(driver);
		base.goTo();
		return base;
	}
	
	@AfterMethod
	public void logout() {
		driver.quit();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {
		
		String jsonContent=FileUtils.readFileToString(new File(path));
//				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
			  
		  });
		 return data;
		}
}
