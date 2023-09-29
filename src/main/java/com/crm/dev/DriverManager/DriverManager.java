package com.crm.dev.DriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.dev.PageObjects.CalendarPage;
import com.crm.dev.PageObjects.CallsPage;
import com.crm.dev.PageObjects.CasesPage;
import com.crm.dev.PageObjects.CompaniesPage;
import com.crm.dev.PageObjects.ContactsPage;
import com.crm.dev.PageObjects.DealPage;
import com.crm.dev.PageObjects.DocumentsPage;
import com.crm.dev.PageObjects.HomePage;
import com.crm.dev.PageObjects.LoginPage;
import com.crm.dev.PageObjects.TasksPage;
import com.crm.dev.utility.TableOperator;


public class DriverManager {

	public static FileInputStream inputStream = null;
	public static Properties prop = null;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final String defaultPropertiesFile = System.getProperty("user.dir")+"//src//resources//config//config.properties";
	protected static String reportPath = System.getProperty("user.dir")+"//Reports//AutomationExtentReport.html";

	protected static LoginPage loginPage = null;
	protected static HomePage homePage = null;
	protected static TableOperator tableOperator = null;
	protected static CalendarPage calendarPage = null;
	protected static CallsPage callsPage = null;
	protected static ContactsPage contactsPage = null;
	protected static CompaniesPage companiesPage = null;
	protected static CasesPage casesPage = null;
	protected static  DealPage dealPage = null;
	protected static TasksPage tasksPage = null;
	protected static DocumentsPage documentsPage = null;

	
	public static WebDriver driver() {
		return driver.get();
	}
	
	public static void pageObjectsIntilization() {
	
		loginPage = new LoginPage(driver());
		homePage = new HomePage(driver());
		tableOperator = new TableOperator();
		calendarPage = new CalendarPage(driver());
		callsPage = new CallsPage(driver());
		contactsPage = new ContactsPage(driver());
		casesPage = new CasesPage(driver());
		dealPage = new DealPage(driver());
		tasksPage = new TasksPage(driver());
		documentsPage = new DocumentsPage(driver());
		companiesPage = new CompaniesPage(driver());
	}
	
	public static void destroyPageObjects() {
		
		loginPage = null;
		homePage = null;
		tableOperator = null;
		calendarPage = null;
		callsPage = null;
		contactsPage = null;
		casesPage = null;
		dealPage = null;
		tasksPage = null;
		documentsPage = null;
	}

	public static void createInstance(String input) {

		switch (input.toLowerCase()) {

		case "chrome":
			driver.set(new ChromeDriver());
			break;

		case "edge":
			driver.set(new EdgeDriver());
			break;

		default:
			break;

		}
	}

	public static void openBrowser() {

		if (System.getProperty("browser") == "gridurl") {
			// grid url
		} else
			createInstance(getInputProperty("browser"));

	}

	public static void maxmizeWindow() {

		driver().manage().window().maximize();
	}

	public static void deleteAllCookies() {

		driver().manage().deleteAllCookies();
	}

	public static void implicitWait(int timeout) {

		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public static void pageLoadTimeOut(int timeout) {

		driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
	}

	public static Properties readPropertyFile() {

		File file = new File(defaultPropertiesFile);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getInputProperty(String input) {
		Properties prop = readPropertyFile();
		String property = prop.getProperty(input);
		return property;
	}

}
