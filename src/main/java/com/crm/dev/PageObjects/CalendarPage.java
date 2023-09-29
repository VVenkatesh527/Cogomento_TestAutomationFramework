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
	
	
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void MenuNavigation(String menu) { 

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
			if (calendarBtn.isDisplayed()) {
				action.moveToElement(calendarBtn).build().perform();
			} else {
				ExtentLogger.fail("Unable to Navigate CalendarMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
