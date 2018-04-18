package ReportGenerate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvancedReporting 
{

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	
	@Test
	public void TestReport()
	{
		report=new ExtentReports("E:\\selenium\\Reports\\learnautomation.html");
		logger=report.startTest("VerifyLogTitle");
		System.setProperty("webdriver.chrome.driver", 
	               "E://selenium//selenium-2.48.2//chromedriver_win32//chromedriver.exe");
		//driver=new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "browser started");
		driver.get("https://testing1007.glodom.local:4026/index.html");
		logger.log(LogStatus.INFO, "Application is up and running");
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("google"));
		logger.log(LogStatus.PASS, "Title Verified");
	}
}
