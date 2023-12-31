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

public class DealPage extends DriverManager {

	@FindBy(xpath = "//span[contains(text(),'Deals') and @class='item-text']")
	public WebElement dealsBtn;

	@FindBy(xpath = "//span[contains(@class,'select')]")
	public WebElement dealsTitleLocator;

	@FindBy(xpath = "//a//span[contains(text(),'Deals')]//parent::a//following-sibling::button//i[contains(@class,'inverted icon')]")
	public WebElement dealsPlusBtn;

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

	@FindBy(xpath = "//span[contains(text(),'Cases')]//parent::a//following-sibling::button//i[contains(@class,'plus')]")
	public WebElement createUsingPlusBtn;

	@FindBy(xpath = "//span[contains(@class,'select')]")
	public WebElement createNewDealTitle;

	@FindBy(xpath = "//span[contains(@class,'select')]")
	public WebElement salesTargetsTitle;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//i[@class='pin icon']")
	public WebElement pinIcon;

	@FindBy(xpath = "//div[@class='item']//button[contains(text(),'Back')]")
	public WebElement backBtn;

	@FindBy(xpath = "//div[@class='item']//button[contains(@class,'ui')]")
	public List<WebElement> salesTargetHeaderList;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public WebElement cancelBtn;

	@FindBy(xpath = "//div[contains(text(),'Unassigned')]")
	public WebElement unassignedBtn;

	@FindBy(xpath = "//i[contains(@class,'trash')]")
	public WebElement trashBtn;

	@FindBy(xpath = "//i[@class='settings icon']")
	public WebElement settingsIcon;

	@FindBy(xpath = "//button[contains(text(),'Pipeline')]")
	public WebElement pipelineBtn;

	@FindBy(xpath = "////div[contains(text(),'Deal')]")
	public WebElement dalPipelineTitleLocator;

	@FindBy(xpath = "//button[contains(text(),'Manage Targets')]")
	public WebElement manageTargetsBtn;

	@FindBy(xpath = "//button[contains(text(),'Grid')]")
	public WebElement gridBtn;

	@FindBy(xpath = "//button[contains(text(),'Board')]")
	public WebElement boardBtn;

	@FindBy(xpath = "//div//label[contains(text(),'Close Date')]//following-sibling::div//input[@type='text']")
	public WebElement closedDateLocator;

	@FindBy(xpath = "//table[starts-with(@class,'ui celled')]//thead/tr/th/following-sibling::th")
	public List<WebElement> colCount;

	@FindBy(xpath = "//div//label[contains(text(),'Status')]//following-sibling::div[@name='status']")
	public WebElement statusBtn;

	@FindBy(xpath = "//div[contains(@name,'company')]//input[contains(@class,'search') and contains(@autocomplete,'off')]")
	public WebElement companyBtn;

	@FindBy(xpath = "//div//label[contains(text(),'Amount')]//following-sibling::div//input[@name='amount']")
	public WebElement amountBtn;

	@FindBy(xpath = "//div//label[contains(text(),'Company')]//following-sibling::div//div[@role='option']")
	public WebElement companydropdown;

	@FindBy(xpath = "//div//span[contains(@class,'selectable')]")
	public WebElement createNewCaseTitle;

	@FindBy(xpath = "//div//input[contains(@name,'title') and contains(@autocomplete,'new-password')]")
	public WebElement createDealTitleLocator;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]//i[contains(@class,'cancel')]")
	public WebElement createEventCancelBtn;

	@FindBy(xpath = "//button[contains(text(),'Save')]//i[contains(@class,'save')]")
	public WebElement createEventSaveBtn;

	@FindBy(xpath = "//div//label[contains(text(),'Start Date')]//following-sibling::div//input[@type='text']")
	public WebElement startDateLocator;

	@FindBy(xpath = "//div//label[contains(text(),'End Date')]//following-sibling::div//input[@type='text']")
	public WebElement endDateLocator;

	public DealPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public HashMap<String, String> createDeal(Map<String, String> formData) {

		HashMap<String, String> data = new HashMap<>();
		String title_value = "", company_value = "", amount_value = "", closedDate_value = "";
		
		try {
			title_value = formData.get("Title");
			if (title_value.equalsIgnoreCase("random") || title_value.isEmpty()) {
				title_value = "Deal_Automation_" + RandomStringUtils.randomNumeric(4);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		createDealTitleLocator.sendKeys(title_value);
		data.put("Title", title_value);

		try {
			company_value = formData.get("Company");
			if (company_value.equalsIgnoreCase("random") || company_value.isEmpty()) {
				company_value = basePage.getRandomCompanyName(companyBtn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		companyBtn.sendKeys(company_value);
		data.put("Company", company_value);

		try {
			amount_value = formData.get("Amount");
			if (amount_value.equalsIgnoreCase("random") || amount_value.isEmpty()) {
				amount_value = RandomStringUtils.randomAlphabetic(6);
			}
			amountBtn.sendKeys(amount_value);

			data.put("Amount", amount_value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// closedDate_value
		try {
			String closedDate = "";
			closedDate_value = formData.get("ClosedDate");
			if (closedDate_value.contains("~")) {
				String[] date = closedDate_value.split("~");
				String tense = date[0];
				int dayLimitor = Integer.valueOf(date[1]);
				closedDate = basePage.selectDateAndTime(dayLimitor,tense);
			}
			else
				{
				   //closedDate = basePage.selectDateAndTime(dayLimitor,tense);
				}

			data.put("ClosedDate", closedDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

}
