package com.crm.dev.PageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class CallsPage extends  DriverManager{
	
	@FindBy(xpath = "//span[contains(text(),'Calls') and @class='item-text']")
	public WebElement callsBtn;
	
	@FindBy(xpath = "//span[contains(@class,'select')]")
	public WebElement callsTitleBtn;
	
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
	public WebElement createCallUsingPlusBtn;
	
	@FindBy(xpath = "//div//span[contains(@class,'selectable')]")
	public WebElement createNewCallsTitle;
	
	
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
		
		@FindBy(xpath = "//div//label[contains(text(),'Participants')]//following::div[contains(@class,'ui active')]")
		public WebElement participantsLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'Type')]//following::div[@name='type']//div[@name='type']")
		public List<WebElement>  typeDropDownLocator;
		
		@FindBy(xpath = "//div//label[contains(text(),'Type')]//following::div[@name='type']//i[@class='dropdown icon']")
		public WebElement  typeDropDownBtn;
		
		@FindBy(xpath = "//div[contains(@name,'deal')]//i[contains(@class,'search')]")
		public WebElement dealSearchBtn;
		
		@FindBy(xpath = "//div[contains(@name,'flag')]//i[contains(@class,'dropdown')]")
		public WebElement flagDropDownBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']//i[contains(@class,'dropdown')]")
		public WebElement categoryDownArrowBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Alert Before')]//following::div[@name='minutesBefore']//i[contains(@class,'dropdown')]")
		public WebElement alertBeforeDownArrowBtn;
		
		@FindBy(xpath = "//div//label[contains(text(),'Alert Via')]//following::div[@name='channels']//i[contains(@class,'dropdown')]")
		public WebElement alertViaDownArrowBtn;
	
	public CallsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public HashMap<String, String> createCall(HashMap<String,String> formData) {
		
	HashMap<String,String> data = new HashMap<>();
		String participants_value = "", type_value= " ",status_value = "",flag_value = "";
		
			
			//Participants
			try {
				participants_value = formData.get("Participants");
				if (participants_value.equalsIgnoreCase("Random") || participants_value.isEmpty()) {

					participants_value = "Automation_"+RandomStringUtils.randomAlphanumeric(2);
				}
				data.put("Participants", participants_value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//type
			try {
				type_value = formData.get("category_input");
				if (type_value.equalsIgnoreCase("Random") || type_value == null) {
					type_value = basePage.selectRandomDropDownValue("Type");
				}
				data.put("Company", type_value);
			}

			catch (Exception e) {
				e.printStackTrace();
			}
			
			//Status
			try {  
				status_value = formData.get("Status");
			if(status_value.equalsIgnoreCase("Random")||status_value.isBlank()) { 
				status_value = basePage.selectRandomDropDownValue("Status");
			} 
			data.put("Status", status_value);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//Flag
			try {
				flag_value = formData.get("Flag");
				if (flag_value.equalsIgnoreCase("Random") || flag_value == null) {
					flag_value = basePage.selectRandomDropDownValue("Flag");
				}
				data.put("Flag", flag_value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		   
		return data;
	}
	
	public String getRandomParticipants(WebElement dropDownLocator) {

		String input = " ";
		List<String> strList = new ArrayList<>();
		List<WebElement> listOfDropdownElements = driver().findElements(By.xpath("//div//label[contains(text(),'Participants')]//following-sibling::div//div[@role='option']"));
		Random random = new Random();
		dropDownLocator.click();
		basePage.JSSendKeys(dropDownLocator, "o");
		implicitWait(5);

		if (listOfDropdownElements.size() > 1) {
			for (int list = 0; list < listOfDropdownElements.size(); list++) {

				List<WebElement> listOfDropdownElements1 = driver().findElements(
						By.xpath("//div[contains(@name,' Company')]//span[contains(@class,text)][" + list + "]"));

				strList.add(listOfDropdownElements1.get(list).getAttribute("textContent"));
			}

			int firstRandom = random.nextInt(strList.size());
			int secondRandom = random.nextInt(strList.size());
			input = strList.get(firstRandom);
			
		}
		return input;
	}

	
}
