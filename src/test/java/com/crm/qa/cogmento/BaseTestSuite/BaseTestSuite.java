package com.crm.qa.cogmento.BaseTestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.dev.PageObjects.LoginPage;

public class BaseTestSuite extends DriverManager {

	
	
	@BeforeMethod
	public void setUp() {
	
		openBrowser();
		deleteAllCookies();
		maxmizeWindow();
		LoginPage loginPage = new LoginPage(driver());
		loginPage.launchCogmentoApplication();
		pageLoadTimeOut(40);
		implicitWait(20);
	}
	
	@AfterMethod
	public void tearDown() {
		
		if(driver()!=null) {
			driver().quit();
		}
	}
}
