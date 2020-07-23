package QAClickAcadamey.ExtentReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentXReporter;
public class ExtentReportDemo {
	
	//Declaring globally..
	ExtentReports extent;

	
@BeforeTest 
public void config()
{
	//We have to create obj for bot ExtentReports and ExtentSparkReporter..
	 
	//create a path for the reports like user.dir so that it will create the extent reports in the project folder...
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	
	//create an obj for the ExtentXReporter and give the path name..
	ExtentXReporter reporter = new ExtentXReporter(path);
	
	//config the helper class report results name...
	reporter.config().setReportName("Web Automation Results");
	
	//create object for the main class...
	ExtentReports extent = new ExtentReports();
	
	//attach the helper class report with this main class..
	extent.attachReporter(reporter);
	
	//set the tester name..
	extent.setSystemInfo("Tester", "Krish Srivatsav");
	
	
}
	
	
	
@Test
public void intialDemo()
	{
	
	//ExtentReports extent is globally declared on the top..
	//So that now we can use it inside the @Test..
	extent.createTest("intialDemo");
	
	System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.rahulshettyacademy.com");

	System.out.println(driver.getTitle());
	
	driver.close();
	
	extent.flush();
	

		
	}

}
