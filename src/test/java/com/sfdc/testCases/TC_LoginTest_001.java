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
import com.sfdc.utilities.ReusableUtilities;
//@Listeners(com.sfdc.utilities.ReportListener.class)
public class TC_LoginTest_001 extends BaseClass {

	ReusableUtilities reUtil = new ReusableUtilities();
	
	@Test(enabled = false)
	public void loginTest01() {
		
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		
		reUtil.setValueToElement(lp.getUsername(), username);
		testLogger.info("Username entered");
		reUtil.setValueToElement(lp.getPassword(), password);
		testLogger.info("entered Password");
		reUtil.clickOnWebElement(lp.getRememberme());
		testLogger.info("Remember me checked");
		reUtil.clickOnWebElement(lp.getLoginBtn());
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
	
	@Test(enabled = false)
	public void loginTest02() {
		
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		reUtil.setValueToElement(lp.getUsername(), username);
		testLogger.info("Username entered");
		reUtil.setValueToElement(lp.getPassword(), "");
		testLogger.info("entered no Password");
		reUtil.clickOnWebElement(lp.getRememberme());
		testLogger.info("Remember me checked");
		reUtil.clickOnWebElement(lp.getLoginBtn());
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
	
	@Test(enabled = false)
	public void loginTest03() throws InterruptedException {
		
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		reUtil.setValueToElement(lp.getUsername(), username);
		testLogger.info("Username entered");
		reUtil.setValueToElement(lp.getPassword(), password);
		testLogger.info("entered Password");
		reUtil.clickOnWebElement(lp.getRememberme());
		testLogger.info("Remember me checked");
		reUtil.clickOnWebElement(lp.getLoginBtn());
		testLogger.info("clicked on login");
		HomePage hp = new HomePage(driver);
		reUtil.clickOnWebElement(hp.getUserMenuTab());
		testLogger.info("clicked on user menu button");
		
		reUtil.clickOnItemOfList(hp.getUserMenu(), "Logout");
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
	
	@Test(enabled = false)
	public void loginTest04() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		reUtil.clickOnWebElement(lp.getForgotPassword());
		testLogger.info("clicked on forgot your password?");	
		PasswordResetPage pr = new PasswordResetPage(driver);
		reUtil.setValueToElement(pr.getUNForPassword(), username);
		testLogger.info("Entered username to reset password");
		reUtil.clickOnWebElement(pr.getOnContinue());
		testLogger.info("clicked on continue btn");
		pr.getResetMsg();
		testLogger.info("got reset msg as : "+pr.getResetMsg());
		reUtil.clickOnWebElement(pr.getReturnToLogin());
		testLogger.info("Clicked on return btn");
		if(driver.getTitle().equals(titleAfterWrongPswd)) {
			Assert.assertTrue(true);
			testLogger.info(Status.PASS);
		}else {
			Assert.assertTrue(false);
			testLogger.info(Status.FAIL);
		}
	}
	
	@Test(enabled = false)
	public void loginTest05() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		reUtil.setValueToElement(lp.getUsername(), wrusername);
		testLogger.info("Entered wrong username");
		reUtil.setValueToElement(lp.getPassword(), wrpassword);
		testLogger.info("Entered wrong password");
		reUtil.clickOnWebElement(lp.getLoginBtn());
		testLogger.info("clicked on login");
		lp.msgAfterWrongCredentials();
		testLogger.info(lp.msgAfterWrongCredentials()+" this msg we got");
		
	}
//	@Test
	public WebDriver loginTest06() {
		driver.get(baseURL);
		testLogger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		reUtil.setValueToElement(lp.getUsername(), username);
		testLogger.info("Username entered");
		reUtil.setValueToElement(lp.getPassword(), password);
		testLogger.info("entered Password");
		reUtil.clickOnWebElement(lp.getRememberme());
		testLogger.info("Remember me checked");
		reUtil.clickOnWebElement(lp.getLoginBtn());
		testLogger.info("clicked on login");
		return driver;
	}
	

}
