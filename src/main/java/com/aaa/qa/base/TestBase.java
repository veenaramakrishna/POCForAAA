package com.aaa.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Base class */
public class TestBase {
	/* Declaring global variables of WebDriver and Properties class */
	
	public static WebDriver driver; 
	
	public static Properties prop; 
		
	/*  Class constructor defined 
	 *  Initializing the prop variable and reading the Property file located in the config folder
	 * */
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/aaa"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser"); /* Reading values from the property file in the config folder */
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/Selenium_2019/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(); /*driver variable is initialized */
		}
		
		/*
		 * Defining window maximizing, cookie deletion, page load timeout, implicitly wait
		 * */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* Reading url value from property file */
		driver.get(prop.getProperty("url")); 
	}
}
