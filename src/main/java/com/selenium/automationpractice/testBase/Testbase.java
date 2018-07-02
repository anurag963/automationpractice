package com.selenium.automationpractice.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testbase {
	public static WebDriver driver;
	public String browser;
	public String url;

	public Properties propertiesData;
	public File propFile;
	public FileInputStream propFis;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	static{
		Calendar calender= Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports();
		
	}
	
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


	@BeforeTest
	public void initializeExtentReport(){
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/testReport/MytestReport.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Sys", "Anurag");
		
		htmlReporter.config().setDocumentTitle("Learn Extent report");
		htmlReporter.config().setReportName("My Report");
		
		}
	
	
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Testcase passed", ExtentColor.GREEN));
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Testcase Failed", ExtentColor.RED));
			
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Testcase Skipped", ExtentColor.YELLOW));
			test.fail("Test case failed");
			test.skip(result.getThrowable());
		}
		
	}
	
	public void getScreenshot(String imageName) throws IOException
	{
		if(imageName.isEmpty())
		{
			imageName="blank";
		}
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageSavePath= System.getProperty("user.dir")+"/screenshots/";
		
		Calendar calender= Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImage= imageSavePath+imageName+formater.format(calender.getTime())+".png";
		File desctFile= new File(actualImage);
		
		FileUtils.copyFile(image, desctFile);
		
		
		
	}
	
	
	
	@AfterTest
	public void finishExtentReport(){
		extent.flush();
		
	}
	
	
	
}
