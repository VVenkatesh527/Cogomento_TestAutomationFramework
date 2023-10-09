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

import io.restassured.http.Header;

public class TasksPageTest extends BaseTestSuite{
	
	
	@Test(description = "Verify Tasks page is displayed and Enabled should be clickable when concure is moved to Menu tab")
	public void tc_cogmento_taskspage_045() {
		
		ExtentReport.createTest("Verify Tasks page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		Log.info("Verify Tasks page is displayed and Enabled should be clickable when concure is moved to Menu tab");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isEnabled());
		ExtentLogger.pass("Verify Tasks page is displayed and Enabled should be clickable when concure is moved to Menu tab");

	}
	
	@Test(description = "Verify Tasks page has navigated once Tasks feature Is clicked and Verify All header are visiable")
	public void tc_cogmento_taskspage_046() {
		
		ExtentReport.createTest("Verify Tasks page has navigated once Tasks feature Is clicked and Verify All header are visiable");
		Log.info("Verify Tasks page has navigated once Tasks feature Is clicked and Verify All header are visiable");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		
		Assert.assertEquals(true, tasksPage.dropdownBtn.isDisplayed());
		Assert.assertEquals(true, tasksPage.showFilterBtn.isDisplayed());
		Assert.assertEquals(true, tasksPage.exportBtn.isDisplayed());
		Assert.assertEquals(true, tasksPage.boardBtn.isDisplayed());
		Assert.assertEquals(true, tasksPage.createBtn.isDisplayed());
		ExtentLogger.pass("Verify Tasks page has navigated once Tasks feature Is clicked and Verify All header are visiable");

	}
	
	@Test(description = "Verify Tasks page has navigated verify Headers contains Dropdown, Board, Showfilter, Export, Create this all Headers should enabled and displayed")
	public void tc_cogmento_taskspage_047() {
		
		ExtentReport.createTest("Verify Tasks page has navigated verify Headers contains Dropdown, Board, Showfilter, Export, Create this all Headers should enabled and displayed");
		Log.info("Verify Tasks page has navigated verify Headers contains Dropdown, Board, Showfilter, Export, Create this all Headers should enabled and displayed");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		
		Assert.assertEquals(true, tasksPage.dropdownBtn.isEnabled());
		tasksPage.dropdownBtn.click();
		Assert.assertEquals(true, tasksPage.defaultViewField.isEnabled());
		tasksPage.defaultViewField.click();
		Assert.assertEquals(true, tasksPage.showFilterBtn.isEnabled());
		tasksPage.showFilterBtn.click();
		Assert.assertEquals(true, tasksPage.hideFilterBtn.isEnabled());
		tasksPage.hideFilterBtn.click();
		Assert.assertEquals(true, tasksPage.exportBtn.isEnabled());
		Assert.assertEquals(true, tasksPage.boardBtn.isEnabled());
		tasksPage.boardBtn.click();
		Assert.assertEquals(true, tasksPage.gridBtn.isEnabled());
		tasksPage.gridBtn.click();
		Assert.assertEquals(true, tasksPage.createBtn.isEnabled());
		ExtentLogger.pass("Verify Tasks page has navigated verify Headers contains Dropdown, Board, Showfilter, Export, Create this all Headers should enabled and displayed");

	}
	
	@Test(description = "Verify Tasks page had table and verify table headers and verify number of columns available")
	public void tc_cogmento_taskspage_048() {
		
		ExtentReport.createTest("Verify Tasks page had table and verify table headers and verify number of columns available");
		Log.info("Verify Tasks page had table and verify table headers and verify number of columns available");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isEnabled());
		List<String> headerList = new ArrayList<String>();
		headerList.add("Title");
		headerList.add("Type");
		headerList.add("Status");
		headerList.add("Company");
		List<String> TableHeaderList = basePage.getElementValue(tasksPage.tableHeadersLocator);
		Assert.assertEquals(headerList, TableHeaderList);
		ExtentLogger.pass("Verify Tasks page had table and verify table headers and verify number of columns available");

	}
	//Dig vijay filter method is required
	@Test(description = "Verify Tasks page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters")
	public void tc_cogmento_taskspage_049() {
		
		ExtentReport.createTest("Verify Tasks page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");
		Log.info("Verify Tasks page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.showFilterBtn.isEnabled());
		tasksPage.showFilterBtn.click();
		Assert.assertEquals(true, tasksPage.hideFilterBtn.isEnabled());
		Assert.assertEquals(true, tasksPage.addFilterRowFilterBtn.isDisplayed());
		
		ExtentLogger.pass("Verify Tasks page contains Showfilters feature on the header validate it by clicking on it and once clicked visiable text should change to Hidefilters");

	}
	
	@Test(description = "Verify and Validate Show filter Feature in the Tasks page")
	public void tc_cogmento_taskspage_050() {
		
		ExtentReport.createTest("Verify and Validate Show filter Feature in the Tasks page");
		Log.info("Verify and Validate Show filter Feature in the Tasks page");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.showFilterBtn.isEnabled());
		tasksPage.showFilterBtn.click();
		Assert.assertEquals(true, tasksPage.searchDropdownBtn.isEnabled());
		tasksPage.searchDropdownBtn.click();
		List<String> actualList =new ArrayList<>();
		actualList.add("Assigned To");
		actualList.add("Type");
		actualList.add("Due Date");
		actualList.add("Contact");
		actualList.add("Company");
		actualList.add("Deal");
		actualList.add("Case");
		actualList.add("Close Date");
		actualList.add("Tags");
		actualList.add("Description");
		actualList.add("Completion");
		actualList.add("Priority");
		actualList.add("Status");
		actualList.add("Identifier");
		actualList.add("Created at");
		List<String> expectedsearchList = homePage.convertWebElementToStringList(tasksPage.sreachShowFilterDropdown);
		Assert.assertEquals(actualList, expectedsearchList);
		ExtentLogger.pass("Verify and Validate Show filter Feature in the Tasks page");

	}
	
	
	@Test(description = "Verify and Validate Export Feature in the Tasks page")
	public void tc_cogmento_taskspage_051() {
		
		ExtentReport.createTest("Verify and Validate Export Feature in the Tasks page");
		Log.info("Verify and Validate Export Feature in the Tasks page");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.exportBtn.isEnabled());
		tasksPage.exportBtn.click();
		String actualpopmessage = tasksPage.popMessage.getAttribute("textContent");
		Assert.assertEquals(actualpopmessage, "Press OK to begin the export or Cancel to close this message.");
		tasksPage.okBtn.click();
		ExtentLogger.pass("Verify and Validate Export Feature in the Tasks page");

	}
	
	@Test(description = "Verify and Validate Create feature in the Tasks page and how many ways to Create New Tasks feature")
	public void tc_cogmento_taskspage_052() {
		
		ExtentReport.createTest("Verify and Validate Create feature in the Tasks page and how many ways to Create New Tasks feature");
		Log.info("Verify and Validate Create feature in the Tasks page and how many ways to Create New Tasks feature");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.createBtn.isDisplayed());
		tasksPage.createBtn.click();
		Assert.assertEquals(true, tasksPage.tasksCreateTitleLocator.isDisplayed());
		tasksPage.cancelBtn.click();
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		homePage.navigateToMenu(tasksPage.tasksPlusBtn);
		tasksPage.tasksPlusBtn.click();
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create feature in the Tasks page and how many ways to Create New Tasks feature");

	}
	
	@Test(description = "Verify and Validate ShowFilters feature in Tasks page if is displayed and enabled click ShowFilters button")
	public void tc_cogmento_taskspage_055() {
		
		ExtentReport.createTest("Verify and Validate ShowFilters feature in Tasks page if is displayed and enabled click ShowFilters button");
		Log.info("Verify and Validate ShowFilters feature in Tasks page if is displayed and enabled click ShowFilters button");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.showFilterBtn.isDisplayed());
		tasksPage.showFilterBtn.click();
		Assert.assertEquals(true, tasksPage.hideFilterBtn.isDisplayed());
		implicitWait(5);
		Assert.assertEquals(true, tasksPage.addFilterRowFilterBtn.isDisplayed());
		basePage.JSClick(tasksPage.addFilterRowFilterBtn);
		implicitWait(5);
		Assert.assertEquals(true, tasksPage.minusOfAddFilterBtn.isDisplayed());
		implicitWait(5);
		tasksPage.minusOfAddFilterBtn.click();
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		ExtentLogger.pass("Verify and Validate ShowFilters feature in Tasks page if is displayed and enabled click ShowFilters button");

	}
	
	
	@Test(description = "Verify and Validate Board feature in Tasks page Board feature is clickable")
	public void tc_cogmento_taskspage_056() {
		
		ExtentReport.createTest("Verify and Validate Board feature in Tasks page Board feature is clickable");
		Log.info("Verify and Validate Board feature in Tasks page Board feature is clickable");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		Assert.assertEquals(true, tasksPage.boardBtn.isDisplayed());
		tasksPage.boardBtn.click();
		List<String> actualList =new ArrayList<>();
		actualList.add("Unassigned");
		actualList.add("Enquiring");
		actualList.add("Reviewing");
		actualList.add("Awaiting input");
		List<String> expectedList = homePage.convertWebElementToStringList(tasksPage.optionsOfExportBtn);
		Assert.assertEquals(actualList, expectedList);
		ExtentLogger.pass("Verify and Validate Board feature in Tasks page Board feature is clickable");

	}
	
	@Test(description = "Verify Tasks page contains dropdown button click on it, it should contain default view in the dropdown and validate table  Header list")
	public void tc_cogmento_taskspage_057() {
		
		ExtentReport.createTest("Verify Tasks page contains dropdown button click on it, it should contain default view in the dropdown and validate table  Header list");
		Log.info("Verify Tasks page contains dropdown button click on it, it should contain default view in the dropdown and validate table  Header list");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		Assert.assertEquals(true, tasksPage.tasksTitleLocator.isDisplayed());
		List<String> tableActualHeadersList =new ArrayList<>();
		tableActualHeadersList.add("Title");
		tableActualHeadersList.add("Type");
		tableActualHeadersList.add("Status");
		tableActualHeadersList.add("Company");
		tableActualHeadersList.add("Options");
		List<String> tableHeaderlist = homePage.convertWebElementToStringList(tasksPage.tableHeadersLocator);
		Assert.assertEquals(tableActualHeadersList, tableHeaderlist);
		ExtentLogger.pass("Verify Tasks page contains dropdown button click on it, it should contain default view in the dropdown and validate table  Header list");

	}
	
	@Test(description = "Verify and Validate Create New Tasks form page fill the form with some mandatory field ")
	public void tc_cogmento_taskspage_053() {
		Map<Integer,HashMap<String,String>> expectedData = null;
		Map<Integer,HashMap<String,String>> actualData = null;
		ExtentReport.createTest("Verify and Validate Create New Tasks form page fill the form with some mandatory field ");
		Log.info("Verify and Validate Create New Tasks form page fill the form with some mandatory field ");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		tasksPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Title", basePage.getRandomTitle());
		formData.put("Type", basePage.selectRandomDropDownValue("type"));
		formData.put("Company",  basePage.getRandomCompanyName(tasksPage.companyDropdownList, tasksPage.companyDropDownLocator, "Company"));
		formData.put("Status", basePage.selectRandomDropDownValue("Status"));
		HashMap<String,String>taskMap = tasksPage.createTask(formData);
		tasksPage.createEventSaveBtn.click();
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		tableOperator.applyFiltersToColumns("Participants", "Equals",taskMap.get("Title"));
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
		
		expectedData.put(rowCount, taskMap);     
		Assert.assertEquals(actualData, expectedData);
		ExtentLogger.pass("Verify and Validate Create New Tasks form page fill the form with some mandatory field ");
	}
	
	@Test(description = "Verify and Validate Create New Task form page contains Status dropdown select value click on save button")
	public void tc_cogmento_taskspage_054() {
		
		ExtentReport.createTest("Verify and Validate Create New Task form page contains Status dropdown select value click on save button");
		Log.info("Verify and Validate Create New Task form page contains Status dropdown select value click on save button");
		homePage.MenuNavigation(tasksPage.TasksBtn,"Tasks");
		tasksPage.createBtn.click();
		HashMap<String,String> formData = new HashMap<String,String>();
		formData.put("Status", basePage.selectRandomDropDownValue("Status"));
		HashMap<String,String> taskMap = tasksPage.createTask(formData);
		tasksPage.createEventSaveBtn.click();
		Assert.assertEquals(true, tasksPage.mandatoryFieldErrorMessage.isDisplayed());
		ExtentLogger.pass("Verify and Validate Create New Task form page contains Status dropdown select value click on save button");
	}

}
