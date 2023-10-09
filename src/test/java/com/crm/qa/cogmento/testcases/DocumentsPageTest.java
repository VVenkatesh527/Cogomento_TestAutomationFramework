package com.crm.qa.cogmento.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class DocumentsPageTest extends BaseTestSuite{
	
	@Test(description = "Verify and Validate Documents feature in Menu Tab")
	public void tc_cogmento_documentspage_078() {
		
		ExtentReport.createTest("Verify and Validate Documents feature in Menu Tab");
		Log.info("Verify and Validate Documents feature in Menu Tab");
		homePage.navigateToMenu(documentsPage.documentsBtn);
		Assert.assertEquals(true, documentsPage.documentsBtn.isDisplayed());
		documentsPage.documentsBtn.click();
		Assert.assertEquals(true, documentsPage.documentsTitleBtn.isDisplayed());
		ExtentLogger.pass("Verify and Validate Documents feature in Menu Tab");
	}
	
	@Test(description = "Verify and Validate New Folder button in Documents feature")
	public void tc_cogmento_documentspage_079() {
		
		ExtentReport.createTest("Verify and Validate New Folder button in Documents feature");
		Log.info("Verify and Validate New Folder button in Documents feature");
		homePage.MenuNavigation(documentsPage.documentsBtn,"Documents");
		Assert.assertEquals(true, documentsPage.documentsTitleBtn.isDisplayed());
		Assert.assertEquals(true, documentsPage.newFolderBtn.isDisplayed());
		documentsPage.newFolderBtn.click();
		Assert.assertEquals(true, documentsPage.folderNameLocator.isDisplayed());
		documentsPage.folderNameLocator.sendKeys(RandomStringUtils.randomAlphabetic(6));
		Assert.assertEquals(true, documentsPage.saveBtn.isDisplayed());
		documentsPage.cancelBtn.click();
		ExtentLogger.pass("Verify and Validate New Folder button in Documents feature");
	}
	
	@Test(description = "Verify and Validate Create button in Documents feature")
	public void tc_cogmento_documentspage_080() {
		
		ExtentReport.createTest("Verify and Validate Create button in Documents feature");
		Log.info("Verify and Validate Create button in Documents feature");
		homePage.MenuNavigation(documentsPage.documentsBtn,"Documents");
		Assert.assertEquals(true, documentsPage.documentsTitleBtn.isDisplayed());
		Assert.assertEquals(true, documentsPage.createBtn.isDisplayed());
		documentsPage.createBtn.click();
		Assert.assertEquals(true, documentsPage.documentsTitleBtn.isDisplayed());
		Assert.assertEquals(true, documentsPage.createSaveBtn.isDisplayed());
		documentsPage.cancelBtn.click();
		ExtentLogger.pass("Verify and Validate Create button in Documents feature");
	}
}
