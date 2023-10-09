package com.crm.dev.PageObjects;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
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
	
	@FindBy(xpath = "//span[contains(text(),'The field Fir')]")
	public WebElement errorMessageFirstNameLocator;
	
	@FindBy(xpath = "//span[contains(text(),'The field Last')]")
	public WebElement errorMessageLastNameLocator;
	
	@FindBy(xpath = "//span[normalize-space()='Create New Contact' and contains(@class,'select')]")
	public WebElement createNewContactTitle;
	
	@FindBy(xpath = "//div//label[contains(text(),'Category')]")
	public WebElement categoryBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement createEventSaveBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following-sibling::div[@name='company']")
	public WebElement companyBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Close Date')]//following-sibling::div//input[@type='text']")
	public WebElement closedDateLocator;
	
	//formData
	@FindBy(xpath = "//div//label[contains(text(),'Name')]//following::div[@name='name']//i[contains(@class,'dropdown')]")
	public WebElement categoryDownArrowBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Email')]//following::div[@name='email']//i[contains(@class,'dropdown')]")
	public WebElement alertBeforeDownArrowBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Phone')]//following::div[@name='phone']//i[contains(@class,'dropdown')]")
	public WebElement alertViaDownArrowBtn;
	
	@FindBy(xpath = "//input[contains(@name,'first_name')]")
	public WebElement firstNameLocator;
	
	@FindBy(xpath = "//input[contains(@name,'last_name')]")
	public WebElement lastNameLocator;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Email address')]")
	public WebElement emailIdLocator;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Number')]")
	public WebElement phoneNoLocator;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public HashMap<String, String> createContact(HashMap<String,String> formData) {
		
	HashMap<String,String> data = new HashMap<>();
		String firstname_value = "",lastname_value = "",email_value="",phone_value="";
		
		
		//FirstName
		try {  
			firstname_value = formData.get("FirstName");
			if(firstname_value.equalsIgnoreCase("Random")||firstname_value.isEmpty()) { 
				firstname_value = "Test";
			}
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		firstNameLocator.sendKeys(firstname_value);
		implicitWait(10);
		
		data.put("FirstName", firstname_value);
				
		//LastName
				try {  
					lastname_value = formData.get("LastName");
					if(lastname_value.equalsIgnoreCase("Random")||lastname_value.isEmpty()) { 
						lastname_value = "Automation_"+RandomStringUtils.randomAlphanumeric(2);
					}
				}
				catch
				(Exception e) {
					e.printStackTrace();
					}
				implicitWait(10);
				lastNameLocator.sendKeys(lastname_value);
				data.put("LastName", lastname_value);
				
		//Email
		try {  
			email_value = formData.get("Email");
		if(email_value.equalsIgnoreCase("Random")||email_value.isEmpty()) 
			email_value = "automation_"+ RandomStringUtils.randomAlphanumeric(4)+"@email.com";
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		emailIdLocator.sendKeys(email_value);
		data.put("Email", email_value);
		
		//Phone
		try {  
			phone_value = formData.get("Phone");
		if(phone_value.equalsIgnoreCase("Random") || phone_value.isEmpty()) 
			phone_value = RandomStringUtils.randomNumeric(10);		
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		phoneNoLocator.sendKeys(phone_value);
		implicitWait(10);
		
		data.put("Phone", phone_value);
		
		return data;
	}
}
