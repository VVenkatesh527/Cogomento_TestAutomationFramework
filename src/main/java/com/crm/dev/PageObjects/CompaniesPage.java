package com.crm.dev.PageObjects;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.dev.DriverManager.DriverManager;

public class CompaniesPage extends DriverManager {

	@FindBy(xpath = "//span[contains(text(),'Companies') and @class='item-text']")
	public WebElement companiesBtn;

	@FindBy(xpath = "//span[normalize-space()='Companies' and contains(@class,'select')]")
	public WebElement companiesTitle;

	@FindBy(xpath = "//i[contains(@class,'dropdown')]//parent::div[@name='view']")
	public WebElement dropdownBtn;

	@FindBy(xpath = "//span[normalize-space()='Default View' and contains(@class,'text')]")
	public WebElement defaultViewField;

	@FindBy(xpath = "//button[normalize-space()='Show Filters']")
	public WebElement showFilterBtn;

	@FindBy(xpath = "//button[normalize-space()='Hide Filters']")
	public WebElement hideFilterBtn;

	@FindBy(xpath = "//button[normalize-space()='Add Filter Row']")
	public WebElement addFilterRowFilterBtn;

	@FindBy(xpath = "//div[contains(text(),'Search')]")
	public WebElement searchDropdownBtn;

	@FindBy(xpath = "//button[normalize-space()='Export']")
	public WebElement exportBtn;

	@FindBy(xpath = "//a//button[contains(text(),'Create')]")
	public WebElement createBtn;

	@FindBy(xpath = "//span[normalize-space()='Create New Company' and contains(@class,'select')]")
	public WebElement createNewCompanyTitle;

	// formData
	@FindBy(xpath = "//div//input[contains(@name,'name') and contains(@autocomplete,'new-password')]")
	public WebElement createEventTitleLocator;
	
	@FindBy(xpath = "//div//input[contains(@name,'address') and contains(@type,'text')]")
	public WebElement streetAddressLocator;

	@FindBy(xpath = "//div//input[contains(@name,'city') and contains(@type,'text')]")
	public WebElement cityAddressLocator;

	@FindBy(xpath = "//div//input[contains(@name,'state') and contains(@type,'text')]")
	public WebElement stateAddressLocator;

	@FindBy(xpath = "//div//input[contains(@name,'zip') and contains(@type,'text')]")
	public WebElement postCodeAddressLocator;

	@FindBy(xpath = "//div[contains(@name,'country')]//input[contains(@class,'search')]//following-sibling::div[contains(@role,'listbox')]//div[contains(@role,'option')]//span[text()='India']")
	public WebElement selectedCountryLocator;

	@FindBy(xpath = "//div[contains(@name,'country')]//i[contains(@class,'dropdown icon')]")
	public WebElement dropDownCountryLocatorBtn;

	@FindBy(xpath = "//div[contains(@name,'country')]//input[contains(@class,'search')]")
	public WebElement enterTextCountryName;

	@FindBy(xpath = "//span[contains(text(),'Required')]")
	public WebElement mandatoryFieldErrorMessage;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]//i[contains(@class,'save')]")
	public WebElement createEventCancelBtn;

	@FindBy(xpath = "//button[contains(text(),'Save')]//i[contains(@class,'save')]")
	public WebElement createEventSaveBtn;

	@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']")
	public WebElement categoryDropDownLocator;

	@FindBy(xpath = "//div//label[contains(text(),'Category')]//following::div[@name='category']//i[contains(@class,'dropdown')]")
	public WebElement categoryDownArrowBtn;

	public CompaniesPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public Map<String, String> createFormData(Map<String, String> formData) {

		Map<String, String> createdData = new HashMap<>();
		String name_value = "", category_value = " ", streetAddress_value = "", cityAddress_value = "",stateAddress_value = "", postCode_value = "", selectCountry_value = "";
		try {
			name_value = formData.get("Name");
			if(name_value.equalsIgnoreCase("random") || name_value.isEmpty()) {
				name_value = "Test_Automation_" + RandomStringUtils.randomAlphanumeric(2);
			}
			
			createEventTitleLocator.sendKeys(name_value);
			
			createdData.put("Name", name_value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// streetaddress_input
		try {
			streetAddress_value = formData.get("Street");
			if (streetAddress_value.equalsIgnoreCase("Random")) {
				streetAddress_value = RandomStringUtils.randomAlphabetic(8);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		streetAddressLocator.sendKeys(streetAddress_value);
		implicitWait(10);
		createdData.put("Street", streetAddress_value);

		// cityAddress_value
		try {
			cityAddress_value = formData.get("City");
			if(cityAddress_value.equalsIgnoreCase("Random") || cityAddress_value.isEmpty()) {
				cityAddress_value = RandomStringUtils.randomAlphabetic(8);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		cityAddressLocator.sendKeys(cityAddress_value);
		
		createdData.put("cityAddress_input", cityAddress_value);

		// stateAddress_value
		try {
			stateAddress_value = formData.get("State");
			if (stateAddress_value.equalsIgnoreCase("Random") || stateAddress_value.isEmpty()) {
				stateAddress_value = RandomStringUtils.randomAlphabetic(8);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		stateAddressLocator.sendKeys(stateAddress_value);
		
		createdData.put("State", stateAddress_value);

		// postCode_value
		try {
			postCode_value = formData.get("PostCode");
			if (postCode_value.equalsIgnoreCase("Random") || postCode_value.isEmpty()) {
				postCode_value = RandomStringUtils.randomNumeric(6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		postCodeAddressLocator.sendKeys(postCode_value);
		
		createdData.put("PostCode", postCode_value);

		// selectCountry
		try {
			selectCountry_value = formData.get("Country");
			
			if (selectCountry_value.equalsIgnoreCase("India") && !selectCountry_value.isEmpty()) {

				selectCountry_value = basePage.getRandomCountryName(dropDownCountryLocatorBtn, "country", "India");

				
					createdData.put("Country", selectCountry_value);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		// category
		try {
			category_value = formData.get("Category");
			if (!category_value.equalsIgnoreCase("Random")) {
				category_value = basePage.selectRandomDropDownValue("Category");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		createdData.put("Category", category_value);

		return createdData;
	}
	
	
	

}
