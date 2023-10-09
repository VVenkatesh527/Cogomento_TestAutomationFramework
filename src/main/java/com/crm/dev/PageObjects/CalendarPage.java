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
	
	@FindBy(xpath = "//div[@class='rbc-event']//div[contains(text(),'MostView')]")
	public WebElement mostViewEventBtn;
	
	@FindBy(xpath = "	//button[contains(@class,'ui icon')]//i[contains(@class,'edit icon')]")
	public WebElement editEventBtn;

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
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Before')]//following::div[contains(@class,'visible me')]//div[@class='item']")
	public WebElement alertBeforeDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//i[contains(@class,'drop')]")
	public WebElement alertViaDropDownBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//div//span[text()='SMS']")
	public WebElement alertViaDropDownLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']//i[contains(@class,'dropdown')]")
	public WebElement categoryDownArrowBtn;
	
	@FindBy(xpath = "//div[contains(@name,'minutesBefore')]//i[contains(@class,'dropdow')]")
	public List<WebElement>  alertBeforeDownArrowBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Before')]//following::div[@name='minutesBefore']//i[contains(@class,'dropdown')]")
	public List<WebElement>  alertBeforeDown;
	
	@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//i[contains(@class,'dropdown')]")
	public WebElement alertViaDownArrowBtn;
	
	@FindBy(xpath = "//div[contains(@class,'rbc-event-') and contains(@title,'Test_Automation_72')]")
	public WebElement calendarEventBtn;

	@FindBy(xpath = "//div[contains(@class,'rbc-event-') and contains(@title,'Cookies deals')]")
	public WebElement calendarEventCookiesBtn;
	
	
	@FindBy(xpath = "//div[@class='ui attached tabular menu']//a[contains(text(),'')]")
	public List<WebElement> editOptionsForSchedule;
	
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public Map<String, String> calendarFormData(Map<String,String> formData) {
		
		Map<String,String> calendarData = new HashMap<>();
		String title_value = "", category_value = " ",company_value = "",alertBefore_value ="",alertVia_value = "";
				//endDate_value="",startDate_value="";
		
		//Title
		try {
			title_value = formData.get("Title");
		if( title_value.equalsIgnoreCase("random")||title_value.isEmpty()) {
			title_value ="Test_Automation_"+RandomStringUtils.randomAlphanumeric(2);
		}
		
		}catch(Exception e) {
			e.printStackTrace(); 
		} 
			createEventTitleLocator.sendKeys(title_value);
			calendarData.put("Title",title_value);
			
			//category
			try {  
				category_value = formData.get("Category");
				if(category_value.equalsIgnoreCase("Random")||category_value.isEmpty()) { 
					category_value = basePage.selectRandomDropDownValue("Category");
				}
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			calendarData.put("Category", category_value);
			
			//company
			try {  
				company_value = formData.get("Company");
			if(company_value.equalsIgnoreCase("Random")||company_value.isEmpty()) 
				company_value = basePage.selectRandomDropDownValue("Company");
			}
			catch
			(Exception e) {
				e.printStackTrace();
				}
			calendarData.put("Company", company_value);
			
			//AlertVia
			try {  
				alertVia_value = formData.get("AlertVia");
			if( alertVia_value.equalsIgnoreCase("Random")|| alertVia_value.isEmpty()) 
				alertVia_value = "SMS";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				} 			
			calendarData.put("AlertVia", alertVia_value);
			
			//AlertBefore
			try {  
				alertBefore_value = formData.get("AlertBefore");
			if(alertBefore_value.equalsIgnoreCase("Random")|| alertBefore_value.isEmpty()) 
				alertBefore_value = "30minutes";
			}
			catch
			(Exception e) {
				e.printStackTrace();
				} 
			calendarData.put("AlertBefore", alertBefore_value);
			
			//startDate
//			try {
//				
//				String startDate="";
//				
//				startDate_value = formData.get("StartDate");
//
//				if (startDate_value.equalsIgnoreCase("d MMMM yyyy") && !startDate_value.isEmpty() || startDate_value.equalsIgnoreCase("dd MMMM yyyy") ) {
//					
//					//startDate = basePage.selectDateAndTime(startDate_value , "Future", 20);
//					
//				}
//				calendarData.put("StartDate", startDate);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			//endDate_value
//			try {
//				
//				String endDate="";
//				endDate_value = formData.get("EndDate");
//
//				if (endDate_value.equalsIgnoreCase("dd MMMM yyyy") && !endDate_value.isEmpty() || endDate_value.equalsIgnoreCase("dd MMMM yyyy") ) {
//					
//					//endDate = basePage.selectDateAndTime(endDate_value , "Future", 5);
//					
//				}
//				calendarData.put("EndDate", endDate);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		return calendarData;
	}
	
	

}
