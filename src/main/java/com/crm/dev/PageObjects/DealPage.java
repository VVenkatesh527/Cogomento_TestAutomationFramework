package com.crm.dev.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class DealPage extends DriverManager {

	
	public DealPage(WebDriver driver) {
		
		PageFactory.initElements(DealPage.driver(), driver);
	}
	
	public void createDeal() {
		
	}
}
