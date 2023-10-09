package com.crm.qa.cogmento.testcases;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class DealPageTest extends BaseTestSuite{

	
	@Test(description = "Verify deals page is displayed and Enabled should be clickable when concure is moved to Menu tab")
	public void tc_cogmento_dealspage_031() {
		
		ExtentReport.createTest("Verify deals page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify deals page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		Assert.assertEquals(true, dealPage.dealsBtn.isDisplayed());
		Assert.assertEquals(dealPage.dealsBtn.getAttribute("textContent"),"Deals");
		ExtentLogger.pass("Verify deals page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		
	}
	
	@Test(description = "Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should be enabled and displayed")
	public void tc_cogmento_dealspage_032() {
		
		ExtentReport.createTest("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should be enabled and displayed");
		Log.info("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dropdownBtn.isEnabled()||dealPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(dealPage.showFilterBtn.getAttribute("textContent"),"Show Filters");
		Assert.assertEquals(dealPage.exportBtn.getAttribute("textContent"),"Export");
		Assert.assertEquals(dealPage.createBtn.getAttribute("textContent"),"Create");
		Assert.assertEquals(dealPage.pipelineBtn.getAttribute("textContent"),"Pipeline");
		Assert.assertEquals(dealPage.manageTargetsBtn.getAttribute("textContent"),"Manage Targets");
		ExtentLogger.pass("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_dealspage_033() {
		
		ExtentReport.createTest("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets,showfilter, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true,dealPage.pipelineBtn.isDisplayed());
		
		Assert.assertEquals(true, dealPage.dropdownBtn.isDisplayed());
		dealPage.dropdownBtn.click();
		Assert.assertEquals(true,dealPage.showFilterBtn.isDisplayed());
		dealPage.showFilterBtn.click();
		Assert.assertEquals(dealPage.exportBtn.getAttribute("textContent"),"Export");
		Assert.assertEquals(dealPage.createBtn.getAttribute("textContent"),"Create");
		
		Assert.assertEquals(dealPage.manageTargetsBtn.getAttribute("textContent"),"Manage Targets");
		ExtentLogger.pass("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify deals page had table and verify table headers and verify number of columns available, data in rows of table",enabled = true)
	public void tc_cogmento_dealspage_034() {
		
		Map<Integer,HashMap<String,String>> expectedData = null;
		Map<Integer,HashMap<String,String>> actualData = null;
		ExtentReport.createTest("Verify deals page had table and verify table headers and verify number of columns available, data in rows of table");
		Log.info("Verify deals page had table and verify table headers and verify number of columns available, data in rows of table");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		dealPage.createBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData.put("Title",basePage.getRandomTitle());
		formData.put("Company","Test_Automation");
		formData.put("Amount", RandomStringUtils.randomNumeric(6));
		//formData.put("ClosedDate", "dd MMMM yyyy");
		HashMap<String,String> dealMap = dealPage.createDeal(formData);
		dealPage.createEventSaveBtn.click();
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		tableOperator.applyFiltersToColumns("Title", "Equals",dealMap.get("Title"));
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
		expectedData.put(rowCount, dealMap);      
		Assert.assertEquals(actualData, expectedData);
        ExtentLogger.pass("Verify deals page had table and verify table headers and verify number of columns available, data in rows of table");
	}
	
	
	
	@Test(description = "Verify deals page contains dropdown button click on it, it should contain default view in the dropdown")
public void tc_cogmento_dealspage_036() {
		
		ExtentReport.createTest("Verify deals page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify deals page contains dropdown button click on it, it should contain default view in the dropdown");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dropdownBtn.isEnabled()||dealPage.dropdownBtn.isDisplayed());
		contactsPage.dropdownBtn.click();
		Assert.assertEquals(true, dealPage.defaultViewField.isDisplayed()||dealPage.defaultViewField.isEnabled());
		ExtentLogger.pass("Verify deals page contains dropdown button click on it, it should contain default view in the dropdown");
		
	}
	
	@Test(description = "Verify and Validate Showfilters Feature in the deals page")
public void tc_cogmento_dealspage_037and35() {
		
		ExtentReport.createTest("Verify and Validate Showfilters Feature in the deals page");
		Log.info("Verify and Validate Showfilters Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.showFilterBtn.isDisplayed()||dealPage.showFilterBtn.isEnabled());
		contactsPage.showFilterBtn.click();
		Assert.assertEquals(true, dealPage.hideFilterBtn.isDisplayed()||dealPage.hideFilterBtn.isEnabled());
		Assert.assertEquals(true, dealPage.addFilterRowFilterBtn.isDisplayed()||dealPage.addFilterRowFilterBtn.isEnabled());
		dealPage.addFilterRowFilterBtn.click();
		Assert.assertEquals(true, dealPage.searchDropdownBtn.isDisplayed()&&dealPage.searchDropdownBtn.isEnabled());
		ExtentLogger.pass("Verify and Validate Showfilters Feature in the deals page");
	
	}
	
	@Test(description = "Verify and Validate Create feature in the deals page and how many ways to create deals feature")
	public void tc_cogmento_dealspage_038() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the deals page and how many ways to create deals feature");
		Log.info("Verify and Validate Create feature in the deals page and how many ways to create deals feature");
		homePage.MenuNavigation(dealPage.dealsBtn,"Deals");
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed());
		Assert.assertEquals(true, dealPage.createBtn.isDisplayed());
		dealPage.createBtn.click();
		Assert.assertEquals(true, dealPage.createNewDealTitle.isDisplayed());
		dealPage.cancelBtn.click();
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed());
		homePage.navigateToMenu(dealPage.dealsBtn);
		dealPage.dealsPlusBtn.click();
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the deals page and how many ways to create deals feature");

	}
	
	 
	@Test(description = "Verify and Validate Create New deal form page fill the form without some mandatory field")
	public void tc_cogmento_dealspage_039() {
		
		ExtentReport.createTest("Verify and Validate Create New deal form page fill the form without some mandatory field");
		Log.info("Verify and Validate Create New deal form page fill the form without some mandatory field");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed());
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isEnabled());
		dealPage.createBtn.click();
		
		Assert.assertEquals(true, dealPage.createNewDealTitle.isDisplayed());
		basePage.getRandomCompanyName(dealPage.companyBtn);
		ExtentLogger.pass("Verify and Validate Create New deal form page fill the form without some mandatory field");
	}
	
	@Test(description = "Verify Create button of Deals feature and create new Deal",enabled =false)
	public void tc_cogmento_dealspage_040() {
		
		ExtentReport.createTest("Verify Create button of Deals feature and create new Deal");
		Log.info("Verify Create button of Deals feature and create new Deal");
		homePage.MenuNavigation(dealPage.dealsBtn,"Deals");
		dealPage.createBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData.put("Title","random");
		formData.put("Company","Test_Automation");
		formData.put("Amount", "600000");
		formData.put("ClosedDate", "dd MMMM yyyy");
		Map<String,String> dealMap = dealPage.createDeal(formData);
		Assert.assertEquals(dealMap, formData ,"Both had different value");
		Assert.assertEquals(true, dealPage.createEventSaveBtn.isDisplayed(),"Save button is displayed");
		Assert.assertEquals(true,dealPage.createEventCancelBtn.isDisplayed(),"Cancel button is displayed");
		dealPage.createEventCancelBtn.click();
		ExtentLogger.pass("Verify Create button of Deals feature and create new Deal");
	}

	@Test(description = "Verify and Validate Export Feature in the deals page")
	public void tc_cogmento_dealspage_041() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the deals page");
		Log.info("Verify and Validate Export Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.exportBtn.isDisplayed());
		Assert.assertEquals(true,dealPage.exportBtn.isEnabled());
		dealPage.exportBtn.click();
		driver().switchTo().alert().accept();
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed() && dealPage.dealsTitleLocator.isEnabled());
		ExtentLogger.pass("Verify and Validate Export Feature in the deals page");
	
	}
	
	@Test(description = "Verify and Validate Manage Targets Feature in the deals page")
	public void tc_cogmento_dealspage_042() {
		
		ExtentReport.createTest("Verify and Validate Manage Targets Feature in the deals page");
		Log.info("Verify and Validate Manage Targets Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.manageTargetsBtn.isDisplayed() && dealPage.manageTargetsBtn.isEnabled());
		dealPage.manageTargetsBtn.click();
		Assert.assertEquals(true, dealPage.salesTargetsTitle.isDisplayed());
		List<String> actualList =new ArrayList<>();
		actualList.add("Back");
		actualList.add("Active targets");
		actualList.add("Ongoing targets");
		actualList.add("Create");
		Assert.assertEquals(actualList, homePage.convertWebElementToStringList(dealPage.salesTargetHeaderList));
		ExtentLogger.pass("Verify and Validate Manage Targets Feature in the deals page");
	
	}
	
	@Test(description = "Verify and Validate PipeLine Feature in the deals page")
	public void tc_cogmento_dealspage_043() {
		
		ExtentReport.createTest("Verify and Validate PipeLine Feature in the deals page");
		Log.info("Verify and Validate PipeLine Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.pipelineBtn.isDisplayed()&& dealPage.pipelineBtn.isEnabled());
		Assert.assertEquals(dealPage.pipelineBtn.getAttribute("textContent"),"Pipeline");
		dealPage.pipelineBtn.click();
		ExtentLogger.pass("Verify and Validate PipeLine Feature in the deals page");
		
	}
	
	@Test(description = "Verify and Validate Board Feature in the deals page")
	public void tc_cogmento_dealspage_044() {
		
		ExtentReport.createTest("Verify and Validate Board Feature in the deals page");
		Log.info("Verify and Validate Board Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.boardBtn.isDisplayed()&& dealPage.boardBtn.isEnabled());
		Assert.assertEquals(dealPage.boardBtn.getAttribute("textContent"),"Board");
		dealPage.boardBtn.click();
		Assert.assertEquals(true,dealPage.unassignedBtn.isDisplayed());
		ExtentLogger.pass("Verify and Validate PipeLine Feature in the deals page");
	}
	
	@Test(description = "Verify deals page has navigated once deals feature Is clicked Validate deal page Title should be Deals")
	public void tc_cogmento_dealspage_035() {
		
		ExtentReport.createTest("Verify deals page has navigated once deals feature Is clicked Validate deal page Title should be Deals");
		Log.info("Verify deals page has navigated once deals feature Is clicked Validate deals page Title should be Deals");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dealsTitleLocator.isDisplayed());
		Assert.assertEquals(dealPage.dealsTitleLocator.getAttribute("InnerText"),"Deals");
		ExtentLogger.pass("Verify Deals page has navigated once Deals feature Is clicked Validate Deals page Title should be Deals");
		
	}
	
	
	
	
	
}
