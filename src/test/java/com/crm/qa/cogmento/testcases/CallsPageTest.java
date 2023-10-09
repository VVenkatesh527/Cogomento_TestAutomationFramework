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

public class CallsPageTest  extends BaseTestSuite{
	
	@Test(description = "Verify Calls page is displayed and Enabled should be clickable when concure is moved to Menu tab")
	public void tc_cogmento_callspage_068() {
		
		ExtentReport.createTest("Verify Calls page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify Calls page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		homePage.navigateToMenu(callsPage.callsBtn);
		Assert.assertEquals(true, callsPage.callsBtn.isDisplayed());
		callsPage.callsBtn.click();
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		ExtentLogger.pass("Verify Calls page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	}
	
	@Test(description = "Verify Calls page has navigated once Cases feature Is clicked and Verify All header are visiable")
	public void tc_cogmento_callspage_069() {
		
		ExtentReport.createTest("Verify Calls page has navigated once Cases feature Is clicked and Verify All header are visiable");
		Log.info("Verify Calls page has navigated once Cases feature Is clicked and Verify All header are visiable");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.viewDropdownBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.showFiltersBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.exportBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.createBtn.isDisplayed());
		ExtentLogger.pass("Verify Calls page has navigated once Cases feature Is clicked and Verify All header are visiable");
	}
	
	@Test(description = "Verify Calls page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_callspage_070() {
		
		ExtentReport.createTest("Verify Calls page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify Calls page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
		homePage.MenuNavigation(callsPage.callsBtn,"Cases");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.viewDropdownBtn.isDisplayed());
		callsPage.viewDropdownBtn.click();
		Assert.assertEquals(true, callsPage.defaultViewBtn.isDisplayed());
		callsPage.defaultViewBtn.click();
		Assert.assertEquals(true, callsPage.showFiltersBtn.isDisplayed());
		callsPage.showFiltersBtn.click();
		Assert.assertEquals(true, callsPage.hideFiltersBtn.isDisplayed());
		callsPage.hideFiltersBtn.click();
		Assert.assertEquals(true, callsPage.exportBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.createBtn.isDisplayed());
		callsPage.createBtn.click();
		Assert.assertEquals(true, callsPage.createNewCallsTitle.isDisplayed());
		ExtentLogger.pass("Verify Calls page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
	}
	
	@Test(description = "Verify and Validate Show filter Feature in the Calls page")
	public void tc_cogmento_callspage_072() {
		
		ExtentReport.createTest("Verify and Validate Show filter Feature in the Calls page");
		Log.info("Verify and Validate Show filter Feature in the Calls page");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.showFiltersBtn.isEnabled());
		callsPage.showFiltersBtn.click();
		Assert.assertEquals(true, callsPage.addFilterRowFilterBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.searchDropdownBtn.isEnabled());
		callsPage.searchDropdownBtn.click();
		List<String> actualList =new ArrayList<>();
		actualList.add("Assigned To");
		actualList.add("Type");
		actualList.add("Status");
		actualList.add("Call Script");
		actualList.add("Duration");
		actualList.add("Start Time");
		actualList.add("Flag");
		actualList.add("Tags");
		actualList.add("Description");
		actualList.add("Participants");
		actualList.add("Deal");
		actualList.add("Case");
		actualList.add("Task");
		actualList.add("Conference Call Number");
		actualList.add("Price");
		actualList.add("Identifier");
		List<String> expectedsearchList = homePage.convertWebElementToStringList(callsPage.sreachShowFilterDropdown);
		Assert.assertEquals(actualList, expectedsearchList);
		ExtentLogger.pass("Verify and Validate Show filter Feature in the Calls page");

	}
	@Test(description = "Verify Calls page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_callspage_073() {
		
		ExtentReport.createTest("Verify Calls page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify Calls page contains dropdown button click on it, it should contain default view in the dropdown");
		homePage.MenuNavigation(callsPage.callsBtn,"Cases");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.viewDropdownBtn.isDisplayed());
		callsPage.viewDropdownBtn.click();
		Assert.assertEquals(true, callsPage.defaultViewBtn.isDisplayed());
		callsPage.defaultViewBtn.click();
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		ExtentLogger.pass("Verify Calls page contains dropdown button click on it, it should contain default view in the dropdown");
	}
	
	@Test(description = "Verify and Validate Export Feature in the Calls page")
	public void tc_cogmento_callspage_074() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the Calls page");
		Log.info("Verify and Validate Export Feature in the Calls page");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		Assert.assertEquals(true, callsPage.exportBtn.isEnabled());
		callsPage.exportBtn.click();
		String actualpopmessage = callsPage.popMessage.getAttribute("textContent");
		Assert.assertEquals(actualpopmessage, "Press OK to begin the export or Cancel to close this message.");
		Assert.assertEquals(true, callsPage.cancelBtn.isDisplayed());
		callsPage.okBtn.click();
		ExtentLogger.pass("Verify and Validate Export Feature in the Calls page");
		
	}
	
	@Test(description = "Verify and Validate Create feature in the Calls page and how many ways to create Call feature")
	public void tc_cogmento_callspage_075() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the Calls page and how many ways to create Call feature");
		Log.info("Verify and Validate Create feature in the Calls page and how many ways to create Call feature");
		homePage.MenuNavigation(casesPage.casesBtn,"Calls");
		Assert.assertEquals(true, callsPage.callsTitleBtn.isDisplayed());
		callsPage.createBtn.click();
		Assert.assertEquals(true, callsPage.createNewCallsTitle.isDisplayed());
		callsPage.cancelBtn.click();
		homePage.MenuNavigation(homePage.homeBtn, "Home");
		Assert.assertEquals(true, callsPage.homePageDealsummaryLocator.isDisplayed());
		homePage.navigateToMenu(callsPage.callsBtn);
		Assert.assertEquals(true, callsPage.createCallUsingPlusBtn.isDisplayed());
		callsPage.createCallUsingPlusBtn.click();
		Assert.assertEquals(true, callsPage.createNewCallsTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the Calls page and how many ways to create Call feature");
		
	}
	//Failed
	@Test(description = "Verify and Validate Create New Calls form page contains Type dropdown select value click on save button ")
	public void tc_cogmento_callspage_077() {
		Map<Integer,HashMap<String,String>> expectedData = new HashMap<Integer,HashMap<String,String>>();
		Map<Integer,HashMap<String,String>> actualData = new HashMap<Integer,HashMap<String,String>>();
		ExtentReport.createTest("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button ");
		Log.info("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button");
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		callsPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Participants", callsPage.getRandomParticipants(callsPage.participantsLocator));
		formData.put("Type", basePage.selectRandomDropDownValue("type"));
		formData.put("Deal", basePage.getRandomDeal(callsPage.dealSearchBtn,"deal"));
		formData.put("Flag", basePage.getRandomDeal(callsPage.flagDropDownBtn,"flag"));
		HashMap<String,String> callMap = callsPage.createCall(formData);
		callsPage.createEventSaveBtn.click();
		homePage.MenuNavigation(callsPage.callsBtn,"Calls");
		tableOperator.applyFiltersToColumns("Participants", "Equals",formData.get("Participants"));
		//1
		int rowCount = tableOperator.getRowCount();
		if(rowCount>=1) {
			actualData = tableOperator.getTableData();
		}
		else
			{
			   ExtentLogger.fail("No Data Displayed in Deal's Grid");
			   Assert.assertFalse(rowCount<1);
			}
		
		expectedData.put(rowCount, callMap);     
		Assert.assertEquals(actualData, expectedData);
		ExtentLogger.pass("Verify and Validate Create New Calls form page contains Type dropdown select value click on save button");
	}

}
