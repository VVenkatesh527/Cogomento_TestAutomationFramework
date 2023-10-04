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

public class CalendarPage extends DriverManager {
	
	@FindBy(xpath = "//span[contains(text(),'Calendar') and @class='item-text']")
	public  WebElement calendarBtn;

	@FindBy(xpath = "//span[contains(text(),'Calendar')]")
	public WebElement calendarHeader;
	
	@FindBy(xpath = "//button[contains(text(),'Events')]")
	public WebElement eventsBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sync now')]")
	public WebElement synNowBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	public WebElement createBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Today')]")
	public WebElement todayBtn;
	
	@FindBy(xpath = "//button//i[contains(@class,'left icon')]")
	public WebElement leftArrowBtn;
	
	@FindBy(xpath = "//button//i[contains(@class,'right icon')]")
	public WebElement righttArrowBtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Month')]")
	public WebElement monthBtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Week')]")
	public WebElement weekBtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Day')]")
	public WebElement dayBtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Agenda')]")
	public WebElement agendaBtn;
	
	//formData
	@FindBy(xpath = "//div//input[contains(@name,'title')]")
	public WebElement createEventTitleLocator;
	
	@FindBy(xpath = "//span[contains(text(),'Required')]")
	public WebElement mandatoryFieldErrorMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement createEventCancelBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement createEventSaveBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']")
	public WebElement categoryDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']")
	public WebElement companyDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'AlertBefore')]//following::div[@name='company']")
	public WebElement alertBeforeDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='company']")
	public WebElement alertViaDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']//i[contains(@class,'dropdown')]")
	public WebElement categoryDownArrowBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Before')]//following::div[@name='minutesBefore']//i[contains(@class,'dropdown')]")
	public WebElement alertBeforeDownArrowBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//i[contains(@class,'dropdown')]")
	public WebElement alertViaDownArrowBtn;
	
	@FindBy(xpath = "//div[contains(@class,'rbc-event-') and contains(@title,'Bunty')]")
	public WebElement calendarEventBuntyBtn;

	@FindBy(xpath = "//div[contains(@class,'rbc-event-') and contains(@title,'Cookies deals')]")
	public WebElement calendarEventCookiesBtn;
	
	
	@FindBy(xpath = "//div[@class='ui attached tabular menu']//a[contains(text(),'')]")
	public List<WebElement> editOptionsForSchedule;
	
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public Map<String, String> createFormData(Map<String,String> formData) {
		
		Map<String,String> data = new HashMap<>();
		String title_input = "", category_input = " ",company_input = "",alertBefore_input ="",alertVia_input = "";
		
		//Title
		try {
			title_input = formData.get("Title");
		if(title_input==" " || title_input==null) 
			title_input="";
		}
		catch
		(Exception e) {
			e.printStackTrace(); 
			}
			if(!title_input.equalsIgnoreCase("")) { 
				title_input ="Test_Automation_"+RandomStringUtils.randomAlphanumeric(2);
		} 

			createEventTitleLocator.sendKeys(title_input);
			implicitWait(10);
			
			data.put("Title",title_input);
			
			//category
			try {  
				category_input = formData.get("category_input");
			if(category_input==" " || category_input==null) 
				category_input="";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			if(!category_input.equalsIgnoreCase("Random")) { 
					category_input = basePage.selectRandomDropDownValue("Category");
			} 
			implicitWait(10);
			
			data.put("Category", category_input);
			
			//company
			try {  
				company_input = formData.get("category_input");
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
			
			data.put("Company", company_input);
			
			//AlertVia
			try {  
				alertVia_input = formData.get("alertVia_input");
			if(alertVia_input==" " || alertVia_input==null) 
				alertVia_input="";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			if(!alertVia_input.equalsIgnoreCase("Random")) { 
				alertVia_input = basePage.selectRandomDropDownValue("Alert Via");
			} 
			implicitWait(10);
			
			data.put("Alert Via", alertVia_input);
			
			//AlertBefore
			try {  
				alertBefore_input = formData.get("alertBefore_input");
			if(alertBefore_input==" " || alertBefore_input==null) 
				alertBefore_input="";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			if(!alertBefore_input.equalsIgnoreCase("Random")) { 
				alertBefore_input = basePage.selectRandomDropDownValue("Alert Before");
			} 
			implicitWait(10);
			
			data.put("Alert Before", company_input);
			
		   
		return data;
	}
	
	

}
