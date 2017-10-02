package com.selenium.automationpractice.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Testbase extends TestbaseUtils {

	
	public void init() throws IOException
	{
		Testbase obj= new Testbase();	
		obj.getBrowser("chrome");
		obj.loadProperties();
		String url= obj.propertiesData.getProperty("url");
		System.out.println(url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	public void getBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");		
			driver= new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");		
			driver= new FirefoxDriver();
		}
		
		
	}

//	public String getURL()
//	{
//		url= "http://automationpractice.com/index.php";
//		return url;
//		
//	}
	
	
	public void loadProperties() throws IOException
	{
		propertiesData= new Properties();
		File propFile= new File(System.getProperty("user.dir")+"/src/main/java/com/selenium/automationpractice/config/config.properties");
		FileInputStream propFis= new FileInputStream(propFile);
		propertiesData.load(propFis);
		
	}
	
	
	
	public void afterMethod(ITestResult result) throws IOException {
		getResult(result);
	}


	public void beforeMethod(Method result) {
		//test = extent.startTest(result.getName());
		//test.log(LogStatus.INFO, result.getName() + " test Started");
	}


	
	
//	@Test
//	public  void test() throws IOException
//	{
//		
//		Testbase obj= new Testbase();	
//		obj.getBrowser("firefox");
//		obj.loadProperties();
//		String url= obj.propertiesData.getProperty("url");
//		System.out.println(url);
//		driver.get(url);
//		obj.getScreenshot("imagename");
//		
//	}
	
	
	
}
