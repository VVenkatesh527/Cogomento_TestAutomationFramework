package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class HomePage extends DriverManager {

	@FindBy(xpath = "//b[normalize-space()='Test Automation']")
	public WebElement testAutomationHeader;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//i[@class='pin icon']")
	public WebElement pinIcon;
	
	@FindBy(xpath = "//i[contains(@class,'trash')]")
	public WebElement trashBtn;
	
	@FindBy(xpath = "//i[@class='settings icon']")
	public WebElement settingsIcon;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(HomePage.driver(), driver);
	}
	
	
}
