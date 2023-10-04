package com.crm.dev.PageObjects;

import java.util.ArrayList;
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

public class HomePage extends DriverManager {

	@FindBy(xpath = "//b[normalize-space()='Test Automation']")
	public WebElement testAutomationHeader;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public WebElement searchBtn;

	@FindBy(xpath = "//i[@class='pin icon']")
	public WebElement pinIcon;

	@FindBy(xpath = "//i[contains(@class,'trash')]")
	public WebElement trashBtn;

	@FindBy(xpath = "//i[@class='settings icon']")
	public WebElement settingsIcon;

	@FindBy(xpath = "//span[contains(text(),'Home') and @class='item-text']")
	public WebElement homeBtn;

	@FindBy(xpath = "//div[@class='menu-item-wrapper']")
	public List<WebElement> menuFeaturesList;

	@FindBy(xpath = "//div[starts-with(@class,'menu transition')]//a//span[@class='text']")
	public List<WebElement> settingFeatures;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void MenuNavigation(WebElement element,String menu) { 

		navigateToMenu(element);
		
		try {
			if (menu.length() > 1 && !menu.isBlank()) {
				element = driver()
						.findElement(By.xpath("//span[contains(text(),'" + menu + "') and @class='item-text']"));
				element.click();
			}
		} catch (Exception e) {
			Log.info(menu + "is not present in menu navigation ");
			e.printStackTrace();
		}
	}

	public void navigateToMenu(WebElement menu) {

		Actions action = new Actions(driver());
		try {
			if (menu.isDisplayed()) {
				action.moveToElement(menu).build().perform();
			} else {
				ExtentLogger.fail("Unable to Navigate HomeMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public List<String> convertWebElementToStringList(List<WebElement> elements) {

		List<String> strList = new ArrayList<>();

		for (int list = 0; list < elements.size(); list++) {

			strList.add(elements.get(list).getAttribute("textContent"));
		}
		return strList;
	}
	
	
	
}
