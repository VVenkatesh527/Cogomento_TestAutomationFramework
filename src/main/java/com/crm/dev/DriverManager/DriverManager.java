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


public class DriverManager {

	public static FileInputStream inputStream = null;
	public static Properties prop = null;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver driver() {
		return driver.get();
	}
	
	public static void pageInt() {
	
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

		String filePath = System.getProperty("user.dir") + "//config//config.properties";
		File file = new File(filePath);
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
