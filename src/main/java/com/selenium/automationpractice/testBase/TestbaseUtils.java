package com.selenium.automationpractice.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.automationpractice.excelManage.ExcelManage;

public class TestbaseUtils {
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
	
	
	
	public String[][] getData(String excelname, String sheetName ) throws IOException{
		ExcelManage obj= new ExcelManage();
		return obj.excelRead(excelname, sheetName);
		
	}
	
	
	@AfterTest
	public void finishExtentReport(){
		extent.flush();
		
	}
	
	
	
}
