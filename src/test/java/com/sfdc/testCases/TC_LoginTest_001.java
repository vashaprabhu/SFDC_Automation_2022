package com.sfdc.testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sfdc.pageObjects.HomePage;
import com.sfdc.pageObjects.LoginPage;
import com.sfdc.pageObjects.PasswordResetPage;
//@Listeners(com.sfdc.utilities.ReportListener.class)
public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest01() {
		
		driver.get(baseURL);
		testLogger.info("url opened");
			
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		testLogger.info("Username entered");
		lp.setPassword(password);
		testLogger.info("entered Password");
		lp.clickRememberme();
		testLogger.info("Remember me checked");
		lp.clickLoginBtn();
		testLogger.info("clicked on login");
		HomePage hp = new HomePage(driver);
		String uname = hp.getUserName();
		System.out.println(uname);
		if(driver.getTitle().equals(titleAfterLogin)) {
			testLogger.info("login pass");
			Assert.assertTrue(true);		
		}
		else {
			Assert.assertTrue(false);		
		}
	}
	
	@Test
	public void loginTest02() {
		
		driver.get(baseURL);
		testLogger.info("url opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		testLogger.info("Username entered");
		lp.setPassword("");
		testLogger.info("entered no Password");
		lp.clickRememberme();
		testLogger.info("Remember me checked");
		lp.clickLoginBtn();
		testLogger.info("clicked on login");
	
		if(driver.getTitle().equals(titleAfterWrongPswd)) {
			String msg = lp.getErrorWithoutPassword();
			testLogger.info(msg+" error msg");
			testLogger.info("login doesnot happened");
			Assert.assertTrue(true);		
		}
		else {
			
			Assert.assertTrue(false);	
		}
	}
	
	@Test
	public void loginTest03() throws InterruptedException {
		
		driver.get(baseURL);
		testLogger.info("url opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		testLogger.info("Username entered");
		lp.setPassword(password);
		testLogger.info("entered Password");
		lp.clickRememberme();
		testLogger.info("Remember me checked");
		lp.clickLoginBtn();
		testLogger.info("clicked on login");
		
		HomePage hp = new HomePage(driver);
		hp.clickUserMenuTab();
		testLogger.info("clicked on user menu button");
		hp.clickLogout();
		testLogger.info("clicked logout");
		Thread.sleep(3000);
		if(lp.getUNAfterLogout().equals(username)) {
			testLogger.info("username is available after logout");
			Assert.assertTrue(true);
		}else {
			testLogger.info("username is not available after logout");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void loginTest04() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		lp.clickForgotPassword();
		testLogger.info("clicked on forgot your password?");	
		PasswordResetPage pr = new PasswordResetPage(driver);
		pr.setUNForPassword(username);
		testLogger.info("Entered username to reset password");
		pr.clickOnContinue();
		testLogger.info("clicked on continue btn");
		pr.getResetMsg();
		testLogger.info("got reset msg as : "+pr.getResetMsg());
		pr.clickReturnToLogin();
		testLogger.info("Clicked on return btn");
		if(driver.getTitle().equals(titleAfterWrongPswd)) {
			Assert.assertTrue(true);
			testLogger.info(Status.PASS);
		}else {
			Assert.assertTrue(false);
			testLogger.info(Status.FAIL);
		}
	}
	
	@Test
	public void loginTest05() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(wrusername);
		testLogger.info("Entered wrong username");
		lp.setPassword(wrpassword);
		testLogger.info("Entered wrong password");
		lp.clickLoginBtn();
		testLogger.info("clicked on login");
		lp.msgAfterWrongCredentials();
		testLogger.info(lp.msgAfterWrongCredentials()+" this msg we got");
		
	}
	@Test
	public WebDriver loginTest06() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		testLogger.info("Username entered");
		lp.setPassword(password);
		testLogger.info("entered Password");
		lp.clickRememberme();
		testLogger.info("Remember me checked");
		lp.clickLoginBtn();
		testLogger.info("clicked on login");
		return driver;
	}
	

}
