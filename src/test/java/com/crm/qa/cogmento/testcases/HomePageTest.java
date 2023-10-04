package com.crm.qa.cogmento.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class HomePageTest extends BaseTestSuite {

	@Test(description = "Verify Home Page Is Displayed Once User is Logged In with valid credentials")
	public void tc_cogmento_homepage_001() {

		ExtentReport.createTest("Verify Home Page Is Displayed Once User is Logged In with valid credentials");
		Log.info("Verify Home Page Is Displayed Once User is Logged In with valid credentials");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		ExtentLogger.pass("Verify Home Page Is Displayed Once User is Logged In with valid credentials");
	}

	@Test(description = "Verify All Fields in HomePage")
	public void tc_cogmento_homepage_002() {

		/**
		 * 1. Test Data (Map,Set,List) 2. calling methods using object reference 3. Logs
		 * 4. Assertions 5. Extent Report Logs
		 */

		ExtentReport.createTest("Verify All Fields in HomePage");
		Log.info("Validating All Fields in HomePage");
		Assert.assertEquals(true, homePage.testAutomationHeader.isDisplayed());
		Assert.assertEquals(true, homePage.searchBtn.isDisplayed());
		Assert.assertEquals(true, homePage.pinIcon.isDisplayed());
		Assert.assertEquals(true, homePage.trashBtn.isDisplayed());
		Assert.assertEquals(true, homePage.settingsIcon.isDisplayed());
		ExtentLogger.pass("Validated All Fields in HomePage");

		/**
		 * List<String> add all menus actual List WebElement list and convert to
		 * List<String> expectList
		 */

	}

	@Test(description = "Verify and get all settings feature options available after click on to the setting button")
	public void tc_cogmento_homepage_004() {

		ExtentReport.createTest(
				"Verify and get all settings feature options available after click on to the setting button");
		Log.info("Verify and get all settings feature options available after click on to the setting button");
		
		List<String> actualList = new ArrayList<>();
		actualList.add("Settings");
		actualList.add("Products");
		actualList.add("Import");
		actualList.add("VCM");
		actualList.add("AI");
		actualList.add("Content Templates");
		actualList.add("Tools");
		actualList.add("Documentation");
		actualList.add("Log Out");
				
		Assert.assertEquals(true, homePage.settingsIcon.isDisplayed() || homePage.settingsIcon.isEnabled());
		homePage.settingsIcon.click();
		Log.info("Clicked on Settings Icon");
		List<String> expectedList = homePage.convertWebElementToStringList(homePage.settingFeatures);
		Assert.assertEquals(actualList, expectedList);

	}
	
	
}
