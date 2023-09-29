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

public class CallsPage extends  DriverManager{
	
	@FindBy(xpath = "//span[contains(text(),'Home') and @class='item-text']")
	public static WebElement homeBtn;
	
	public CallsPage(WebDriver driver) {
		
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
			if (homeBtn.isDisplayed()) {
				action.moveToElement(homeBtn).build().perform();
			} else {
				ExtentLogger.fail("Unable to Navigate HomeMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
