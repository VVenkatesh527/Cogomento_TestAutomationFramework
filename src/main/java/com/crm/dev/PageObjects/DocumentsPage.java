package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class DocumentsPage  extends  DriverManager{
	
	@FindBy(xpath = "//span[contains(text(),'Documents') and @class='item-text']")
	public static WebElement documentsBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Close Date')]//following-sibling::div//input[@type='text']")
	public WebElement closedDateLocator;
	
	public DocumentsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	
}
