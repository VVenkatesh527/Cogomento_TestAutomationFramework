package com.crm.qa.cogmento.testcases;

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
		Assert.assertEquals(true, contactsPage.contactsBtn.isDisplayed());
		Assert.assertEquals(contactsPage.contactsBtn.getAttribute("InnerText"),"Contacts");
		ExtentLogger.pass("Verify contacts page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	}

	@Test(description = "Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts")
	public void tc_cogmento_contactspage_012() {
		
		ExtentReport.createTest("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		Log.info("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		contactsPage.MenuNavigation("Contacts");
		Assert.assertEquals(true, contactsPage.contactsTitle.isDisplayed());
		Assert.assertEquals(contactsPage.contactsTitle.getAttribute("InnerText"),"Contacts");
		ExtentLogger.pass("Verify contacts page has navigated once contacts feature Is clicked Validate Contacts page Title should be Contacts");
		
	}
	
	@Test(description = "Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_contactspage_013() {
		
		ExtentReport.createTest("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		contactsPage.MenuNavigation("Contacts");
		Assert.assertEquals(true, contactsPage.dropdownBtn.isEnabled()||contactsPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(contactsPage.showFilterBtn.getAttribute("InnerText"),"Show Filters");
		Assert.assertEquals(contactsPage.exportBtn.getAttribute("InnerText"),"Export");
		Assert.assertEquals(contactsPage.createBtn.getAttribute("InnerText"),"Create");
		ExtentLogger.pass("Verify contacts page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_contactspage_016() {
		
		ExtentReport.createTest("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		contactsPage.MenuNavigation("Contacts");
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
		contactsPage.MenuNavigation("Contacts");
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
		contactsPage.MenuNavigation("Contacts");
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
		contactsPage.MenuNavigation("Contacts");
		Assert.assertEquals(true, contactsPage.createBtn.isDisplayed() && contactsPage.createBtn.isEnabled());
		contactsPage.createBtn.click();
		Assert.assertEquals(true, contactsPage.createNewContactTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the contacts page and how many ways to create contacts feature");
	}

}
