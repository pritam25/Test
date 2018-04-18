package gloEMR;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class LoginToEmr 
{
	public static void main(String args[]) throws MalformedURLException, Exception
	{
		DesktopOptions options=new DesktopOptions();
		options.setApplicationPath("E:\\Builds\\9010\\gloEMR\\gloEMR.exe");
		Thread.sleep(2000);
		WiniumDriver winDriver=new WiniumDriver(new URL("http://localhost:9999"), options);
		By.name("gloClientUpdates Manager");
		winDriver.findElement(By.name("ok")).click();
		
		winDriver.findElement(By.id("txtUserName")).sendKeys("admin");
	}
}
