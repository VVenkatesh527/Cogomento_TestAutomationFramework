package com.crm.qa.cogmento.testcases;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class ContactsPageTest extends BaseTestSuite {
	
	
	@Test(description = "Verify contacts page is displayed and Enabled when concure is moved to Menu tab")
	public void tc_cogmento_contactspage_011() {

		ExtentReport.createTest("Verify contacts page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify contacts page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.navigateToMenu(contactsPage.contactsBtn);
		Assert.assertEquals(true, contactsPage.contactsBtn.isDisplayed());
		ExtentLogger.pass("Verify contacts page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	
	}

	@Test(description = "Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts")
	public void tc_cogmento_contactspage_012() {
		
		ExtentReport.createTest("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		Log.info("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed());
		Assert.assertEquals(contactsPage.contactsTitle.getAttribute("textContent"),"Contacts");
		ExtentLogger.pass("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		
	}
	
	@Test(description = "Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_contactspage_013() {
		
		ExtentReport.createTest("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.dropdownBtn.isEnabled());
		Assert.assertEquals(true, contactsPage.dropdownBtn.isDisplayed());
		Assert.assertEquals("Show Filters",basePage.getElementValue(contactsPage.contactsBtn));
		Assert.assertEquals(contactsPage.exportBtn.getAttribute("InnerText"),"Export");
		Assert.assertEquals(contactsPage.createBtn.getAttribute("InnerText"),"Create");
		ExtentLogger.pass("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_contactspage_016() {
		
		ExtentReport.createTest("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.dropdownBtn.isEnabled()||contactsPage.dropdownBtn.isDisplayed());
		contactsPage.dropdownBtn.click();
		Assert.assertEquals(true, contactsPage.defaultViewField.isDisplayed()||contactsPage.defaultViewField.isEnabled());
		ExtentLogger.pass("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		
	}
	
	@Test(description = "Verify and Validate showFilter Feature in the contacts page")
	public void tc_cogmento_contactspage_081() {
		
		ExtentReport.createTest("Verify and Validate showFilter Feature in the contacts page");
		Log.info("Verify and Validate showFilter Feature in the contacts page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.showFilterBtn.isDisplayed()||contactsPage.showFilterBtn.isEnabled());
		contactsPage.showFilterBtn.click();
		Assert.assertEquals(true, contactsPage.hideFilterBtn.isDisplayed()||contactsPage.hideFilterBtn.isEnabled());
		Assert.assertEquals(true, contactsPage.addFilterRowFilterBtn.isDisplayed()||contactsPage.addFilterRowFilterBtn.isEnabled());
		contactsPage.addFilterRowFilterBtn.click();
		Assert.assertEquals(true, contactsPage.searchDropdownBtn.isDisplayed()&&contactsPage.searchDropdownBtn.isEnabled());
		ExtentLogger.pass("Verify and Validate showFilter Feature in the contacts page");
	}
	
	@Test(description = "Verify and Validate Export Feature in the contacts page")
	public void tc_cogmento_contactspage_017() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the contacts page");
		Log.info("Verify and Validate Export Feature in the contacts page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.exportBtn.isDisplayed() && contactsPage.exportBtn.isEnabled());
		contactsPage.exportBtn.click();
		driver().switchTo().alert().accept();
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed() && contactsPage.contactsTitle.isEnabled());
		ExtentLogger.pass("Verify and Validate Export Feature in the contacts page");
	}
	
	@Test(description = "Verify and Validate Create feature in the contacts page and how many ways to create contacts feature")
	public void tc_cogmento_contactspage_018() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the contacts page and how many ways to create contacts feature");
		Log.info("Verify and Validate Create feature in the contacts page and how many ways to create contacts feature");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed());
		contactsPage.createBtn.click();
		Assert.assertEquals(true, contactsPage.createNewContactTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the contacts page and how many ways to create contacts feature");
	}
	
	@Test(description = "Verify and Validate Create New Contact form page fill the form with some mandatory field ")
	public void tc_cogmento_contactspage_019() {
		
		ExtentReport.createTest("Verify and Validate Create New Contact form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New Contact form page fill the form with some mandatory field");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed());
		Assert.assertEquals(true, contactsPage.contactsTitle.isEnabled());
		contactsPage.createBtn.click();
		
		Assert.assertEquals(true, contactsPage.createNewContactTitle.isDisplayed());
		String output =basePage.selectDropdownValue(contactsPage.categoryBtn, "category","Lead");
		Assert.assertEquals("Lead",output);
		ExtentLogger.pass("Verify and Validate Create New Contact form page fill the form with some mandatory field using selectDropdownValue Method");
	}
	
	@Test(description = "Verify and Validate Create New Contact form page fill the form withoutmandatory field using selectDropdownValue Method")
	public void tc_cogmento_contactspage_020() {
		
		ExtentReport.createTest("Verify and Validate Create New Contact form page fill the form without mandatory field using selectDropdownValue Method");
		Log.info("Verify and Validate Create New Contact form page fill the form without mandatory field using selectDropdownValue Method");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed());
		Assert.assertEquals(true, contactsPage.contactsTitle.isEnabled()); 
		contactsPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Email","random");
		formData.put("Phone", RandomStringUtils.randomNumeric(10));
		contactsPage.createContact(formData);
		contactsPage.createEventSaveBtn.click();
		Assert.assertEquals(true, contactsPage.errorMessageFirstNameLocator.isDisplayed());
		Assert.assertEquals(true, contactsPage.errorMessageLastNameLocator.isDisplayed());
		Assert.assertEquals(true, contactsPage.createNewContactTitle.isDisplayed());
		basePage.getRandomCompanyName(contactsPage.companyBtn);
		ExtentLogger.pass("Verify and Validate Create New Contact form page fill the form without mandatory field using selectDropdownValue Method");
	}
	
	@Test(description = "Verify and Validate Create New contacts form page fill the form with some mandatory field ",enabled = true)
	public void tc_cogmento_contactspage_029() {
		
		HashMap<Integer,HashMap<String,String>> expectedData = new HashMap<>();
		HashMap<Integer,HashMap<String,String>> actualData =  new HashMap<>();
		ExtentReport.createTest("Verify and Validate Create New contacts form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New contacts form page fill the form with some mandatory field ");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn,"Contacts");
		contactsPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("FirstName","Test");
		formData.put("LastName","random");
		formData.put("Email","random");
		formData.put("Phone", RandomStringUtils.randomNumeric(6));
		//formData.put("ClosedDate", "dd MMMM yyyy");
		HashMap<String,String> contactMap = contactsPage.createContact(formData);
		contactsPage.createEventSaveBtn.click();
		homePage.MenuNavigation(contactsPage.contactsBtn, "Contacts");
		tableOperator.applyFiltersToColumns("FirstName", "Equals",contactMap.get("FirstName"));
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
		expectedData.put(rowCount, contactMap);      
		Assert.assertEquals(actualData, expectedData);
        ExtentLogger.pass("Verify and Validate Create New Company form page fill the form with some mandatory field ");
	}
	
	@Test(description = "Verify and Validate Create New contacts form page contains Category dropdown select value click on save button",enabled = true)
	public void tc_cogmento_contactspage_030() {
		
		ExtentReport.createTest("Verify and Validate Create New contacts form page contains Category dropdown select value click on save button");
		Log.info("Verify and Validate Create New contacts form page contains Category dropdown select value click on save button");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(contactsPage.contactsBtn, "Contacts");
		contactsPage.createBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData.put("Category", "random");
		//formData.put("ClosedDate", "dd MMMM yyyy");
		HashMap<String,String> dealMap = dealPage.createDeal(formData);
		dealPage.createEventSaveBtn.click();
		Assert.assertEquals(true, contactsPage.errorMessageFirstNameLocator.isDisplayed());
		Assert.assertEquals(true, contactsPage.errorMessageLastNameLocator.isDisplayed());		
		ExtentLogger.pass("Verify and Validate Create New contacts form page contains Category dropdown select value click on save button");
	}


}
