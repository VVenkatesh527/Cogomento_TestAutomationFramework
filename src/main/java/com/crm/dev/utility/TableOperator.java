package com.crm.dev.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.dev.DriverManager.DriverManager;
import com.crm.report.ExtentReport.ExtentLogger;

public class TableOperator extends DriverManager {

	public HashMap<Integer, HashMap<String, String>> getTableData() {

		HashMap<Integer, HashMap<String, String>> outerMap = new HashMap<Integer, HashMap<String, String>>();

		int rowCount = getRowCount();
		Map<Integer, String> headerMap = getAllHeaders();
		if (rowCount > 0) {
			for (int row = 1; row < rowCount; row++) {
				HashMap<String, String> innerMap = new HashMap<String, String>();
				String tableXpath = " ";
				WebElement tableElement = null;
				int counter = 1;
				for (Integer key : headerMap.keySet()) {
					tableXpath = " ";
					tableXpath = "//table//tbody//tr[" + row	+ "]//td[not(div[@class='ui fitted read-only checkbox']) and not(contains(@class,'options-buttons'))]["
							+ counter + "]";
					tableElement = driver().findElement(By.xpath(tableXpath));
					if (tableElement.isDisplayed()) {
						innerMap.put(headerMap.get(key), tableElement.getAttribute("innerText"));
						counter++;
					}
				}
				outerMap.put(row, innerMap);

			}
		} else {
			Log.info("No Data is Displayed in Grid");
			ExtentLogger.fail("No Data is Displayed in Grid");
		}
		
		return outerMap;
	}

	public HashMap<Integer, String> getAllHeaders() {

		int count = 1;
		HashMap<Integer, String> headerMap = new HashMap<Integer, String>();
		String headerXpath = "//table//thead//following-sibling::th[not(contains(text(),'Options'))]";
		List<WebElement> headerWebElementList = driver().findElements(By.xpath(headerXpath));
		for (WebElement element : headerWebElementList) {
			headerMap.put(count, element.getAttribute("innerText"));
			count++;
		}

		return headerMap;
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
			ExtentLogger.fail("No Data Is Displayed in Grid");
			e.printStackTrace();
		}

		return rowCount;
	}

	public void getTableDataForAnchorElements() {

		//Map<Integer, HashMap<String, String>> data = new HashMap<Integer, HashMap<String, String>>();
		/**
		 * 1 . List of Headers 2. Create InnerMap Data Using Above List Header 3. Add
		 * Row to the OuterMap Using InnerMap( 2nd Step)
		 */

	}

	/**
	 * 
	 * @param searchValue   : user should pass any value from search dropdown
	 * @param operatorValue : user should pass any value from operator dropdown
	 * @param searchText    : pass the exact value to filter from grid
	 */

	public void applyFiltersToColumns(String searchValue, String operatorValue, String searchText) {

		//WebElement norecordsElement = driver().findElement(By.xpath("//p[normalize-space()='No records found']"));
		WebElement showFilterBtn = driver().findElement(
				By.xpath("//button[contains(@class,'linkedin button') and normalize-space()='Show Filters']"));

		String searchXpath = "//div[@name='name']";
		String operatorXpath = "//div[@name='operator']";
		String valueXpath = "//div[@class='ui input']//input[@name='value']";
		String arrowBtn = "//i";
		String dropDownValueLocator = "//div[contains(@class,'menu transition')]//span";
		List<WebElement> webElements = null;
		WebElement searchArrowLoctor = null;
		WebElement operatorArrowLoctor = null;
		WebElement valueLocator = null;
		WebElement locatorValue = null;
		int rowCount = getRowCount();
		try {
			if (rowCount > 1) {
				if (showFilterBtn.isDisplayed()) {
					showFilterBtn.click();
					Log.info("Clicked on " + showFilterBtn.getAttribute("innerText") + " Button ");
					ExtentLogger.info("Clicked on " + showFilterBtn.getAttribute("innerText") + " Button ");
				} else {
					ExtentLogger.fail(showFilterBtn.getAttribute("innerText") + " Is Not Displayed");
				}
				try {
					webElements = driver().findElements(By.xpath("//div[@role='combobox' or @role='listbox']"));
					while(webElements.size()>1) {
						if (!searchValue.isEmpty()) {
							dropDownValueLocator = " ";
							dropDownValueLocator = "//div[contains(@class,'menu transition')]//span";
							searchArrowLoctor = basePage.getWebElement(searchXpath + arrowBtn);
							searchArrowLoctor.click();
							dropDownValueLocator = dropDownValueLocator
									+ "[normalize-space()='<REPLACE>']".replace("<REPLACE>", searchValue);
							 locatorValue = basePage.getWebElement(dropDownValueLocator);
							visibilityOfElement(locatorValue, 5);
							locatorValue.click();
						}
						if (!operatorValue.isEmpty()) {
							dropDownValueLocator = " ";
							dropDownValueLocator = "//div[contains(@class,'menu transition')]//span";
							operatorArrowLoctor = basePage.getWebElement(operatorXpath + arrowBtn);
							operatorArrowLoctor.click();
							webElements = driver().findElements(By.xpath(dropDownValueLocator));
							dropDownValueLocator = dropDownValueLocator
									+ "[normalize-space()='<REPLACE>']".replace("<REPLACE>", operatorValue);
							 locatorValue = basePage.getWebElement(dropDownValueLocator);
							visibilityOfElement(locatorValue, 5);
							locatorValue.click();
					}
						break;
					}
				} catch (Exception e) {
					Log.info("Unable to Select Value For  Search or Operator Filter");
					ExtentLogger.fail("Unable to Select Value For  Search or Operator Filter");
				}

				valueLocator = basePage.getWebElement(valueXpath);
				visibilityOfElement(valueLocator, 5);
				valueLocator.sendKeys(searchText);
				WebElement searchFilterBtn = basePage.getWebElement("//i[@class='search small icon']");
				visibilityOfElement(searchFilterBtn, 5);
				searchFilterBtn.click();
				implicitWait(10);
			} else {
				WebElement norecordsElement = driver().findElement(By.xpath("//p[normalize-space()='No records found']"));
				Log.info("No Data is Displayed in Grid " + norecordsElement.getAttribute("innerText"));
				ExtentLogger.fail("No Data is Displayed in Grid " + norecordsElement.getAttribute("innerText"));
			}
		} catch (Exception e) {
			Log.info(showFilterBtn.getAttribute("innerText") + " Is Not Displayed");
			ExtentLogger.fail(showFilterBtn.getAttribute("innerText") + " Is Not Displayed");
			e.printStackTrace();
		}

	}
}