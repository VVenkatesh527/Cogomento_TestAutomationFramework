package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class ContactsPage  extends  DriverManager{
	
	@FindBy(xpath = "//span[normalize-space()='Contacts' and contains(@class,'item-text')]")
	public WebElement contactsBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Contacts' and contains(@class,'select')]")
	public WebElement contactsTitle;
	
	@FindBy(xpath = "//i[contains(@class,'dropdown')]//parent::div[@name='view']")
	public WebElement dropdownBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Default View' and contains(@class,'text')]")
	public WebElement defaultViewField;
	
	@FindBy(xpath = "//button[normalize-space()='Show Filters']")
	public WebElement showFilterBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Hide Filters']")
	public WebElement hideFilterBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Add Filter Row']")
	public WebElement addFilterRowFilterBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Search')]")
	public WebElement searchDropdownBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Export']")
	public WebElement exportBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Create New Contact' and contains(@class,'select')]")
	public WebElement createNewContactTitle;
	
	@FindBy(xpath = "//div//label[contains(text(),'Category')]")
	public WebElement categoryBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following-sibling::div[@name='company']")
	public WebElement companyBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Close Date')]//following-sibling::div//input[@type='text']")
	public WebElement closedDateLocator;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
