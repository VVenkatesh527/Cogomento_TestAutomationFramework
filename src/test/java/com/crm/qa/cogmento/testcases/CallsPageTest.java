package com.crm.qa.cogmento.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class CallsPageTest  extends BaseTestSuite{
	
	@Test(description = "Verify and Validate Create New Calls form page contains Type dropdown select value click on save button ")
	public void tc_cogmento_callspage_077() {
		
		ExtentReport.createTest("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button ");
		Log.info("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		callsPage.callscreateBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData = callsPage.createFormData(formData);
		Assert.assertEquals(true ,callsPage.createEventSaveBtn.isDisplayed());
		Assert.assertEquals(true ,callsPage.createEventCancelBtn.isDisplayed());
		callsPage.createEventCancelBtn.click();
		ExtentLogger.pass("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button");
	}

}
