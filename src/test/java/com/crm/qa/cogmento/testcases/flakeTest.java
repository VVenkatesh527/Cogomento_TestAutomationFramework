package com.crm.qa.cogmento.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class flakeTest extends BaseTestSuite{

	@Test(description = "")
	public void tc_cogmento_homepage_001() {
		
		ExtentReport.createTest("Verify and get all settings feature options available after click on to the setting button");
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
	}
		
		@Test(description = "Verify Create button of Deals feature and create new Deal")
		public void tc_cogmento_companiespage_088() {
			
			ExtentReport.createTest("Verify Create button of Deals feature and create new Deal");
			Log.info("Verify Create button of Deals feature and create new Deal");
			homePage.MenuNavigation(dealPage.dealsBtn,"Deals");
			dealPage.createBtn.click();
			Map<String,String> formData = new HashMap<String,String>();
			formData.put("Title","random");
			formData.put("Company","Test_Automation");
			formData.put("Amount", "600000");
			formData.put("ClosedDate", "closedDate");
			
			Map<String,String> dealMap = dealPage.createDeal(formData);
			System.out.println(dealMap.get("Amount"));
			System.out.println(dealMap.get("ClosedDate"));
			Assert.assertEquals(true, dealPage.createEventSaveBtn.isDisplayed(),"Save button is displayed");
			Assert.assertEquals(true,dealPage.createEventCancelBtn.isDisplayed(),"Cancel button is displayed");
			dealPage.createEventCancelBtn.click();
			ExtentLogger.pass("Verify Create button of Deals feature and create new Deal");
		}
		
		
		
	
}
