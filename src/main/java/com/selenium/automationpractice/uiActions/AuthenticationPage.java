package com.selenium.automationpractice.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.automationpractice.testBase.Testbase;

public class AuthenticationPage extends Testbase{

	
	
	@FindBy(id="email")
	WebElement loginEmail;
	
	@FindBy(id="passwd")
	WebElement loginPass;
	
	@FindBy(id="SubmitLogin")
	WebElement submitLoginBtn;
	
	@FindBy(id="email_create")
	WebElement emailAddressForAccountCreation;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccountButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	
	public AuthenticationPage(WebDriver driver){
		//this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	
	Homepage homepage;
	
	public void loginToApplication(String emailAddress, String password) throws InterruptedException{
		
		homepage= new Homepage(driver);
		homepage.clickOnSignInLink();
		//Thread.sleep(5000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(loginEmail));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//log.info("Clicked on SignIn and Object is "+signIn.toString());
		loginEmail.sendKeys(emailAddress);
		loginPass.sendKeys(password);
		submitLoginBtn.click();
		//log.info("Clicked on Submit button and Object is "+submitLoginBtn.toString());
				
	}
	
	public String getInvalidLoginText(){
		//log.info("Error message is  "+authenticationFailed.getText().toString());
		return authenticationFailed.getText();
		
	}
	
	public void createAnAccount(String email){
		homepage = new Homepage(driver);
		homepage.clickOnSignInLink();
		
		//new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(emailAddressForAccountCreation));
		emailAddressForAccountCreation.sendKeys(email);
		createAnAccountButton.click();

	}
	
	
}
