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

public class CalendarPageTest extends BaseTestSuite {
	
	@Test(description = "Verify all Headers are avaliable when user clicked on Calendar buttton")
	public void tc_cogmento_calendarpage_005() {
		
		ExtentReport.createTest("Verify all Headers are avaliable when user clicked on Calendar buttton");
		Log.info("Verify all Headers are avaliable when user clicked on Calendar buttton");
		homePage.MenuNavigation(calendarPage.calendarBtn,"Calendar");
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
		homePage.MenuNavigation(calendarPage.calendarBtn ,"Calendar");
		Assert.assertEquals(true, calendarPage.todayBtn.isDisplayed() ||calendarPage.todayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.leftArrowBtn.isDisplayed() ||calendarPage.leftArrowBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.righttArrowBtn.isDisplayed() ||calendarPage.righttArrowBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.monthBtn.isDisplayed() ||calendarPage.monthBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.weekBtn.isDisplayed() ||calendarPage.weekBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.dayBtn.isDisplayed() ||calendarPage.dayBtn.isEnabled());
		Assert.assertEquals(true, calendarPage.agendaBtn.isDisplayed() ||calendarPage.agendaBtn.isEnabled());
		ExtentLogger.pass("Verify Calendar options Today, Farword, Backward, Month, Week, Day, Agenda are Enabled");
	}
	
	@Test(description = "Verify Create button of Calendar feature and create new Event")
	public void tc_cogmento_calendarpage_007() {
		
		ExtentReport.createTest("Verify Create button of Calendar feature and create new Event");
		Log.info("Verify Create button of Calendar feature and create new Event");
		homePage.MenuNavigation(calendarPage.calendarBtn,"Calendar");
		calendarPage.createBtn.click();
		Map<String,String> formData = new HashMap<String,String>();
		formData = calendarPage.createFormData(formData);
		Assert.assertEquals(true ,calendarPage.createEventSaveBtn.isDisplayed());
		Assert.assertEquals(false, calendarPage.mandatoryFieldErrorMessage.isDisplayed());
		Assert.assertEquals(true ,calendarPage.createEventCancelBtn.isDisplayed());
		calendarPage.createEventCancelBtn.click();
		ExtentLogger.pass("Verify Create button of Calendar feature and create new Event");
	}
	
	@Test(description = "Verify Created calendar schedule is Clickable and created schedule is had Edit , Delete, Show Pending Alerts and Audit Buttons are Enbled")
	public void tc_cogmento_calendarpage_009() {
		
		ExtentReport.createTest("Verify Created calendar schedule is Clickable and created schedule is had Edit , Delete, Show Pending Alerts and Audit Buttons are Enbled");
		Log.info("Verify Created calendar schedule is Clickable and created schedule is had Edit , Delete, Show Pending Alerts and Audit Buttons are Enbled");
		homePage.MenuNavigation(calendarPage.calendarBtn,"Calendar");
		implicitWait(10);
		Assert.assertEquals(false, calendarPage.calendarEventBuntyBtn.isDisplayed());
		calendarPage.leftArrowBtn.click();
		calendarPage.calendarEventCookiesBtn.click();
		List<String> actualOptions = new ArrayList<>();
		actualOptions.add("All");
		actualOptions.add("Notes");
		actualOptions.add("Contacts");
		actualOptions.add("Events");
		actualOptions.add("Products");
		actualOptions.add("Tasks");
		actualOptions.add("Cases");
		actualOptions.add("Calls");
		actualOptions.add("Documents");
		List<String> expectedOptions = basePage.getElementValue(calendarPage.editOptionsForSchedule);
		Assert.assertEquals(actualOptions, expectedOptions);
		ExtentLogger.pass("Verify Created calendar schedule is Clickable and created schedule is had Edit , Delete, Show Pending Alerts and Audit Buttons are Enbled");
	}
}
