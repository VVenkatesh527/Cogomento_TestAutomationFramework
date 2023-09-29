package com.crm.qa.cogmento.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
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
		List<String> expectedList = homePage.settingListElements();
		Assert.assertEquals(actualList, expectedList);
		
		
		
	}
}
