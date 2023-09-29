package com.crm.dev.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.dev.utility.Log;
import com.crm.report.ExtentReport.ExtentLogger;

public class DealPage extends DriverManager {

	@FindBy(xpath = "//span[contains(text(),'Deals') and @class='item-text']")
	public WebElement dealsBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Deals' and contains(@class,'select')]")
	public WebElement dealsTitle;
	
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
	
	@FindBy(xpath = "//span[normalize-space()='Create New Deal' and contains(@class,'select')]")
	public WebElement createNewDealTitle;
	
	@FindBy(xpath = "//span[normalize-space()='Sales Targets' and contains(@class,'select')]")
	public WebElement salesTargetsTitle;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//i[@class='pin icon']")
	public WebElement pinIcon;

	@FindBy(xpath = "//button[contains(text(),'Back')]")
	public WebElement backBtn;
	
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
	
	@FindBy(xpath = "//button[contains(text(),'Manage Targets')]")
	public WebElement manageTargetsBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Grid')]")
	public WebElement gridBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Board')]")
	public WebElement boardBtn;

	@FindBy(xpath = "//table[starts-with(@class,'ui celled')]//thead/tr/th/following-sibling::th")
	public List<WebElement> colCount;

	
	public DealPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void MenuNavigation(String menu) { //a

		navigateToMenu();
		
		try {
			if (menu.length() > 1 && !menu.isBlank()) {
				WebElement element = driver()
						.findElement(By.xpath("//span[contains(text(),'" + menu + "') and @class='item-text']"));
				element.click();
			}
		} catch (Exception e) {
			Log.info(menu + "is not present in menu navigation ");
			e.printStackTrace();
		}
	}

	public void navigateToMenu() {

		Actions action = new Actions(driver());
		try {
			if (dealsBtn.isDisplayed()) {
				action.moveToElement(dealsBtn).build().perform();
			} else {
				ExtentLogger.fail("Unable to Navigate HomeMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void createDeal() {
		
		
	}
}
