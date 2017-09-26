package com.selenium.automationpractice.testBase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestClass {

	public  ExtentHtmlReporter htmlReporter;
	public  ExtentReports extent;
	public  ExtentTest test;
	
	@BeforeTest
	public void before(){
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/testReport/MytestReport.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "Window");
		extent.setSystemInfo("Sys", "Anurag");
		
		htmlReporter.config().setDocumentTitle("Learn Extent report");
		htmlReporter.config().setReportName("My Report");
		
		}
	
	
	
	@Test
	public void test1(){
		
		test= extent.createTest("Demo Test 1");
		Assert.assertTrue(true);
		
	}
	@Test
	public void test2(){
		
		test= extent.createTest("Demo Test 2");
		Assert.assertTrue(false);
		
	}
	@Test
	public void test3(){
		
		test= extent.createTest("Demo Test 2 Skip");
		throw new SkipException("Skiped test");
		
	}
	
	@AfterMethod
	public void after(ITestResult result){
			if(result.getStatus()==ITestResult.SUCCESS){
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Testcase passed", ExtentColor.GREEN));
				
			}
			else if(result.getStatus()==ITestResult.FAILURE){
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Testcase Failed", ExtentColor.RED));
				test.fail(result.getThrowable());
			}
			else {
				test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Testcase Skipped", ExtentColor.YELLOW));
				test.skip(result.getThrowable());
			}
			
			
			
		}
	
	@AfterTest
	public void teardown(){
		extent.flush();
	}
	
	
}
