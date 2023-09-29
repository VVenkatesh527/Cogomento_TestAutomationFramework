package com.crm.report.ExtentReport;

import com.aventstack.extentreports.ExtentTest;
import com.crm.dev.DriverManager.DriverManager;

public class ExtentManager extends DriverManager {

	
	private ExtentManager() {
		
	}
	
	protected static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

	
	public static ExtentTest getExtentTest() {
		return exTest.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}
}
