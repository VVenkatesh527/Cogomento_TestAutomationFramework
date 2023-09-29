package com.crm.dev.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.report.ExtentReport.ExtentLogger;

public class TableOperator extends DriverManager {

	public void getTableData() {

		HashMap<Integer, HashMap<String, String>> outerMap = new HashMap<Integer, HashMap<String, String>>();
		HashMap<String, String> innerMap = new HashMap<String, String>();

		String common_table_xpath = "//table";
		String first_two_colums_xpath = "//following-sibling::td[not(contains(@class,'options-buttons'))]";
		String anchor_index_value_xpath = "//a";
		String second_index_value_xpath = "";
		String first_Column_xpath = "";

		List<String> headerList = getAllHeaders();
		int rowCount = getRowCount();
		System.out.println(rowCount); 
		for (int i = 1; i <= 2; i++) { // modify
			try {
				WebElement tableXpath = driver().findElement(By.xpath(common_table_xpath));
				if (tableXpath.isDisplayed()) {
					first_Column_xpath = common_table_xpath + "//tr["+i+"]" + first_two_colums_xpath
							+ anchor_index_value_xpath;
					System.out.println(first_Column_xpath);
					WebElement dataElement = driver().findElement(By.xpath(first_Column_xpath));
					// modify
					if (dataElement.isDisplayed()) {
						innerMap.put(headerList.get(i), dataElement.getAttribute("innerText"));
					}
				}
			} catch (Exception e) {
				ExtentLogger.fail("No Grid is Displayed");
				e.printStackTrace();
			}
			System.out.println(innerMap);

		}

	}

	public List<String> getAllHeaders() {

		List<String> headerList = new ArrayList<>();
		String headerXpath = "//table//thead//following-sibling::th[not(contains(text(),'Options'))]";
		List<WebElement> headerWebElementList = driver().findElements(By.xpath(headerXpath));
		for (WebElement headerElement : headerWebElementList) {
			headerList.add(headerElement.getAttribute("innerText"));
		}

		return headerList;
	}

	public int getRowCount() {

		int rowCount = 0;
		List<WebElement> gridRow = driver().findElements(By.xpath("//table//tbody//tr"));
		try {
			if (gridRow.size() >= 1) {
				rowCount = gridRow.size();
			} else
				ExtentLogger.fail("Please Provide Valid Xpath");
		} catch (Exception e) {
			ExtentLogger.fail("No Grid Is Displayed");
			e.printStackTrace();
		}

		return rowCount;
	}
	
	public void getTableDataForAnchorElements() {
		
		Map<Integer,HashMap<String,String>> data = new HashMap<Integer,HashMap<String,String>>();
		/**
		 * 1 . List of Headers
		 * 2.  Create InnerMap Data Using Above List Header
		 * 3. Add Row to the OuterMap Using InnerMap( 2nd Step)
		 */
		
		
	}
}