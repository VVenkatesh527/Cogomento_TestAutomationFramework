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

public class CallsPage extends  DriverManager{
	
	@FindBy(xpath = "//span[contains(text(),'Calls') and @class='item-text']")
	public WebElement callsBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	public WebElement callscreateBtn;
	
	//formData
		
		@FindBy(xpath = "//span[contains(text(),'Required')]")
		public WebElement mandatoryFieldErrorMessage;
		
		@FindBy(xpath = "//button[contains(text(),'Cancel')]")
		public WebElement createEventCancelBtn;
		
		@FindBy(xpath = "//button[contains(text(),'Save')]")
		public WebElement createEventSaveBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']")
		public List<WebElement> categoryDropDownLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']")
		public List<WebElement>  companyDropDownLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'AlertBefore')]//following::div[@name='company']")
		public List<WebElement>  alertBeforeDropDownLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='company']")
		public List<WebElement>  alertViaDropDownLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']//i[contains(@class,'dropdown')]")
		public WebElement categoryDownArrowBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Alert Before')]//following::div[@name='minutesBefore']//i[contains(@class,'dropdown')]")
		public WebElement alertBeforeDownArrowBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//i[contains(@class,'dropdown')]")
		public WebElement alertViaDownArrowBtn;
	
	public CallsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
public Map<String, String> createFormData(Map<String,String> formData) {
		
		Map<String,String> data = new HashMap<>();
		String participants_input = "", type_input = " ",status_input = "",flag_input = "";
		
			
			//Participants
			try {  
				participants_input = formData.get("category_input");
			if(participants_input==" " || participants_input==null) 
				participants_input="";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			if(!participants_input.equalsIgnoreCase("Random")) { 
				participants_input = "Automation_"+RandomStringUtils.randomAlphanumeric(2);
			} 
			implicitWait(10);
			
			data.put("Participants", participants_input);
			
			//type
			try {  
				type_input = formData.get("category_input");
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
			
			data.put("Company", type_input);
			
			//Status
			try {  
				status_input = formData.get("alertVia_input");
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
			
			data.put("Alert Via", status_input);
			
			//Flag
			try {  
				flag_input = formData.get("alertBefore_input");
			if(flag_input==" " || flag_input==null) 
				flag_input="";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			if(!flag_input.equalsIgnoreCase("Random")) { 
				flag_input = basePage.selectRandomDropDownValue("Flag");
			} 
			implicitWait(10);
			
			data.put("Flag", flag_input);
			
		   
		return data;
	}
	
}
