package com.stepDefnitionFiles;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sfdc.pageObjects.HomePage;
import com.sfdc.pageObjects.LoginPage;
import com.sfdc.utilities.ReadConfig;
import com.sfdc.utilities.ReusableUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;


public class Loginsteps {
	public  String baseURL = readConfig.getApplicationURL();
	public static WebDriver driver = null;
	static ReadConfig readConfig = new ReadConfig();
	public String titleAfterLogin = "Home Page ~ Salesforce - Developer Edition";
	
	public ReusableUtilities reUtil = new ReusableUtilities();
	
	public static Logger testLogger;
	
	@Before
	public void initialiseReportLogger() {
		testLogger = LogManager.getLogger(getClass().getSimpleName());
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\cucumberLogs.properties");	
	}
	
//	@After
//	public void teardown() {
//		driver.close();
//		driver.quit();
//	}
//	
	
	@Given("User launches the loginpage")
	public void user_launches_the_loginpage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\varsh\\Documents\\Driver_Dependancies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		testLogger.info("launched webdite");
	    
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		reUtil.setValueToElement(lp.getUsername(), username);
		reUtil.setValueToElement(lp.getPassword(), password);
		testLogger.info("Entered username and password");
	    
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		LoginPage lp = new LoginPage(driver);
		reUtil.clickOnWebElement(lp.getRememberme());
		testLogger.info("clicked on remember me");
		reUtil.clickOnWebElement(lp.getLoginBtn());
		testLogger.info("clicked on login button");
	    
	}

	@Then("User should land on {string}")
	public void user_should_land_on(String string) {
		HomePage hp = new HomePage(driver);
		driver.getTitle().equals(titleAfterLogin);
		System.out.println(string);
	}

}
