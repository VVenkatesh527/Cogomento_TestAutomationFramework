package com.crm.report.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.crm.dev.DriverManager.DriverManager;

public class ExtentLogger extends  DriverManager {

	private ExtentLogger() {

	}

	public static void pass(String message) {

		ExtentManager.getExtentTest().pass(message);
		Assert.assertTrue(true, message);
	}

	
	public static void fail(String message) {

		ExtentManager.getExtentTest().fail(message);
		Assert.assertTrue(false, message);
	}

	public static void skip(String message) {

		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {

		ExtentManager.getExtentTest().info(message);
	}
	
	public static void logStackTraceInfoInExtentReport(String message) {
		String formattedText = "<pre>"+message.replace(",", "<br>")+"</pre>";
		ExtentManager.getExtentTest().fail(formattedText);
	}
	
	public static void logRequestAndResponseInReport(String request,String response) {
		
		logPrettyRequestToReport(request);
		logPrettyResonseToReport(response);
	}
	
	public static void logPrettyResonseToReport(String response) {
		
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(response,CodeLanguage.JSON));
	}
	
	public static void logPrettyRequestToReport(String request) {
		ExtentManager.getExtentTest().info("<pre>"+request.replace("\n", "<br>")+"</pre>");
	}
	
	public static  String captureScreenshot() {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//Screenshots//"+dateName+".png";
		File filePath = new File(destination);
		try {
			FileUtils.copyFile(screenshot, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Media screenshot_obj = MediaEntityBuilder.createScreenCaptureFromPath(filePath.getAbsolutePath()).build();
	    ExtentManager.getExtentTest().log(Status.INFO, screenshot_obj);
		return destination;
	}
	
}
