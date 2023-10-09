package com.crm.qa.cogmento.testcases;

import java.util.HashMap;
import java.util.Map;

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
		Assert.assertEquals(companiesPage.companiesBtn.getAttribute("textContent"),"Companies");
		ExtentLogger.pass("Verify companies page is displayed and Enabled should be clickable when concure is moved to Menu tab");
	}

	@Test(description = "Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies")
	public void tc_cogmento_companiespage_022() {
		
		ExtentReport.createTest("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		Log.info("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		Assert.assertEquals(true, companiesPage.companiesTitle.isDisplayed());
		Assert.assertEquals(companiesPage.companiesTitle.getAttribute("textContent")," Companies");
		ExtentLogger.pass("Verify Companies page has navigated once Companies feature Is clicked Validate Companies page Title should be Companies");
		
	}
	
	@Test(description = "Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_companiespage_023() {
		
		ExtentReport.createTest("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		Assert.assertEquals(true, companiesPage.dropdownBtn.isEnabled()||contactsPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(companiesPage.showFilterBtn.getAttribute("textContent"),"Show Filters");
		Assert.assertEquals(companiesPage.exportBtn.getAttribute("textContent"),"Export");
		Assert.assertEquals(companiesPage.createBtn.getAttribute("textContent"),"Create");
		ExtentLogger.pass("Verify companies page has navigated verify Headers contains dropdown,showfilter, Export, Create this all Headers should enabled and displayed");
			
	}
	
	@Test(description = "Verify companies page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters")
	public void tc_cogmento_companiespage_025() {
		
		ExtentReport.createTest("Verify companies page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");
		Log.info("Verify companies page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		Assert.assertEquals(true, companiesPage.showFilterBtn.isDisplayed());
		companiesPage.showFilterBtn.click();
		Assert.assertEquals(true, companiesPage.hideFilterBtn.isDisplayed());
		Assert.assertEquals(true, companiesPage.addFilterRowFilterBtn.isDisplayed());
		implicitWait(5);
		companiesPage.addFilterRowFilterBtn.click();
		implicitWait(5);
		Assert.assertEquals(true, companiesPage.minusOfAddFilterBtn.isDisplayed());
		companiesPage.minusOfAddFilterBtn.click();
		ExtentLogger.pass("Verify companies page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");
			
	}
	
	@Test(description = "Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown")
	public void tc_cogmento_companiespage_026() {
		
		ExtentReport.createTest("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Log.info("Verify contacts page contains dropdown button click on it, it should contain default view in the dropdown");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
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
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		Assert.assertEquals(true, companiesPage.exportBtn.isDisplayed() && companiesPage.exportBtn.isEnabled());
		companiesPage.exportBtn.click();
		Assert.assertEquals(true,companiesPage.okBtn.isDisplayed());
		companiesPage.cancelBtn.click();
		Assert.assertEquals(true, companiesPage.companiesTitle.isDisplayed() && companiesPage.companiesTitle.isEnabled());
		ExtentLogger.pass("Verify and Validate Export Feature in the companies page");
	}
	
	@Test(description = "Verify and Validate Create feature in the companies page and how many ways to create companies feature")
	public void tc_cogmento_companiespage_028() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the companies page and how many ways to create companies feature");
		Log.info("Verify and Validate Create feature in the companies page and how many ways to create companies feature");
		Assert.assertEquals(driver().getTitle(), "Cogmento CRM");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
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
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		Assert.assertEquals(true, companiesPage.showFilterBtn.isDisplayed()||companiesPage.showFilterBtn.isEnabled());
		companiesPage.showFilterBtn.click();
		Assert.assertEquals(true, companiesPage.hideFilterBtn.isDisplayed()||companiesPage.hideFilterBtn.isEnabled());
		Assert.assertEquals(true, companiesPage.addFilterRowFilterBtn.isDisplayed()||companiesPage.addFilterRowFilterBtn.isEnabled());
		contactsPage.addFilterRowFilterBtn.click();
		Assert.assertEquals(true, companiesPage.searchDropdownBtn.isDisplayed()&&companiesPage.searchDropdownBtn.isEnabled());
		ExtentLogger.pass("Verify and Validate showFilter Feature in the companies page");
	}
	
	@Test(description = "Verify Create button of Companies feature and create new Event",enabled = false)
	public void tc_cogmento_companiespage_088() {
		
		ExtentReport.createTest("Verify Create button of Companies feature and create new Event");
		Log.info("Verify Create button of Companies feature and create new Event");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		companiesPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Name","random");
		formData.put("Street","random");
		formData.put("City","Ahemadabad");
		formData.put("State","Gujarat");
		formData.put("PostCode","random");
		formData.put("Country","India");
		HashMap<String,String> companyMap = companiesPage.createCompany(formData);
		Assert.assertEquals(true, companiesPage.createEventSaveBtn.isDisplayed(),"Save button is displayed");
		Assert.assertEquals(false,companiesPage.mandatoryFieldErrorMessage.isDisplayed(),"ErrorMessage button is displayed");
		 companiesPage.createEventSaveBtn.click();
		 
		 
		Assert.assertEquals(true,companiesPage.createEventCancelBtn.isDisplayed(),"Cancel button is displayed");
		ExtentLogger.pass("Verify Create button of Companies feature and create new Event");
	}
	
	
	@Test(description = "Verify Create button of Companies feature and create new Event and Validate form data with saved company data")
	public void tc_cogmento_companiespage_024() {
		
		Map<Integer,HashMap<String,String>> expectedData = null;
		Map<Integer,HashMap<String,String>> actualData = null;
		ExtentReport.createTest("Verify Create button of Companies feature and create new Event and Validate form data with saved company data");
		Log.info("Verify Create button of Companies feature and create new Event and Validate form data with saved company data");
		homePage.MenuNavigation(companiesPage.companiesBtn,"Companies");
		companiesPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Name","random");
		formData.put("Street","random");
		formData.put("City","Ahemadabad");
		formData.put("State","Gujarat");
		formData.put("PostCode","random");
		formData.put("Country","India");
		HashMap<String,String> companyMap = companiesPage.createCompany(formData);
		Assert.assertEquals(true, companiesPage.createEventSaveBtn.isDisplayed(),"Save button is displayed");
		 companiesPage.createEventSaveBtn.click();
		 homePage.MenuNavigation(companiesPage.companiesBtn, "Companies");
			tableOperator.applyFiltersToColumns("Name", "Equals",companyMap.get("Name"));
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
			expectedData.put(rowCount, companyMap);      
			Assert.assertEquals(actualData, expectedData);
		ExtentLogger.pass("Verify Create button of Companies feature and create new Event and Validate form data with saved company data");
	}
	
	
}
