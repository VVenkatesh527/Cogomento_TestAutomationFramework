package com.crm.report.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.dev.DriverManager.DriverManager;
import com.crm.dev.utility.Log;


public class ExtentReport extends DriverManager{

	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static String reportPath = System.getProperty("user.dir")+"//Reports//AutomationExtentReport.html";

	
	private ExtentReport() {
		
	}
	
	
	
	public static void initReports() {
		
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Cogmento Test Automation FrameWork Report");
		spark.config().setDocumentTitle("Cogmento Test Automation Execution Report");
		extent.attachReporter(spark);
	}
	
	
	public static void tearDownReports() {
		
		extent.flush();
		Log.info("Extent Report is generated at " +reportPath);
	}
	
	public static void createTest(String testcasename) {
		
		test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
}
