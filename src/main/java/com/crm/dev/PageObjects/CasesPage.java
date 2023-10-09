package com.crm.dev.PageObjects;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class CasesPage extends  DriverManager {
	
	@FindBy(xpath = "//span[contains(text(),'Cases') and @class='item-text']")
	public WebElement casesBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Cases' and contains(@class,'select')]")
	public WebElement casesTitle;
	
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	public WebElement status_locator;
	
	@FindBy(xpath = "//label[contains(text(),'Close Date')]")
	public WebElement closeDateKey;
	
	@FindBy(xpath = "//div//label[contains(text(),'Status')]//following-sibling::div[@name='status']")
	public WebElement statusBtn;
	
	@FindBy(xpath = "//i[contains(@class,'dropdown icon')]//parent::div[@name='view']")
	public WebElement viewDropdownBtn;
	
	@FindBy(xpath = "//div//span[contains(text(),'Default View')]")
	public WebElement defaultViewBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Show Filters']")
	public WebElement showFiltersBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Hide Filters']")
	public WebElement hideFiltersBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Add Filter Row']")
	public WebElement addFilterRowFilterBtn;
	
	@FindBy(xpath = "//button[contains(@class,'ui small')]//i[contains(@class,'minus')]")
	public WebElement minusOfAddFilterBtn;

	@FindBy(xpath = "//div[contains(@class,'search')]//i[contains(@class,'dropdown')]")
	public WebElement searchDropdownBtn;
	
	@FindBy(xpath = "//div[contains(@class,'visible menu')]//div[@class='item']")
	public List<WebElement> sreachShowFilterDropdown;
	
	@FindBy(xpath = "//button[normalize-space()='Export']")
	public WebElement exportBtn;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement okBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Deals Summ')]")
	public WebElement homePageDealsummaryLocator;
	
	@FindBy(xpath = "//div//p[contains(text(),'Press OK')]")
	public WebElement popMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Cases')]//parent::a//following-sibling::button//i[contains(@class,'plus')]")
	public WebElement createUsingPlusBtn;
	
	@FindBy(xpath = "//div//span[contains(@class,'selectable')]")
	public WebElement createNewCaseTitle;
	
	//formData
	
			@FindBy(xpath = "//span[contains(text(),'Required')]")
			public WebElement mandatoryFieldErrorMessage;
			
			@FindBy(xpath = "//button[contains(text(),'Cancel')]")
			public WebElement createEventCancelBtn;
			
			@FindBy(xpath = "//button[contains(text(),'Save')]")
			public WebElement createEventSaveBtn;
			
			@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']")
			public List<WebElement>  companyDropDownLocator;
			
			@FindBy(xpath = "//div//label[contains(text(),'Type')]//following::div[@name='type']")
			public List<WebElement>  typeDropDownLocator;
			
			@FindBy(xpath = "//div//label[contains(text(),'Status')]//following::div[@name='status']")
			public List<WebElement>  statusDropDownLocator;
			
			@FindBy(xpath = "//input[contains(@name,'title')]")
			public WebElement caseTitleLocator;
			
			@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']//i[contains(@class,'dropdown')]")
			public WebElement companyDownArrowBtn;
			
			@FindBy(xpath = "//div//label[contains(text(),'Type')]//following::div[@name='type']//i[contains(@class,'dropdown')]")
			public WebElement typeDownArrowBtn;
			
			@FindBy(xpath = "//div//label[contains(text(),'Status')]//following::div[@name='status']//i[contains(@class,'dropdown')]")
			public WebElement statusDownArrowBtn;
	
	
	public CasesPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public HashMap<String, String> createCase(HashMap<String,String> formData) {
		
		HashMap<String,String> data = new HashMap<>();
		String title_value = "",status_value="",type_value="",company_value="";
		
		//Title
		try {  
			title_value = formData.get("Title");
		if(title_value.equalsIgnoreCase("Random") || title_value.isBlank()) 
			title_value = "Automation_"+RandomStringUtils.randomAlphanumeric(2);
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		caseTitleLocator.sendKeys(title_value);
		data.put("Title", title_value);
		
		//Status
				try {  
					status_value = formData.get("Status");
				if(status_value.equalsIgnoreCase("Random")|| status_value.isEmpty()) 
					status_value = basePage.selectRandomDropDownValue("Status");
				}
				catch
				(Exception e) {
					e.printStackTrace();
					}
				
				data.put("Status", status_value);
				
		//type
		try {  
			type_value = formData.get("Type");
		if(type_value.equalsIgnoreCase("Random")||type_value.isEmpty()) { 
			type_value = basePage.selectRandomDropDownValue("Type");
		}
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		
		data.put("Type", type_value);
		
		//Company
		try {  
			company_value = formData.get("Company");
		if(company_value.equalsIgnoreCase("Random")|| company_value.isEmpty()) 
			company_value = basePage.selectRandomDropDownValue("Company");
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		
		data.put("Company", company_value);
		
		return data;
	}
	
	
}
