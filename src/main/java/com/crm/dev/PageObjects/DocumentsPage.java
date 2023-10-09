package com.crm.dev.PageObjects;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class DocumentsPage  extends  DriverManager{
	
	@FindBy(xpath = "//span[contains(text(),'Documents') and @class='item-text']")
	public WebElement documentsBtn;
	
	@FindBy(xpath = "//div//label[contains(text(),'Close Date')]//following-sibling::div//input[@type='text']")
	public WebElement closedDateLocator;
	
	@FindBy(xpath = "//span[contains(@class,'select')]")
	public WebElement documentsTitleBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Create']")
	public WebElement createBtn;
	
	@FindBy(xpath = "//button[normalize-space()='New Folder']")
	public WebElement newFolderBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Add new F')]")
	public WebElement newFolderCreateLocator;
	
	@FindBy(xpath = "//button[@class='ui button']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement createSaveBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelBtn;
	
	@FindBy(xpath = "//div//input[@name='addFolderName']")
	public WebElement folderNameLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']//input[contains(@class,'search')]")
	public WebElement companyLocatorBtn;
	
	public DocumentsPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
public Map<String,String> createDeal(Map<String,String> formData) {
		
		Map<String,String> createdData = new HashMap<>();
		String title_value="",company_value="",amount_value="", closedDate_value = "";
		try {
			title_value = formData.get("Title");
			if(title_value.equalsIgnoreCase("random")||title_value.isEmpty()) {
				title_value = "Deal_Automation_"+RandomStringUtils.randomNumeric(4);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		createdData.put("Title", title_value);
		
		try {
			company_value = formData.get("Company");
			if(company_value.equalsIgnoreCase("random")|| company_value.isEmpty()) {
				company_value = basePage.getRandomCompanyName(companyLocatorBtn);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		createdData.put("Company", company_value);
		
		try {
			amount_value = formData.get("Amount");
			if(amount_value.equalsIgnoreCase("random") || amount_value.isEmpty()) {
				amount_value = RandomStringUtils.randomAlphabetic(6);
			}
			createdData.put("Amount", amount_value);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//closedDate_value
		try {
			
			String closedDate="";
			
			closedDate_value = formData.get("ClosedDate");

			if (closedDate_value.equalsIgnoreCase("d MMMM yyyy") && !closedDate_value.isEmpty() || closedDate_value.equalsIgnoreCase("dd MMMM yyyy") ) {
				
				//closedDate = basePage.selectDateAndTime(closedDate_value , "Future", 6);
				
			}
			createdData.put("ClosedDate", closedDate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return createdData;	
	}
	
	
	
	
	
}
