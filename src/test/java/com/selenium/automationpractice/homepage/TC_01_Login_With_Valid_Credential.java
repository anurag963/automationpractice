package com.selenium.automationpractice.homepage;



import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.automationpractice.testBase.Testbase;
import com.selenium.automationpractice.uiActions.AuthenticationPage;


public class TC_01_Login_With_Valid_Credential extends Testbase{

	AuthenticationPage authenticationPage;
	
	@BeforeMethod
	public void setUp() throws IOException {
     init();

	}
	
	@Test
	public void verifyLoginWithInvalidCredentails() throws InterruptedException{
		authenticationPage = new AuthenticationPage(driver);
		authenticationPage.loginToApplication("test@test.com","asdfhh");
		
	}
	
//	@AfterClass
//	public void endTest(){
//		driver.close();
//	}
	
	
	
}
