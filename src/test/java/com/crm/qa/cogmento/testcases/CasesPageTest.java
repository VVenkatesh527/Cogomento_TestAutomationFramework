package com.crm.qa.cogmento.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class CasesPageTest extends BaseTestSuite{
	
	@Test(description = "Verify Cases page is displayed and Enabled should be clickable when concure is moved to Menu tab")
	public void tc_cogmento_casespage_058() {
		
		ExtentReport.createTest("Verify Cases page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify Cases page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		homePage.navigateToMenu(casesPage.casesBtn);
		Assert.assertEquals(true, casesPage.casesBtn.isDisplayed());
		casesPage.casesBtn.click();
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		ExtentLogger.pass("Verify Cases page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	}
	
	@Test(description = "Verify Cases page has navigated once Cases feature Is clicked and Verify All header are visiable")
	public void tc_cogmento_casespage_059() {
		
		ExtentReport.createTest("Verify Cases page has navigated once Cases feature Is clicked and Verify All header are visiable");
		Log.info("Verify Cases page has navigated once Cases feature Is clicked and Verify All header are visiable");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.viewDropdownBtn.isDisplayed());
		Assert.assertEquals(true, casesPage.showFiltersBtn.isDisplayed());
		Assert.assertEquals(true, casesPage.exportBtn.isDisplayed());
		Assert.assertEquals(true, casesPage.createBtn.isDisplayed());
		ExtentLogger.pass("Verify Cases page has navigated once Cases feature Is clicked and Verify All header are visiable");
	}
	
	@Test(description = "Verify Cases page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_casespage_060() {
		
		ExtentReport.createTest("Verify Cases page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify Cases page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.viewDropdownBtn.isDisplayed());
		casesPage.viewDropdownBtn.click();
		Assert.assertEquals(true, casesPage.defaultViewBtn.isDisplayed());
		casesPage.defaultViewBtn.click();
		Assert.assertEquals(true, casesPage.showFiltersBtn.isDisplayed());
		casesPage.showFiltersBtn.click();
		Assert.assertEquals(true, casesPage.hideFiltersBtn.isDisplayed());
		casesPage.hideFiltersBtn.click();
		Assert.assertEquals(true, casesPage.exportBtn.isDisplayed());
		Assert.assertEquals(true, casesPage.createBtn.isDisplayed());
		casesPage.createBtn.click();
		Assert.assertEquals(true, casesPage.createNewCaseTitle.isDisplayed());
		ExtentLogger.pass("Verify Cases page has navigated verify Headers contains dropdwon,showfilter, Export, Create this all Headers should enabled and displayed");
	}
	
	@Test(description = "Verify Cases page had table and verify table headers and verify number of columns available and Validate table data")
public void tc_cogmento_casespage_061() {
		
		HashMap<Integer,HashMap<String,String>> expectedData = null;
		HashMap<Integer, HashMap<String, String>> actualData = null;
		ExtentReport.createTest("Verify Cases page had table and verify table headers and verify number of columns available and Validate table data");
		Log.info("Verify Cases page had table and verify table headers and verify number of columns available and Validate table data");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		casesPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Title", basePage.getRandomTitle());
		formData.put("Status", basePage.selectRandomDropDownValue("status"));
		formData.put("Type", basePage.selectRandomDropDownValue("type"));
		formData.put("Company", basePage.getRandomDeal(casesPage.companyDownArrowBtn,"company"));
		HashMap<String,String> caseMap = casesPage.createCase(formData);
		casesPage.createEventSaveBtn.click();
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
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
		expectedData.put(rowCount, caseMap);     
		Assert.assertEquals(actualData, expectedData);
		ExtentLogger.pass("Verify Cases page had table and verify table headers and verify number of columns available and Validate table data");
	}
	
	@Test(description = "Verify and Validate Show filter Feature in the Cases page")
	public void tc_cogmento_casespage_062() {
		
		ExtentReport.createTest("Verify and Validate Show filter Feature in the Cases page");
		Log.info("Verify and Validate Show filter Feature in the Cases page");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.showFiltersBtn.isEnabled());
		casesPage.showFiltersBtn.click();
		Assert.assertEquals(true, casesPage.addFilterRowFilterBtn.isDisplayed());
		Assert.assertEquals(true, casesPage.searchDropdownBtn.isEnabled());
		callsPage.searchDropdownBtn.click();
		List<String> actualList =new ArrayList<>();
		actualList.add("Assigned To");
		actualList.add("Contact");
		actualList.add("Company");
		actualList.add("Deal");
		actualList.add("Type");
		actualList.add("Deadline");
		actualList.add("Close Date");
		actualList.add("Tags");
		actualList.add("Description");
		actualList.add("Priority");
		actualList.add("Status");
		actualList.add("Identifier");
		actualList.add("Created at");
		List<String> expectedsearchList = homePage.convertWebElementToStringList(casesPage.sreachShowFilterDropdown);
		Assert.assertEquals(actualList, expectedsearchList);
		ExtentLogger.pass("Verify and Validate Show filter Feature in the Cases page");

	}
	
	@Test(description = "Verify Cases page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_casespage_063() {
		
		ExtentReport.createTest("Verify Cases page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify Cases page contains dropdown button click on it, it should contain default view in the dropdown");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.viewDropdownBtn.isDisplayed());
		casesPage.viewDropdownBtn.click();
		Assert.assertEquals(true, casesPage.defaultViewBtn.isDisplayed());
		casesPage.defaultViewBtn.click();
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		ExtentLogger.pass("Verify Cases page contains dropdown button click on it, it should contain default view in the dropdown");
	}
	
	@Test(description = "Verify and Validate Export Feature in the Cases page")
	public void tc_cogmento_casespage_064() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the Cases page");
		Log.info("Verify and Validate Export Feature in the Cases page");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		Assert.assertEquals(true, casesPage.exportBtn.isEnabled());
		casesPage.exportBtn.click();
		String actualpopmessage = casesPage.popMessage.getAttribute("textContent");
		Assert.assertEquals(actualpopmessage, "Press OK to begin the export or Cancel to close this message.");
		Assert.assertEquals(true, casesPage.cancelBtn.isDisplayed());
		casesPage.okBtn.click();
		ExtentLogger.pass("Verify and Validate Export Feature in the Cases page");
		
	}
	
	@Test(description = "Verify and Validate Create feature in the Cases page and how many ways to create case feature")
	public void tc_cogmento_casespage_065() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the Cases page and how many ways to create case feature");
		Log.info("Verify and Validate Create feature in the Cases page and how many ways to create case feature");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		Assert.assertEquals(true, casesPage.casesTitle.isDisplayed());
		casesPage.createBtn.click();
		Assert.assertEquals(true, casesPage.createNewCaseTitle.isDisplayed());
		casesPage.cancelBtn.click();
		homePage.MenuNavigation(homePage.homeBtn, "Home");
		Assert.assertEquals(true, casesPage.homePageDealsummaryLocator.isDisplayed());
		homePage.navigateToMenu(casesPage.casesBtn);
		Assert.assertEquals(true, casesPage.createUsingPlusBtn.isDisplayed());
		casesPage.createUsingPlusBtn.click();
		Assert.assertEquals(true, casesPage.createNewCaseTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the Cases page and how many ways to create case feature");
		
	}
	
	
	@Test(description = "Verify and Validate Create New Case form page fill the form with some mandatory field ")
	public void tc_cogmento_casespage_066() {
		
		ExtentReport.createTest("Verify and Validate Create New Case form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New Case form page fill the form with some mandatory field ");
		homePage.MenuNavigation(casesPage.casesBtn,"Cases");
		casesPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData = casesPage.createCase(formData);
		Assert.assertEquals(true ,casesPage.createEventSaveBtn.isDisplayed());
		Assert.assertEquals(true ,casesPage.createEventCancelBtn.isDisplayed());
		casesPage.createEventCancelBtn.click();
		ExtentLogger.pass("Verify and Validate Create New Case form page fill the form with some mandatory field ");
		
	}

	
}
