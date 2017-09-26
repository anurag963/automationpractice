package com.selenium.automationpractice.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.automationpractice.testBase.Testbase;

public class Homepage extends Testbase{

	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	public Homepage(WebDriver driver){
		//this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink(){
		signIn.click();
		
	}
	
	
	
	
	
}
