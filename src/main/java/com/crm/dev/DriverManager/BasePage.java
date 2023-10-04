package com.crm.dev.DriverManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.dev.utility.Log;
import com.crm.report.ExtentReport.ExtentLogger;

public class BasePage extends DriverManager {

	public void JSClick(WebElement element) {

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver();
		javascriptExecutor.executeScript("arguments[0].click()", element);

	}

	public void JSSendKeys(WebElement element, String str) {

		JavascriptExecutor jse = (JavascriptExecutor) driver();
		jse.executeScript("arguments[0].value=arguments[1] ", element, str);
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
		if (!element.getAttribute("InnerText").isBlank() || !element.getAttribute("InnerText").isEmpty()) {
			value = element.getAttribute("InnerText");
		} else if (!element.getAttribute("textContent").isBlank() || element.getAttribute("textContent").isEmpty()) {
			value = element.getAttribute("textContent");
		} else if (!element.getAttribute("text").isBlank() || element.getAttribute("text").isEmpty()) {
			value = element.getAttribute("text");
		} else if (!element.getAttribute("Value").isBlank() || element.getAttribute("Value").isEmpty()) {
			value = element.getAttribute("Value");
		} else {
			value = element.getText();
		}

		return value;
	}

	public List<String> getElementValue(List<WebElement> element) {

		List<String> listofvalue = new ArrayList<>();

		for (int i = 0; i < element.size(); i++) {
			listofvalue.add(element.get(i).getAttribute("textContent"));
		}
		return listofvalue;
	}

	public String getTimeStamp() {

		Date currentDate = new Date();
		String timeStamp = String.valueOf(currentDate.getTime());

		return timeStamp;
	}

	public void selectCalendarValue() {

	}

	public void navigateToLocator(WebElement locator) {

		try {
			if (locator.isDisplayed()) {
				locator.click();
			} else {
				ExtentLogger.fail("Unable to Navigate Locator");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String selectDropdownValue(WebElement element, String formElement, String value) {

		List<String> strList = new ArrayList<>();
		List<WebElement> listOfWebelements = driver()
				.findElements(By.xpath("//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)]"));

		navigateToLocator(element);

		try {
			if (!value.isBlank() && value.isEmpty()) {

				for (int i = 1; i < listOfWebelements.size(); i++) {

					List<WebElement> listOfWebelements1 = driver().findElements(By.xpath(
							"//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)][" + i + "]"));

					strList.add(listOfWebelements1.get(i).getAttribute("textContent"));

					if (strList.contains(value)) {

						listOfWebelements.get(i).click();
						implicitWait(6);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getRandomCompanyName(WebElement dropDownLocator) {

		String input = " ";
		List<String> strList = new ArrayList<>();
		List<WebElement> listOfDropdownElements = driver().findElements(
				By.xpath("//div//label[contains(text(),'Company')]//following-sibling::div//div[@role='option']"));
		Random random = new Random();

		dropDownLocator.click();
		JSSendKeys(dropDownLocator, "t");
		implicitWait(5);

		if (listOfDropdownElements.size() > 1) {

			for (int list = 0; list < listOfDropdownElements.size(); list++) {

				List<WebElement> listOfDropdownElements1 = driver().findElements(By
						.xpath("//div[contains(@name,' Company')]//span[contains(@class,text)]["+ list + "]"));

				strList.add(listOfDropdownElements1.get(list).getAttribute("textContent"));
			}

			int randomSize = random.nextInt(strList.size());
			input = strList.get(randomSize);
		}
		return input;
	}

	public String selectRandomDropDownValue(String formElement) {

		String input = " ";
		Random random = new Random();
		List<WebElement> listOfDropdownElements = driver()
				.findElements(By.xpath("//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)]"));
		List<String> strList = new ArrayList<>();

		for (int list = 0; list < listOfDropdownElements.size(); list++) {

			List<WebElement> listOfDropdownElements1 = driver().findElements(By
					.xpath("//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)][" + list + "]"));
			strList.add(listOfDropdownElements1.get(list).getAttribute("textContent"));
		}

		int randomSize = random.nextInt(strList.size());

		input = strList.get(randomSize);

		return input;
	}

	public String getRandomCompanyName(List<WebElement> listedElements, WebElement sendkeysElement,String formElement) {

		String input = " ";
		List<String> strList = new ArrayList<>();

		sendkeysElement.sendKeys("t");

		for (int list = 0; list < listedElements.size(); list++) {

			List<WebElement> listOfDropdownElements = driver().findElements(By
					.xpath("//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)][" + list + "]"));
			strList.add(listOfDropdownElements.get(list).getAttribute("textContent"));
		}
		Random random = new Random();

		int randomSize = random.nextInt(strList.size());

		input = strList.get(randomSize);

		return input;
	}

	public String selectCountryDropdownValue(WebElement element, String formElement, String value) {

		List<String> strList = new ArrayList<>();
		List<WebElement> listOfWebelements = driver()
				.findElements(By.xpath("//div[contains(@name,'" + formElement + "')]//span[contains(@class,text)]"));

		navigateToLocator(element);

		try {
			if (!value.isBlank() && value.isEmpty()) {

				for (int i = 1; i < listOfWebelements.size(); i++) {

					List<WebElement> listOfWebelements1 = driver().findElements(By.xpath("//div[contains(@name,'"
							+ formElement
							+ "')]//input[contains(@class,'search')]//following-sibling::div[contains(@role,'listbox')]//div[contains(@role,'option')]//span[contains(text(),'India')]["
							+ i + "]"));
					implicitWait(2);
					strList.add(listOfWebelements1.get(i).getAttribute("textContent"));

					if (strList.contains(value)) {

						JSClick(listOfWebelements1.get(i));
						implicitWait(6);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getRandomCountryName(WebElement dropDownElement, String formElement, String value) {

		String input = " ";
		Random random = new Random();
		List<String> strList = new ArrayList<>();

		List<WebElement> listOfWebelements = driver().findElements(By.xpath(
				"//div[contains(@name,'country')]//input[contains(@class,'search')]//following-sibling::div[contains(@role,'listbox')]//div[contains(@role,'option')]//span[contains(text(),'India')]"));
		WebElement enterCountryNameLocator = driver()
				.findElement(By.xpath("//div[contains(@name,'country')]//input[contains(@class,'search')]"));
		
		JSClick(dropDownElement);
		enterCountryNameLocator.sendKeys("India");

		for (int list = 0; list < listOfWebelements.size(); list++) {

			List<WebElement> listOfDropdownElements = driver().findElements(By.xpath("//div[contains(@name,'"
					+ formElement
					+ "')]//input[contains(@class,'search')]//following-sibling::div[contains(@role,'listbox')]//div[contains(@role,'option')]//span[contains(text(),'India')]["
					+ list + "]"));
			strList.add(listOfDropdownElements.get(list).getAttribute("textContent"));

			int randomSize = random.nextInt(strList.size());

			if (strList.contains(value)) {

				JSClick(listOfDropdownElements.get(list));
				implicitWait(6);
				input = strList.get(randomSize);
			}

		}

		return input;
	}
	
	/**
	 * 
	 * @param days : To increase the number of days, normally it will give current, if you pass days as 0 or any number , 
	 *                          it will add zero to the current Day.
	 * @return
	 */
	
	public String getDate(int days) {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Using today's date
		calendar.add(Calendar.DATE,days); // Adding 5 days
		String output = sdf.format(calendar.getTime());
		return output;
	}
	
	/**
	 *
	 * @param input
	 * @param day
	 * @return
	 */
	
	public String getCurrentOrFutureOrPastDate(String input,int day) {

		String date = " ";
		try {
			if (input.isBlank() || input == " " || input.equals(null)) {
				return input;
			}

			switch (input.trim()) {

			case "Future":
				date = getDate(day);
				break;
			case "Previous":
				date = getDate(day);
				break;
			case "Current":
				date = getDate(day);
				break;
			default:
				Log.info("Please Provide Valid Input Value ---> " + input);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;

	}
	/**
	 * 
	 * @param dateFormat : format should be "dd MMMM yyyy"
	 * @param input : Future or Previous or Current
	 * @param days : to add the like 0 or 1 or 2. for Previous pass only -1
	 * @return
	 */

	public String selectDateAndTime(String dateFormat,String input, int days) {

		String current_date = getCurrentOrFutureOrPastDate(input, days);
		WebElement datePicker = driver().findElement(By.xpath("//input[contains(@class,'-datepicker')]"));
		WebElement datePickerPopper = driver().findElement(By.xpath("//div[@class='react-datepicker-popper']"));
		try {
			if (datePicker.isDisplayed()) {
				datePicker.click();
				Log.info("Clicked On Calendar Field");
				if(datePickerPopper.isDisplayed()) {				
					WebElement selectDate = driver().findElement(By.xpath("//div[contains(@class,'datepicker__day')"
							+ " and contains(@aria-label,'"+current_date+"')]"));
					selectDate.click();
					Log.info("Clicking On " +current_date);
				}
				else
				{
					Log.info("Invalid Date ");
				}
			}
			else {
				Log.info("Invalid Date Format Is Passed ");
			}
		} catch (Exception e) {
			ExtentLogger.fail("Date Format is Invalid" +dateFormat);
			e.printStackTrace();
		}

		return current_date;
	}

}
