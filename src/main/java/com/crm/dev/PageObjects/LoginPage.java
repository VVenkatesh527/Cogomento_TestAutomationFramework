package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.dev.utility.Log;

public class LoginPage extends DriverManager {

	// Locators
	@FindBy(xpath="//input[@name='email']")
	public WebElement username_locator;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password_locator;

	@FindBy(xpath = "//div[normalize-space()='Login' and contains(@class,'submit button')]")
	public WebElement loginBtn_locator;
	
	// PageFactory Initialization
	
     public LoginPage(WebDriver driver) {
    	 
    	PageFactory.initElements(driver, this);
    	 
     }
	
	// identifying re-usable methods
     
	public  void launchCogmentoApplication() {
		
	    
		String username = null, password = null;
		if (getInputProperty("username") != null) {
			username = getInputProperty("username");
		}
		
		if (getInputProperty("password") != null) {
			password = getInputProperty("password");
		}
		
		driver().get(getInputProperty("url"));
		Log.info("Navigated to " +driver().getCurrentUrl());
		if(username_locator.isDisplayed())
			username_locator.sendKeys(username);
		
		Log.info("Entered Username as " +username);
		
		if(password_locator.isDisplayed())
			password_locator.sendKeys(password);
		
		Log.info("Entered Password as " +password);
		loginBtn_locator.click();
		Log.info("Clicked on " +loginBtn_locator.getAttribute("innerText"));
		
	}
	
}