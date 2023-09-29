package com.crm.dev.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.dev.utility.Log;
import com.crm.report.ExtentReport.ExtentLogger;

public class ContactsPage  extends  DriverManager{
	
	@FindBy(xpath = "//span[normalize-space()='Contacts' and contains(@class,'item-text')]")
	public WebElement contactsBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Contacts' and contains(@class,'select')]")
	public WebElement contactsTitle;
	
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
	
	@FindBy(xpath = "//span[normalize-space()='Create New Contact' and contains(@class,'select')]")
	public WebElement createNewContactTitle;
	
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
			if (contactsBtn.isDisplayed()) {
				action.moveToElement(contactsBtn).build().perform();
			} else {
				ExtentLogger.fail("Unable to Navigate HomeMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}