package TestMaven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class LoginToPortal 
{
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	@Test
	public void init() throws IOException
	{
		File src=new File("E://selenium//TestPortal.xlsx");
		//String chromeDriver="E\\selenium\\selenium-2.48.2\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium-2.48.2\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheetAt(0);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for(int i=1;i<=sheet.getFirstRowNum();i++)
		{
			
			cell=sheet.getRow(i).getCell(0);
			driver.get(cell.getStringCellValue());
			//cell.setCellType(Cell.CELL_TYPE_STRING);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}
/*	public void SSLCert()
	{
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver=new ChromeDriver(cap);
	}*/
	
	public void Login() throws IOException
	{
		
		File obj_resp=new File(".Object_Respo.properties");
		FileInputStream finput=new FileInputStream(obj_resp);
		Properties pro=new Properties();
		pro.load(finput);
		System.out.println("Property class loaded");
		
		driver.findElement(By.xpath("Portal.login.username.xpath")).sendKeys("pass");
		driver.findElement(By.xpath("Portal.login.password.xpath")).click();
		driver.findElement(By.xpath("Portal.login.submit.xpath")).click();
		driver.switchTo().alert().accept();
	}
}
