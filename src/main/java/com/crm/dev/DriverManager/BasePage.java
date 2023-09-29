package com.crm.dev.DriverManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage extends DriverManager{
	
	
	
	public void JSClick(WebElement element) {
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver();
		javascriptExecutor.executeScript("arguments[0].click()",element);
	}
	
	public static void sleep(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementValue(WebElement element) { // WebElement
		
		String value = "";
		if(!element.getAttribute("InnerText").isBlank()||!element.getAttribute("InnerText").isEmpty()) {
			value = element.getAttribute("InnerText");
		}
		else if(!element.getAttribute("textContent").isBlank()||element.getAttribute("textContent").isEmpty()) {
			value = element.getAttribute("textContent");
		}
		else if(!element.getAttribute("text").isBlank()||element.getAttribute("text").isEmpty()) {
			value = element.getAttribute("text");
		}
		else if(!element.getAttribute("Value").isBlank() ||element.getAttribute("Value").isEmpty()) {
			value = element.getAttribute("Value");
		}
		else {
			value = element.getText();
		}
		
		return value;
	}
	
	public List<String> getElementValue(List<WebElement> element) {
		
	List<String> listofvalue = new ArrayList<>();
	
	for(int i = 0 ; i< element.size() ; i++) {
		listofvalue.add(element.get(i).getAttribute("textContent"));	
	}
		return listofvalue;
	}
}

