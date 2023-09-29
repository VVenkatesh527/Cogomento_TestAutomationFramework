package com.crm.report.ExtentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.dev.DriverManager.DriverManager;

public class ExtentReportNG extends DriverManager{

	
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		extent = new ExtentReports();
		String path = System.getProperty("user.dir")+"//Reports//AutomationExtentReport.html";
		ExtentSparkReporter reports = new ExtentSparkReporter(path);
		reports.config().setReportName("Automation Test Reports");
		reports.config().setDocumentTitle("Test Automation");
		extent.attachReporter(reports);
		return extent;
	}
}
