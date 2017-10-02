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
	public void verifyRegistration(String fName, String lName,String password, String day, String month, 
			String year, String company, String address1, String address2, String city, String state, 
			String postcode,String country,String additionalInfo, String mobNo, String addressAlias ) 
	{
		try{
		test= extent.createTest("verifyLoginWithInvalidCredentails");
		regPage = new RegistrationPage(driver);
		regPage.registration(fName, lName, password, day, month, year, company, address1, address2, 
				city, state, postcode, country, additionalInfo, mobNo, addressAlias );
		regPage.getScreenshot("verifyRegistration");
		}catch (AssertionError e) {
			
			try {
				getScreenshot("verifyRegistration");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, "verifyRegistration");
		} catch (Exception e) {
			
			try {
				getScreenshot("verifyRegistration");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, "verifyRegistration");
		}
		
		
	}
	
	@AfterMethod
	public void endTest(){
		
		driver.close();
		
	}
	
	
}
