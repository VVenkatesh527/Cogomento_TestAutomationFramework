package com.crm.qa.cogmento.testcases;


import java.util.HashMap;
import java.util.Map;

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
		Assert.assertEquals(dealPage.dealsBtn.getAttribute("InnerText"),"Deals");
		ExtentLogger.pass("Verify deals page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		
	}
	
	@Test(description = "Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should be enabled and displayed")
	public void tc_cogmento_dealspage_032() {
		
		ExtentReport.createTest("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should be enabled and displayed");
		Log.info("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dropdownBtn.isEnabled()||dealPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(dealPage.showFilterBtn.getAttribute("InnerText"),"Show Filters");
		Assert.assertEquals(dealPage.exportBtn.getAttribute("InnerText"),"Export");
		Assert.assertEquals(dealPage.createBtn.getAttribute("InnerText"),"Create");
		Assert.assertEquals(dealPage.pipelineBtn.getAttribute("InnerText"),"Pipeline");
		Assert.assertEquals(dealPage.manageTargetsBtn.getAttribute("InnerText"),"Manage Targets");
		ExtentLogger.pass("Verify deals page has navigated verify Headers contains Pipeline, Dropdown, Board, Manage Targets, Showfilters, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify deals page has navigated once deals feature Is clicked Validate deal page Title should be Deals")
	public void tc_cogmento_dealspage_083() {
		
		ExtentReport.createTest("Verify deals page has navigated once deals feature Is clicked Validate deal page Title should be Deals");
		Log.info("Verify deals page has navigated once deals feature Is clicked Validate deals page Title should be Deals");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dealsTitle.isDisplayed());
		Assert.assertEquals(dealPage.dealsTitle.getAttribute("InnerText"),"Deals");
		ExtentLogger.pass("Verify Deals page has navigated once Deals feature Is clicked Validate Deals page Title should be Deals");
		
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
public void tc_cogmento_dealspage_037() {
		
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
	
	 
	@Test(description = "Verify and Validate Create New deal form page fill the form with some mandatory field")
	public void tc_cogmento_dealspage_039() {
		
		ExtentReport.createTest("Verify and Validate Create New deal form page fill the form with some mandatory field");
		Log.info("Verify and Validate Create New deal form page fill the form with some mandatory field");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.dealsTitle.isDisplayed());
		Assert.assertEquals(true, dealPage.dealsTitle.isEnabled());
		dealPage.createBtn.click();
		Assert.assertEquals(true, dealPage.createNewDealTitle.isDisplayed());
		//String output =basePage.selectDropdownValue(casesPage.statusBtn, "status","Enquiring");
		basePage.getRandomCompanyName(dealPage.companyBtn);
		//Assert.assertEquals("Enquiring",output);
		ExtentLogger.pass("Verify and Validate Create New deal form page fill the form with some mandatory field");
	}

	@Test(description = "Verify and Validate Export Feature in the deals page")
	public void tc_cogmento_dealspage_084() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the deals page");
		Log.info("Verify and Validate Export Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.exportBtn.isDisplayed());
		Assert.assertEquals(true,dealPage.exportBtn.isEnabled());
		dealPage.exportBtn.click();
		driver().switchTo().alert().accept();
		Assert.assertEquals(true, dealPage.dealsTitle.isDisplayed() && dealPage.dealsTitle.isEnabled());
		ExtentLogger.pass("Verify and Validate Export Feature in the deals page");
	
	}
	
	@Test(description = "Verify and Validate Create feature in the deals page and how many ways to create deal feature") 
	public void tc_cogmento_dealspage_038() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the deals page and how many ways to create deal feature");
		Log.info("Verify and Validate Create feature in the deals page and how many ways to create deal feature");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.createBtn.isDisplayed() && dealPage.createBtn.isEnabled());
		dealPage.createBtn.click();
		Assert.assertEquals(true, dealPage.createNewDealTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the deals page and how many ways to create deal feature");
		
	}
	
	@Test(description = "Verify and Validate Manage Targets Feature in the deals page")
	public void tc_cogmento_dealspage_085() {
		
		ExtentReport.createTest("Verify and Validate Manage Targets Feature in the deals page");
		Log.info("Verify and Validate Manage Targets Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.manageTargetsBtn.isDisplayed() && dealPage.manageTargetsBtn.isEnabled());
		dealPage.manageTargetsBtn.click();
		Assert.assertEquals(true, dealPage.salesTargetsTitle.isDisplayed() && dealPage.manageTargetsBtn.isEnabled());
		dealPage.backBtn.click();
		Assert.assertEquals(true, dealPage.dealsTitle.isDisplayed() && dealPage.dealsTitle.isEnabled());
		ExtentLogger.pass("Verify and Validate Manage Targets Feature in the deals page");
	
	}
	
	@Test(description = "Verify and Validate PipeLine Feature in the deals page")
	public void tc_cogmento_dealspage_086() {
		
		ExtentReport.createTest("Verify and Validate PipeLine Feature in the deals page");
		Log.info("Verify and Validate PipeLine Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.pipelineBtn.isDisplayed()&& dealPage.pipelineBtn.isEnabled());
		Assert.assertEquals(dealPage.pipelineBtn.getAttribute("InnerText"),"Pipeline");
		dealPage.pipelineBtn.click();
		driver().switchTo().alert();
		dealPage.cancelBtn.click();
		ExtentLogger.pass("Verify and Validate PipeLine Feature in the deals page");
		
	}
	
	@Test(description = "Verify and Validate Board Feature in the deals page")
	public void tc_cogmento_dealspage_087() {
		
		ExtentReport.createTest("Verify and Validate Board Feature in the deals page");
		Log.info("Verify and Validate Board Feature in the deals page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(dealPage.dealsBtn, "Deals");
		Assert.assertEquals(true, dealPage.boardBtn.isDisplayed()&& dealPage.boardBtn.isEnabled());
		Assert.assertEquals(dealPage.boardBtn.getAttribute("InnerText"),"Board");
		dealPage.boardBtn.click();
		Assert.assertEquals(true,dealPage.unassignedBtn.isDisplayed());
		ExtentLogger.pass("Verify and Validate PipeLine Feature in the deals page");
	}
	
	@Test(description = "Verify Create button of Deals feature and create new Deal")
	public void tc_cogmento_dealspage_088() {
		
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
	
	
	
}
