package com.selenium.automationpractice.registration;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.ITestResult;

import com.selenium.automationpractice.excelManage.ExcelManage;
import com.selenium.automationpractice.testBase.Testbase;
import com.selenium.automationpractice.uiActions.RegistrationPage;


public class TC_02_registration extends Testbase {

	RegistrationPage regPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
     init();

	}
	
	@DataProvider(name="regData")
	public Object[][] regdata() throws IOException
	{
		return getData("TestData","RegData");
	}
	
	@Test(dataProvider="regData")	
	public void verifyRegistration(String email, String fName, String lName,String password, String day, String month, 
			String year, String company, String address1, String address2, String city, String state, 
			String postcode,String country,String additionalInfo, String mobNo, String addressAlias ) throws Exception 
	{
		try{
		test= extent.createTest("verifyLoginWithInvalidCredentails");
		test.info("Test info1 is here");
		regPage = new RegistrationPage(driver);
		regPage.registration(email, fName, lName, password, day, month, year, company, address1, address2, 
				city, state, postcode, country, additionalInfo, mobNo, addressAlias );
		regPage.getScreenshot("verifyRegistration");
		test.info("Test info2 is here");
		
		}catch (Exception e1) {
				
				e1.printStackTrace();
				throw(e1);
			}
					
		
		
	}
	
//	@Test
//	public void test1(){
//		System.out.println("test 1 is running");
//		test.info("Test info2 is here");
//	}
//	
//	@Test
//	public void test2(){
//		System.out.println("test 2 is running");
//		test.info("test 2 is running");
//	}
//	
//	@Test
//	public void test3(){
//		System.out.println("test 3 is running");
//		test.info("test 3 is running");
//	}
	
	@AfterMethod
	public void endTest(ITestResult result) throws IOException{
		
		getResult(result);
		//driver.close();
		
	}
	
	
}
