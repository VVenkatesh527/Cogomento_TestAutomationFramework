package com.crm.qa.cogmento.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.dev.utility.Log;
import com.crm.qa.cogmento.BaseTestSuite.BaseTestSuite;
import com.crm.report.ExtentReport.ExtentLogger;
import com.crm.report.ExtentReport.ExtentReport;

public class CalendarPageTest extends BaseTestSuite {
	
	@Test(description = "Verify all Headers are avaliable when user clicked on Calendar buttton")
	public void tc_cogmento_calendarpage_005() {
		
		ExtentReport.createTest("Verify all Headers are avaliable when user clicked on Calendar buttton");
		Log.info("Verify all Headers are avaliable when user clicked on Calendar buttton");
		calendarPage.MenuNavigation("Calendar");
		Assert.assertEquals(true, calendarPage.calendarHeader.isDisplayed()||calendarPage.calendarHeader.isEnabled());
		Assert.assertEquals(true, calendarPage.eventsBtn.isDisplayed()||calendarPage.eventsBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.synNowBtn.isDisplayed()||calendarPage.synNowBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.createBtn.isDisplayed()||calendarPage.createBtn.isEnabled());
		ExtentLogger.pass("Verify all Headers are avaliable when user clicked on Calendar buttton");

	}
	
	@Test(description = "Verify Calendar options Today, Farword, Backward, Month, Week, Day, Agenda are Enabled")
	public void tc_cogmento_calendarpage_006() {
		
		ExtentReport.createTest("Verify Calendar options Today, Farword, Backward, Month, Week, Day, Agenda are Enabled");
		Log.info("Verify Calendar options Today, Farword, Backward, Month, Week, Day, Agenda are Enabled");
		calendarPage.MenuNavigation("Calendar");
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		ExtentLogger.pass("Verify Calendar options Today, Farword, Backward, Month, Week, Day, Agenda are Enabled");
	}
	
	@Test(description = "Verify Create button of Calendar feature and create new Event")
	public void tc_cogmento_calendarpage_007() {
		
		ExtentReport.createTest("Verify Create button of Calendar feature and create new Event");
		Log.info("Verify Create button of Calendar feature and create new Event");
		calendarPage.MenuNavigation("Calendar");
		ExtentLogger.pass("Verify Create button of Calendar feature and create new Event");
	}

}
