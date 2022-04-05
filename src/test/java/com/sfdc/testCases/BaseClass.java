package com.sfdc.testCases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sfdc.utilities.ReadConfig;
import com.sfdc.utilities.ReportListener;

import com.sfdc.utilities.ReadConfig;
@Listeners(com.sfdc.utilities.ReportListener.class)
public class BaseClass {
	
	static ReadConfig readConfig = new ReadConfig();
	
	public static String baseURL = readConfig.getApplicationURL();
	public static String username = readConfig.getUserName();
	public static String password = readConfig.getPassword();
	public String wrusername = readConfig.getWUserName();
	public String wrpassword = readConfig.getWPassword();
	public String lname = readConfig.getLastname();
	public String pText = readConfig.getText();
	
	public static long startTime = 0;
	public static long endTime = 0;
	
	public String titleAfterLogin = "Home Page ~ Salesforce - Developer Edition";
	public String titleAfterWrongPswd = "Login | Salesforce";
	
	public static WebDriver driver = null;
	
	public static Logger testLogger;
	
	@BeforeMethod
//	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		testLogger = LogManager.getLogger(getClass().getSimpleName());
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j2.properties");	
		
		startTime = System.currentTimeMillis();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		testLogger.info("time taken for test "+totalTime);
		
	}
	
	@AfterClass
	public void closeDriver() {
//		driver.quit();
	}
	
	public String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot take = (TakesScreenshot) driver;
		File src = take.getScreenshotAs(OutputType.FILE);
		String dateFormat = new SimpleDateFormat("yyyy.MMddHHmmss").format(new Date());
		String pathOfFile = System.getProperty("user.dir")+"\\Screenshots\\"+dateFormat+"_sfdcscreenshot.png";
		File dest = new File(pathOfFile);
		FileUtils.copyFile(src, dest);
		return pathOfFile;
	}

}
