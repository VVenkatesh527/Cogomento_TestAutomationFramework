package com.crm.dev.DriverManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
			if (!value.isBlank()) {

				for (WebElement elements : listOfWebelements) {

					strList.add(elements.getAttribute("textContent"));

					if (strList.contains(value)) {

						elements.click();
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
		List<WebElement> listOfDropdownElements = driver().findElements(By.xpath("//div//label[contains(text(),'Company')]//following-sibling::div//div[@role='option']"));
		Random random = new Random();
		dropDownLocator.click();
		JSSendKeys(dropDownLocator, "t");
		implicitWait(5);

		if (listOfDropdownElements.size() > 1) {
			for (int list = 0; list < listOfDropdownElements.size(); list++) {

				List<WebElement> listOfDropdownElements1 = driver().findElements(
						By.xpath("//div[contains(@name,' Company')]//span[contains(@class,text)][" + list + "]"));

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
				.findElements(By.xpath("//div[contains(@name,'"+formElement+"')]//div[contains(@name,'"+formElement+"')]"));
		List<String> strList = new ArrayList<>();
		int randomSize = random.nextInt(listOfDropdownElements.size());

		for(WebElement list : listOfDropdownElements) {
			strList.add(list.getAttribute("textContent"));
		}
//		for (int list = 0; list < listOfDropdownElements.size(); list++) {
//			List<WebElement> listOfDropdownElements1 = driver().findElements(By.xpath("//div[contains(@name,'" + formElement + "')]//div[contains(@name,'"+formElement+"')][" + list + "]"));
//			strList.add(listOfDropdownElements1.get(list).getAttribute("textContent"));	}
		input = strList.get(randomSize);
		if(listOfDropdownElements.get(randomSize).getAttribute("textContent")==input) {
			listOfDropdownElements.get(randomSize).click();
		}

		return input;
	}

	public String getRandomCompanyName(List<WebElement> listedElements, WebElement sendkeysElement,String formElement) {

		String input = " ";
		Random random = new Random();
		List<String> strList = new ArrayList<>();
		sendkeysElement.click();
		sendkeysElement.sendKeys("t");

		for (int list = 0; list < listedElements.size(); list++) {
			List<WebElement> listOfDropdownElements = driver().findElements(By
					.xpath("//div[contains(@name,'" + formElement + "')]//div[contains(@name,'"+formElement+"')][" + list + "]"));
			strList.add(listOfDropdownElements.get(list).getAttribute("textContent"));
		}
		int randomSize = random.nextInt(strList.size());

		input = strList.get(randomSize);

		return input;
	}
	
	public String getRandomDeal(WebElement sendkeysElement,String formElement) {

		String input = " ";
		Random random = new Random();
		List<String> strList = new ArrayList<>();
		sendkeysElement.click();
		sendkeysElement.sendKeys("t");
		List<WebElement> listOfDropdownElements = driver().findElements(By.xpath("//div[contains(@name,'"+formElement+"')]//div[contains(@name,'"+formElement+"')]"));
		int randomSize = random.nextInt(listOfDropdownElements.size());

		for(WebElement list : listOfDropdownElements) {
			
			strList.add(list.getAttribute("textContent"));
		}
		input = strList.get(randomSize);
		if(listOfDropdownElements.get(randomSize).getAttribute("textContent")==input) {
			listOfDropdownElements.get(randomSize).click();
		}
		return input;
	}

	public String selectCountryDropdownValue(WebElement element, String formElement, String value) {

		List<String> strList = new ArrayList<>();
		List<WebElement> listOfWebelements = driver()
				.findElements(By.xpath("//div[contains(@name,'" + formElement + "')]//div[contains(@name,'"+formElement+"')]"));

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

	public String getDate(int days) {

		SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // Using today's date
		calendar.add(Calendar.DATE, days); // Adding 5 days
		String output = sdf.format(calendar.getTime());
		return output;
	}

	public String selectDateAndTime(int days, String time) {

		String dateXpath = " ", date = " ";
		WebElement dateElement = null;
		WebElement datePicker = getWebElement("//div[contains(@class,'datepicker__input')]//input");
		date = getDate(days);
		try {
			if (datePicker.isDisplayed()) {
				visibilityOfElement(datePicker, 10);
				datePicker.click();
				WebElement dateMonthPicker = getWebElement("//div[contains(@class,'datepicker__month')]");
				try {
					visibilityOfElement(dateMonthPicker, 10);
					if (dateMonthPicker.isDisplayed()) {
						//WebElement previousArrowBtn = basePage.getWebElement("//button//span[contains(@class,'navigation-icon--previous')]");
						//WebElement nextArrowBtn = basePage.getWebElement("//button//span[contains(@class,'navigation-icon--next')]");
						switch (time) {
						case "Future":
							do {
								dateXpath = " ";
								dateXpath = "//div[contains(@class,'datepicker__month')]//following::div[contains(@class,'datepicker__day') and contains(@aria-label,'<REPLACE>')]"
										.replace("<REPLACE>", date);
								dateElement = getWebElement(dateXpath);
							} while (!getWebElement(dateXpath).isDisplayed());
								if (dateElement.isDisplayed()) {
									visibilityOfElement(dateElement, 5);
									dateElement.click();
								} else {
									ExtentLogger.fail("Entered" + date + " Is Invalid");

								}
							
							break;
						case "Past":
							WebElement pastDateElement = getWebElement(dateXpath);
							if (pastDateElement.isDisplayed()) {
								visibilityOfElement(pastDateElement, 5);
								pastDateElement.click();
							} else {
								ExtentLogger.fail("Entered" + date + " Is Invalid");
							}
							break;
						case "Current":
							WebElement currentDateElement = getWebElement(dateXpath);
							if (currentDateElement.isDisplayed()) {
								visibilityOfElement(currentDateElement, 5);
								currentDateElement.click();
							} else {
								ExtentLogger.fail("Entered" + date + " Is Invalid");
							}
							break;
						default:
							Log.info("Invalid Time is Passed " + time);
							ExtentLogger.fail("Invalid Time is Passed " + time);
							break;
						}

					}
				} catch (Exception e) {
					Log.info("Unable To Select Date, Month Calendar is Not Displayed");
					ExtentLogger.fail("Unable To Select Date, Month Calendar is Not Displayed");
				}
			}
		} catch (

		Exception e) {
			Log.info("Unable To Click On Calendar Form ");
			ExtentLogger.fail("Unable To Click On Calendar Form ßß");
			e.printStackTrace();
		}
		return date;
	}

	public WebElement getWebElement(String string) {

		WebElement element = driver().findElement(By.xpath(string));
		return element;
	}

	public String getRandomTitle() {

		List<String> titleList = Arrays.asList("Mr.", "Mrs.", "Dr.", "Miss."); 
		Random random = new Random();
		int n = random.nextInt(titleList.size() - 1);
		return titleList.get(n).toString();
	}

}
