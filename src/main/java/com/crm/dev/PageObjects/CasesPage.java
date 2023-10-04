package com.crm.dev.PageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy(xpath = "//span[normalize-space()='Create New Case' and contains(@class,'select')]")
	public WebElement createNewCasesTitle;
	
	@FindBy(xpath = "//div//label[contains(text(),'Status')]//following-sibling::div[@name='status']")
	public WebElement statusBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createBtn;
	
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
			
			@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']//i[contains(@class,'dropdown')]")
			public WebElement companyDownArrowBtn;
			
			@FindBy(xpath = "//div//label[contains(text(),'Type')]//following::div[@name='type']//i[contains(@class,'dropdown')]")
			public WebElement typeDownArrowBtn;
			
			@FindBy(xpath = "//div//label[contains(text(),'Status')]//following::div[@name='status']//i[contains(@class,'dropdown')]")
			public WebElement statusDownArrowBtn;
	
	
	public CasesPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public Map<String, String> createCaseForm(Map<String,String> caseFormMap) {
		
		Map<String,String> data = new HashMap<>();
		String title_input = "",status_input="",type_input="",company_input="";
		
		try {  
			title_input = caseFormMap.get("Title_input");
		if(title_input==" " || title_input==null) 
			title_input="";
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		if(!title_input.equalsIgnoreCase("Random")) { 
			title_input = "Automation_"+RandomStringUtils.randomAlphanumeric(2);
		} 
		implicitWait(10);
		
		data.put("Title_input", title_input);
		
		//Status
				try {  
					status_input = caseFormMap.get("Status_input");
				if(status_input==" " || status_input==null) 
					status_input="";
				}
				catch
				(Exception e) {
					e.printStackTrace();
					}
				if(!status_input.equalsIgnoreCase("Random")) { 
					status_input = basePage.selectRandomDropDownValue("Status");
				} 
				implicitWait(10);
				
				data.put("Status_input", status_input);
				
		//type
		try {  
			type_input = caseFormMap.get("Type_input");
		if(type_input==" " || type_input==null) 
			type_input="";
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		if(!type_input.equalsIgnoreCase("Random")) { 
			type_input = basePage.selectRandomDropDownValue("Type");
		} 
		implicitWait(10);
		
		data.put("Type_input", type_input);
		
		//Company
		try {  
			company_input = caseFormMap.get("Company_input");
		if(company_input==" " || company_input==null) 
			company_input="";
		}
		catch
		(Exception e) {
			e.printStackTrace();
			}
		if(!company_input.equalsIgnoreCase("Random")) { 
			company_input = basePage.selectRandomDropDownValue("Company");
		} 
		implicitWait(10);
		
		data.put("Company_input", company_input);
		
		return data;
	}
	
	
}
