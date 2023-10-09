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

public class TasksPage extends  DriverManager{
	
	
	@FindBy(xpath = "//span[contains(text(),'Tasks') and @class='item-text']")
	public WebElement TasksBtn;
	
	@FindBy(xpath = "	//span[contains(@class,'select') and text()='Tasks']")
	public WebElement tasksTitleLocator;
	
	@FindBy(xpath = "	//span[contains(@class,'select') and text()='Create new Task']")
	public WebElement tasksCreateTitleLocator;
	
	@FindBy(xpath = "//i[contains(@class,'dropdown')]//parent::div[@name='view']")
	public WebElement dropdownBtn;

	@FindBy(xpath = "//span[normalize-space()='Default View' and contains(@class,'text')]")
	public WebElement defaultViewField;

	@FindBy(xpath = "//button[contains(text(),'Show Filters')]")
	public WebElement showFilterBtn;

	@FindBy(xpath = "//button[normalize-space()='Hide Filters']")
	public WebElement hideFilterBtn;

	@FindBy(xpath = "//button[contains(@class,'ui small')]//i[contains(@class,'plus')]")
	public WebElement addFilterRowFilterBtn;
	
	@FindBy(xpath = "//button[contains(@class,'ui small')]//i[contains(@class,'minus')]")
	public WebElement minusOfAddFilterBtn;

	@FindBy(xpath = "//div[contains(@class,'search')]//i[contains(@class,'dropdown')]")
	public WebElement searchDropdownBtn;
	
	@FindBy(xpath = "//div[contains(@class,'visible menu')]//div[@class='item']")
	public List<WebElement> sreachShowFilterDropdown;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']//div//div[@class='item']")
			public List<WebElement> companyDropdownList;
	@FindBy(xpath = "//button[normalize-space()='Board']")
	public WebElement boardBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Grid')]")
	public WebElement gridBtn;
	
	@FindBy(xpath = "//span[contains(text(),'The field Title')]")
	public WebElement mandatoryFieldErrorMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement createEventCancelBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement createEventSaveBtn;
	
	@FindBy(xpath="//div[contains(@class,'ui black')]//div[contains(@class,'ui blue')]")
	public List<WebElement> optionsOfExportBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Export']")
	public WebElement exportBtn;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	public WebElement createBtn;
	
	@FindBy(xpath = "//table//thead//following-sibling::th[not(contains(text(),'Options'))]")
	public List<WebElement> tableHeadersLocator;
	
	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following::div[@name='company']")
	public WebElement  companyDropDownLocator;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	public WebElement okBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelBtn;
	
	@FindBy(xpath = "//div//p[contains(text(),'Press OK')]")
	public WebElement popMessage;
	
	@FindBy(xpath="//i[contains(@class,'inverted icon')]//parent::button//preceding-sibling::a//span[contains(text(),'Tasks')]")
	public WebElement tasksPlusBtn;
	
	
	
	public TasksPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public HashMap<String, String> createTask(HashMap<String,String> formData) {
		
		HashMap<String,String> data = new HashMap<>();
			String title_value = "", type_value= " ",status_value = "",flag_value = "";
			
				
				//Title
				try {
					title_value = formData.get("Title");
					if (title_value.equalsIgnoreCase("Random") || title_value.isEmpty()) {

						title_value = "Automation_"+RandomStringUtils.randomAlphanumeric(4);
					}
					data.put("Title", title_value);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//type
				try {
					type_value = formData.get("Type");
					if (type_value.equalsIgnoreCase("Random") || type_value == null) {
						type_value = basePage.selectRandomDropDownValue("Type");
					}
					data.put("Type", type_value);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
				
				//Company
				try {  
					status_value = formData.get("Company");
				if(status_value.equalsIgnoreCase("Random")||status_value.isBlank()) { 
					status_value = basePage.selectRandomDropDownValue("Status");
				} 
				data.put("Company", flag_value);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				//Status
				try {
					flag_value = formData.get("Status");
					if (flag_value.equalsIgnoreCase("Random") || flag_value == null) {
						flag_value = basePage.selectRandomDropDownValue("Flag");
					}
					data.put("Status", status_value);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			   
			return data;
		}
	
	
}
