package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class LoginPage extends DriverManager {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver(),DriverManager.driver);
	}

	@FindBy(xpath="//input[@name='email']")
	public WebElement username_locator;
	
	@FindBy(name = "password")
	public WebElement password_locator;

	@FindBy(xpath = "//div[normalize-space()='Login']")
	public WebElement loginBtn_locator;
	
	// PageFactory Initialization
	
	
	

	
	

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
		if(username_locator.isDisplayed())
			username_locator.sendKeys(username);
	}

}
