package com.crm.qa.cogmento.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class CasesPageTest extends BaseTestSuite{
	
	@Test(description = "Verify and Validate Create New case form page fill the form with some mandatory field ")
	public void tc_cogmento_casespage_088() {
		
		ExtentReport.createTest("Verify and Validate Create New case form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New Contact form page fill the form with some mandatory field");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.casesTitle.isEnabled());
		casesPage.createBtn.click();
		Assert.assertEquals(true, casesPage.createNewCaseTitle.isDisplayed());
		//String output =basePage.selectDropdownValue(casesPage.statusDownArrowBtn, "Status","Enquiring");
		basePage.getRandomCompanyName(casesPage.companyDownArrowBtn);
		//Assert.assertEquals("Enquiring",output);
		ExtentLogger.pass("Verify and Validate Create New case form page fill the form with some mandatory field using selectDropdownValue Method");
	}
	
	@Test(description = "Verify and Validate Create New Case form page fill the form with some mandatory field ")
	public void tc_cogmento_callspage_066() {
		
		ExtentReport.createTest("Verify and Validate Create New Case form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New Case form page fill the form with some mandatory field ");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		callsPage.callscreateBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData = casesPage.createCaseForm(formData);
		Assert.assertEquals(true ,casesPage.createEventSaveBtn.isDisplayed());
		Assert.assertEquals(true ,casesPage.createEventCancelBtn.isDisplayed());
		callsPage.createEventCancelBtn.click();
		ExtentLogger.pass("Verify and Validate Create New Case form page fill the form with some mandatory field ");
	}

}
