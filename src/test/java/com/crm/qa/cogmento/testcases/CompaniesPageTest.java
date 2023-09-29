package com.crm.qa.cogmento.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class CompaniesPageTest extends BaseTestSuite{
	
	@Test(description = "Verify companies page is displayed and Enabled when concure is moved to Menu tab")
	public void tc_cogmento_companiespage_021() {

		ExtentReport.createTest("Verify companies page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify companies page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		Assert.assertEquals(true, companiesPage.companiesBtn.isDisplayed());
		Assert.assertEquals(companiesPage.companiesBtn.getAttribute("InnerText"),"Companies");
		ExtentLogger.pass("Verify companies page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	}

	@Test(description = "Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies")
	public void tc_cogmento_companiespage_022() {
		
		ExtentReport.createTest("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		Log.info("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		companiesPage.MenuNavigation("Companies");
		Assert.assertEquals(true, companiesPage.companiesTitle.isDisplayed());
		Assert.assertEquals(companiesPage.companiesTitle.getAttribute("InnerText"),"Contacts");
		ExtentLogger.pass("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		
	}
	
	@Test(description = "Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_companiespage_023() {
		
		ExtentReport.createTest("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		contactsPage.MenuNavigation("Contacts");
		Assert.assertEquals(true, companiesPage.dropdownBtn.isEnabled()||contactsPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(companiesPage.showFilterBtn.getAttribute("InnerText"),"Show Filters");
		Assert.assertEquals(companiesPage.exportBtn.getAttribute("InnerText"),"Export");
		Assert.assertEquals(companiesPage.createBtn.getAttribute("InnerText"),"Create");
		ExtentLogger.pass("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
			
	}
	@Test(description = "Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_companiespage_026() {
		
		ExtentReport.createTest("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		contactsPage.MenuNavigation("Contacts");
		Assert.assertEquals(true, contactsPage.dropdownBtn.isEnabled()||contactsPage.dropdownBtn.isDisplayed());
		contactsPage.dropdownBtn.click();
		Assert.assertEquals(true, contactsPage.defaultViewField.isDisplayed()||contactsPage.defaultViewField.isEnabled());
		ExtentLogger.pass("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
	}
	
	@Test(description = "Verify and Validate Export Feature in the companies page")
	public void tc_cogmento_companiespage_027() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the companies page");
		Log.info("Verify and Validate Export Feature in the companies page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		companiesPage.MenuNavigation("Companies");
		Assert.assertEquals(true, companiesPage.exportBtn.isDisplayed() && companiesPage.exportBtn.isEnabled());
		companiesPage.exportBtn.click();
		driver().switchTo().alert().accept();
		Assert.assertEquals(true, companiesPage.companiesTitle.isDisplayed() && companiesPage.companiesTitle.isEnabled());
		ExtentLogger.pass("Verify and Validate Export Feature in the companies page");
	}
	
	@Test(description = "Verify and Validate Create feature in the companies page and how many ways to create companies feature")
	public void tc_cogmento_companiespage_028() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the companies page and how many ways to create companies feature");
		Log.info("Verify and Validate Create feature in the companies page and how many ways to create companies feature");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		companiesPage.MenuNavigation("Companies");
		Assert.assertEquals(true, companiesPage.createBtn.isDisplayed() && companiesPage.createBtn.isEnabled());
		companiesPage.createBtn.click();
		Assert.assertEquals(true, companiesPage.createNewCompanyTitle.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the companies page and how many ways to create companies feature");
		
	}
	
	@Test(description = "Verify and Validate showFilter Feature in the companies page")
	public void tc_cogmento_companiespage_082() {
		
		ExtentReport.createTest("Verify and Validate showFilter Feature in the companies page");
		Log.info("Verify and Validate showFilter Feature in the companies page");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		companiesPage.MenuNavigation("Companies");
		Assert.assertEquals(true, companiesPage.showFilterBtn.isDisplayed()||companiesPage.showFilterBtn.isEnabled());
		companiesPage.showFilterBtn.click();
		Assert.assertEquals(true, companiesPage.hideFilterBtn.isDisplayed()||companiesPage.hideFilterBtn.isEnabled());
		Assert.assertEquals(true, companiesPage.addFilterRowFilterBtn.isDisplayed()||companiesPage.addFilterRowFilterBtn.isEnabled());
		contactsPage.addFilterRowFilterBtn.click();
		Assert.assertEquals(true, companiesPage.searchDropdownBtn.isDisplayed()&&companiesPage.searchDropdownBtn.isEnabled());
		ExtentLogger.pass("Verify and Validate showFilter Feature in the companies page");
	}
}
