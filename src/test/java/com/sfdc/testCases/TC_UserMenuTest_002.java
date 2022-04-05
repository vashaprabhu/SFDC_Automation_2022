package com.sfdc.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sfdc.pageObjects.FramePage;
import com.sfdc.pageObjects.HomePage;
import com.sfdc.pageObjects.LoginPage;

public class TC_UserMenuTest_002 extends BaseClass{
	TC_LoginTest_001 tclogin = new TC_LoginTest_001();
	
	@Test(enabled = true)
	public void userTest01() {
		driver = tclogin.loginTest06();
		HomePage hp = new HomePage(driver);
		hp.clickUserMenuTab();
		testLogger.info("clicked on user menu button");
		hp.getMenuItems();
		testLogger.info("got menu items");
		
	}
	
	@Test
	public void userTest02() throws InterruptedException {
		
		driver = tclogin.loginTest06();
		HomePage hp = new HomePage(driver);
		hp.clickUserMenuTab();
		testLogger.info("clicked on user menu button");
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(hp.getMyprofile()));
		testLogger.info("waits for my profile");
		WebElement prof = hp.getMyprofile();
		testLogger.info("pass my profile to a webelement variable");
		prof.click();
		testLogger.info("cicked on myprofile");
		wait.until(ExpectedConditions.visibilityOf(hp.editIcon()));
		testLogger.info("waiting for edit icon");
		Thread.sleep(3000);
		hp.clickEditIcon();
		testLogger.info("clicked on edit icon");
		Thread.sleep(3000);
		hp.clickAboutTab();
		testLogger.info("clicked on about tab");
		hp.setLastname(lname);
		testLogger.info("last name changed");
		hp.clickSaveAll();
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
		hp.clickOnItemInList("Post");
		testLogger.info("clicked on post");
		hp.setTextOnPost(pText);
		testLogger.info("text entered to post");
		hp.clickShareBtn();
		testLogger.info(Status.PASS+" post shared.");
		hp.clickOnItemInList("File");
		testLogger.info("clicked on file");
		Thread.sleep(2000);
		
	
	}
	

}
