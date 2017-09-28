package com.selenium.automationpractice.registration;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.automationpractice.testBase.Testbase;
import com.selenium.automationpractice.uiActions.RegistrationPage;


public class TC_02_registration extends Testbase {

	RegistrationPage regPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
     init();

	}
	
	@Test
	public void verifyLoginWithInvalidCredentails() throws InterruptedException, IOException{
		regPage = new RegistrationPage(driver);
		regPage.registration();
		regPage.getScreenshot("image1");
		
	}
	
	@AfterMethod
	public void endTest(){
		driver.close();
	}
	
	
}
