package com.selenium.automationpractice.uiActions;

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
	
	public void registration() throws InterruptedException{
		
		auth= new AuthenticationPage(driver);
		auth.createAnAccount();
		System.out.println(driver);
		
	//	new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(titleMrPI));
		
		titleMrPI.click();
		firstNamePI.sendKeys("First Name");
		lastNamePI.sendKeys("Last Name");
		passwordPI.sendKeys("Password1");
		
		new Select(dobDaysPI).selectByValue("3");
		new Select(dobmonthsPI).selectByIndex(5);
		new Select(dobYearsPI).selectByValue("1980");
		
		
		firstNameYA.sendKeys("First Name");
		lastnameYA.sendKeys("Last Name");
		companyYA.sendKeys("ABC");
		address1YA.sendKeys("Address 1");
		address2YA.sendKeys("Address 2");
		cityYA.sendKeys("City Test");
		
		new Select(stateYA).selectByVisibleText("Arizona");
		
		postcodeYA.sendKeys("12123");
		
		new Select(stateYA).selectByValue("21");
		
		additionalInfoYA.sendKeys("Additional info is here");
		mobileYA.sendKeys("1234567890");
		addressaliasYA.sendKeys("My Test Address");
		
		registerButton.click();
		
		
		Thread.sleep(3000);
		
	}
	
	
	
}
