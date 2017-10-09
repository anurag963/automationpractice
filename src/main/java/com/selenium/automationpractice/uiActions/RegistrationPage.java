package com.selenium.automationpractice.uiActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.automationpractice.testBase.Testbase;

public class RegistrationPage extends Testbase {

	@FindBy(id="id_gender2")
	WebElement titleMrPI;
	
	@FindBy(id="customer_firstname")
	WebElement firstNamePI;
	
	@FindBy(id="customer_lastname")
	WebElement lastNamePI;
	
	@FindBy(id="email")
	WebElement emailPI;
	
	@FindBy(id="passwd")
	WebElement passwordPI;
	
	@FindBy(id="days")
	WebElement dobDaysPI;
	
	@FindBy(id="months")
	WebElement dobmonthsPI;
	
	@FindBy(id="years")
	WebElement dobYearsPI;
	
	
	
	@FindBy(id="firstname")
	WebElement firstNameYA;
	
	@FindBy(id="lastname")
	WebElement lastnameYA;
	
	@FindBy(id="company")
	WebElement companyYA;
	
	@FindBy(id="address1")
	WebElement address1YA;
	
	@FindBy(id="address2")
	WebElement address2YA;
	
	@FindBy(id="city")
	WebElement cityYA;
	
	@FindBy(id="postcode")
	WebElement postcodeYA;
	
	@FindBy(id="id_state")
	WebElement stateYA;
	
	@FindBy(id="id_country")
	WebElement countryYA;
	
	@FindBy(id="other")
	WebElement additionalInfoYA;
	
	@FindBy(id="phone")
	WebElement phoneYA;
	
	@FindBy(id="phone_mobile")
	WebElement mobileYA;
	
	@FindBy(id="alias")
	WebElement addressaliasYA;
	
	@FindBy(id="submitAccount")
	WebElement registerButton;
	
	
	public RegistrationPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	AuthenticationPage auth;
	
	public void registration(String email,String fName, String lName,String password, String day, String month, 
			String year, String company, String address1, String address2, String city, String state, 
			String postcode,String country,String additionalInfo, String mobNo, String addressAlias  ) throws IOException{
		
		auth= new AuthenticationPage(driver);
		auth.createAnAccount(email);
		System.out.println(driver);
		
	//	new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(titleMrPI));
		
		test.info("Test info1 is here");
		titleMrPI.click();
		test.info("Selected on title radio button");
		firstNamePI.sendKeys(fName);
		test.info("Entered first name in text box of presonal info");
		lastNamePI.sendKeys(lName);
		test.info("Entered last name in text box of presonal info");
		passwordPI.sendKeys(password);
		test.info("Entered password");
		
		new Select(dobDaysPI).selectByValue(day);
		test.info("Selected date");
		new Select(dobmonthsPI).selectByValue(month);
		//new Select(dobmonthsPI).selectByIndex(5);
		test.info("Selected month");
		new Select(dobYearsPI).selectByValue(year);
		test.info("Selected year");
		
		
		firstNameYA.sendKeys(fName);
		test.info("Entered first name in text box of your address");
		lastnameYA.sendKeys(lName);
		test.info("Entered last name in text box of your address");
		companyYA.sendKeys(company);
		test.info("Entered Company name");
		address1YA.sendKeys(address1);
		test.info("Entered address1");
		address2YA.sendKeys(address2);
		test.info("Entered address2");
		cityYA.sendKeys(city);
		test.info("Entered city");
		
		new Select(stateYA).selectByVisibleText(state);
		test.info("Selected state");
		
		postcodeYA.sendKeys(postcode);
		test.info("Selected postcode");
		
		//new Select(countryYA).selectByValue("21");
		new Select(countryYA).selectByVisibleText(country);
		test.info("Selected country");
		
		additionalInfoYA.sendKeys(additionalInfo);
		test.info("Entered additional info");
		mobileYA.sendKeys(mobNo);
		test.info("Entered mob no");
		addressaliasYA.sendKeys(addressAlias);
		test.info("Entered addressAlias");
		getScreenshot("verifyRegistration");
		
		registerButton.click();
		test.info("Clicked on regestration button");
		
		//Thread.sleep(3000);
		
	}
	
	
	
}
