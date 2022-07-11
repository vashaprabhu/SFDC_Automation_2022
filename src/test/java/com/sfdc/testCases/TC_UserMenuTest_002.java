package com.sfdc.testCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import com.sfdc.pageObjects.FramePage;
import com.sfdc.pageObjects.HomePage;
import com.sfdc.pageObjects.LoginPage;
import com.sfdc.utilities.ReusableUtilities;

public class TC_UserMenuTest_002 extends BaseClass{
	
	TC_LoginTest_001 tclogin = new TC_LoginTest_001();
	
	ReusableUtilities reUtil = new ReusableUtilities();
	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void userTest01() {
		driver = tclogin.loginTest06();
		
		HomePage hp = new HomePage(driver);
		reUtil.clickOnWebElement(hp.getUserMenuTab());
		testLogger.info("clicked on user menu button");
		hp.getMenuItems();
		testLogger.info("got menu items");
		Assert.assertTrue(true);	
	}	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void userTest02() throws InterruptedException {
		
		driver = tclogin.loginTest06();
		
		HomePage hp = new HomePage(driver);
		reUtil.clickOnWebElement(hp.getUserMenuTab());
		testLogger.info("clicked on user menu button");
		reUtil.explicitWait(driver ,hp.getMyprofile());
		testLogger.info("waits for my profile");
		reUtil.clickOnItemOfList(hp.getUserMenu(), "My Profile");
		testLogger.info("pass my profile to a webelement variable");
		testLogger.info("cicked on myprofile");
		reUtil.explicitWait(driver ,hp.editIcon());
		testLogger.info("waiting for edit icon");
		Thread.sleep(3000);
		reUtil.clickOnWebElement(hp.editIcon());
		testLogger.info("clicked on edit icon");
		Thread.sleep(3000);
		hp.clickAboutTab();
		testLogger.info("clicked on about tab");
		hp.setLastname(lname);
		testLogger.info("last name changed");
		reUtil.clickOnWebElement(hp.getSaveAll());
		testLogger.info("saved last name");
		Thread.sleep(5000);
		String changeName = hp.getLName();
		System.out.println(changeName);
		if(changeName.contains(lname)) {
			Assert.assertTrue(true);
			testLogger.info(Status.PASS);
		}else {
			Assert.assertTrue(false);
			testLogger.info(Status.FAIL);
		}
		reUtil.clickOnItemOfList(hp.getPublisherFeedItems(), "Post");
		testLogger.info("clicked on post");
		hp.setTextOnPost(pText);
		testLogger.info("text entered to post");
		hp.clickShareBtn();
		testLogger.info(Status.PASS+" post shared.");
		Thread.sleep(2000);
		reUtil.clickOnItemOfList(hp.getPublisherFeedItems(), "File");
		testLogger.info("clicked on file");
		Thread.sleep(5000);
		reUtil.clickOnWebElement(hp.getUploadFromComp());
		testLogger.info("clicked on upload from computer");
		reUtil.setValueToElement(hp.getFileToUpload(), "C:\\Users\\varsh\\Documents\\my test.txt");
		hp.shareFile();
		testLogger.info("File uploaded and saved ");
		reUtil.mouseHovarClick(driver, hp.getPhotoSection(), hp.getUploadPhotoLink());
		testLogger.info("clicked on photo upload ");
		Thread.sleep(5000);
		hp.setPhoto("C:\\Users\\varsh\\Documents\\sfdcupload.jpg");
		reUtil.clickOnWebElement(hp.getSaveBtn());
		testLogger.info("photo uploaded and saved ");
	}
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void userTest03() throws InterruptedException {
		driver = tclogin.loginTest06();
		
		HomePage hp = new HomePage(driver);
		reUtil.clickOnWebElement(hp.getUserMenuTab());
		testLogger.info("clicked on user menu button");
		reUtil.explicitWait(driver ,hp.getSettings());
		testLogger.info("waits for my Settings");
		reUtil.clickOnWebElement(hp.getSettings());
		testLogger.info("clicked on my settings");
		Thread.sleep(5000);
		reUtil.clickOnItemOfList(hp.getSettingsList(), "Personal");
		testLogger.info("selected personal");
		reUtil.clickOnItemOfList(hp.getPersonalSettingMenu(), "Login History");
		testLogger.info("clicked on login history");
		Assert.assertTrue(hp.getDownloadLink().getText().contains(".csv"));
		reUtil.clickOnItemOfList(hp.getSettingsList(), "Display & Layout");
		testLogger.info("clicked on Display n layout");
		reUtil.clickOnItemOfList(hp.getDisplayItems(), "Customize My Tabs");
		testLogger.info("clicked on Customise My tabs");
		Assert.assertTrue(driver.getCurrentUrl().contains("CustomizeTabs"));
		reUtil.clickOnItemOfList(hp.getCustomeOptions(), "Salesforce Chatter");
		testLogger.info("clicked on SalesForce Chatter");
		if(reUtil.listHasItem(hp.getSelectedTabs(), "Reports")) {
			reUtil.clickOnItemOfList(hp.getSelectedTabs(), "Reports");
			reUtil.clickOnWebElement(hp.getRemoveButton());
			Select select = new Select(hp.getAvailableTabs());
			select.selectByVisibleText("Reports");
			reUtil.clickOnWebElement(hp.getAddButton());
			
		}else {
			Select select = new Select(hp.getAvailableTabs());
			select.selectByVisibleText("Reports");
			reUtil.clickOnWebElement(hp.getAddButton());
			Thread.sleep(2000);
			reUtil.clickOnWebElement(hp.getSaveTabs());
			testLogger.info("Reports tab added");
			reUtil.listHasItem(hp.getSelectedTabs(), "Reports");
			Assert.assertTrue(true);
			reUtil.clickOnWebElement(hp.getSaveTabs());
			testLogger.info("Reports tab saved");
		}
		
		reUtil.clickOnItemOfList(hp.getSettingsList(), "Email");
		testLogger.info("email setting has been clicked");
		reUtil.clickOnItemOfList(hp.getEmailItems(), "My Email Settings");
		testLogger.info("my email settings");
		hp.getEmailName().clear();
		reUtil.setValueToElement(hp.getEmailName(), "vars");
		hp.getEmailAddress().clear();
		reUtil.setValueToElement(hp.getEmailAddress(), "varshaks14@gmail.com");
		testLogger.info("entered email name and email address");
		reUtil.clickOnWebElement(hp.getRadioBtnForNo());
		reUtil.clickOnWebElement(hp.getRadioBtnForYes());
		reUtil.clickOnWebElement(hp.getSaveButton());
		reUtil.clickOnItemOfList(hp.getSettingsList(), "Calendar & Reminders");
		reUtil.clickOnItemOfList(hp.getCalenderOptions(), "Activity Reminders");
		Assert.assertTrue(driver.getTitle().contains("Activity Reminders"));
		String windowBeforerRemainder = driver.getCurrentUrl();
		System.out.println(windowBeforerRemainder);
		reUtil.clickOnWebElement(hp.getOpenRemainderBtn());
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
//		int windows = driver.getWindowHandles().size();
//		System.out.println(windows);
		for(String winHandle : windows) {
			if(!(winHandle.toString().equals(windowBeforerRemainder))) {
				System.out.println(winHandle.toString());
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().window(winHandle);
				System.out.println(driver.getCurrentUrl());
				reUtil.clickOnWebElement(hp.getDismissRemBtn());
				driver.switchTo().defaultContent();
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(2000);
			}
			reUtil.clickOnWebElement(hp.getSaveActivity());
			driver.close();
			
		}
//		driver.switchTo().activeElement().click();
//		for(int i = 0; i<windows; i++) {
//			if(i == 1) {
//				reUtil.clickOnWebElement(hp.getDismissRemBtn());
//				reUtil.clickOnWebElement(hp.getSaveActivity());
//				driver.close();
//				Thread.sleep(2000);
//				
//			}else {
//				
//				reUtil.clickOnWebElement(hp.getSaveActivity());
//			}
//		}
//		driver.close();
		
		
	}
	
//	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void userTest05() throws InterruptedException {
		TC_LoginTest_001 loginTest = new TC_LoginTest_001();
		loginTest.loginTest03();
	}
	
//	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void userTest04() {
		driver = tclogin.loginTest06();
		
		HomePage hp = new HomePage(driver);
		reUtil.clickOnWebElement(hp.getUserMenuTab());
		testLogger.info("clicked on user menu button");
		String windowBeforeDevConsole = driver.getWindowHandle();
		reUtil.clickOnItemOfList(hp.getUserMenu(), "Developer Console");
		
		Set<String> windows = driver.getWindowHandles();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.close();
		driver.switchTo().window(windowBeforeDevConsole);
		
	}
	
	
}
