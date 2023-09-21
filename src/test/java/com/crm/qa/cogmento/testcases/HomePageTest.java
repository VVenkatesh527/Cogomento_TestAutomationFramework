package com.crm.qa.cogmento.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.PageObjects.HomePage;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;

public class HomePageTest extends BaseTestSuite {

	
	@Test
	public void tc_cogmento_homepage_002() {
		
		HomePage homePage = new  HomePage(driver());
		Assert.assertEquals(true, homePage.testAutomationHeader.isDisplayed());
		Assert.assertEquals(true, homePage.searchBtn.isDisplayed());
		Assert.assertEquals(true, homePage.pinIcon.isDisplayed());
		Assert.assertEquals(true, homePage.trashBtn.isDisplayed());
		Assert.assertEquals(true, homePage.settingsIcon.isDisplayed());

	}
}
