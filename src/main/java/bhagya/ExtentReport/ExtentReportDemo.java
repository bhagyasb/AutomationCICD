package bhagya.ExtentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	@Test
	public static ExtentReports config() {
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Bhagya");
//	extent.createTest(path);
	return extent;
	
	}

}
