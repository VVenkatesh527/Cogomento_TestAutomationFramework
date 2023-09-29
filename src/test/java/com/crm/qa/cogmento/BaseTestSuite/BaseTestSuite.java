package com.crm.qa.cogmento.BaseTestSuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.report.ExtentReport.ExtentReport;

public class BaseTestSuite extends DriverManager {

	
	
	@BeforeMethod
	public void setUp() {
	
		openBrowser();
		deleteAllCookies();
		maxmizeWindow();
		ExtentReport.initReports();
		pageObjectsIntilization();
		loginPage.launchCogmentoApplication();
		pageLoadTimeOut(40);
		implicitWait(20);
	}
	
	@AfterMethod
	public void tearDown() {
		
		
		destroyPageObjects();
		ExtentReport.tearDownReports();
		if(driver()!=null) {
			driver().quit();
		}
	}
}
