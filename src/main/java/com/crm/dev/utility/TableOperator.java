package com.crm.dev.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.dev.DriverManager.DriverManager;

public class TableOperator extends DriverManager{
	
	
		public void getTableData(WebElement tableXpath) {
			
			HashMap<String, HashMap<String, String>> outerMap = new HashMap<String,HashMap<String, String>>();	
			HashMap<String, String> innerMap = new HashMap<String, String>();	
	}
		
		
		public Map<String,String> getAllHeaders() {
			
			Map<String,String> data = new HashMap<String, String>();
			
			String headerXpath = "//table//thead//following-sibling::th";
			List<WebElement> headerList = driver().findElements(By.xpath(headerXpath));
		
			for(int i = 0 ; i < headerList.size() ; i++) {
				
				data.put(String.valueOf(i), headerList.get(i).getAttribute("innerText"));
				
			}
			return data;
		}
		
		public void getRowCount() {
			
		}
}
