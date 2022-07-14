package com.sfdc.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sfdc.pageObjects.AccountsPage;
import com.sfdc.utilities.ReusableUtilities;

public class TC_AccountsTest_003 extends BaseClass{
	
	TC_LoginTest_001 tclogin = new TC_LoginTest_001();
	
	ReusableUtilities reUtil = new ReusableUtilities();
	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void accTest01() throws InterruptedException {
		
		driver = tclogin.loginTest06();
		AccountsPage ap = new AccountsPage(driver);
		SoftAssert sa = new SoftAssert();
		reUtil.explicitWait(driver, ap.getAccTab());
		reUtil.clickOnItemOfList(ap.getTabsOnBar(), "Accounts");
		
		sa.assertTrue(driver.getTitle().contains("Accounts: Home"));
		reUtil.explicitWait(driver, ap.getNewAccBtn());
		reUtil.clickOnWebElement(ap.getNewAccBtn());
		reUtil.explicitWait(driver, ap.getAccNameTBox());
		String accNameEntered ="new_apr_22";
		reUtil.setValueToElement(ap.getAccNameTBox(),accNameEntered );
		reUtil.clickOnWebElement(ap.getAccSaveBtn());
		Thread.sleep(2000);
//		reUtil.clickOnWebElement(ap.getClosedCustomerKnow());/*838*/
		
		if(ap.getAccName().equals(accNameEntered)) {
			sa.assertTrue(true);
		}else {
			sa.assertTrue(false);
		}
//	just checking in jenkins
	}
	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void accTest02() throws InterruptedException {
		driver = tclogin.loginTest06();
		AccountsPage ap = new AccountsPage(driver);
		SoftAssert sa = new SoftAssert();
		reUtil.explicitWait(driver, ap.getAccTab());
		reUtil.clickOnItemOfList(ap.getTabsOnBar(), "Accounts");
			
		sa.assertTrue(driver.getTitle().contains("Accounts: Home"));
		reUtil.explicitWait(driver, ap.getCreateNewView());
		reUtil.clickOnWebElement(ap.getCreateNewView());
		reUtil.explicitWait(driver, ap.getVNameTextbox());
		String viewName = "var_view";
		String uViewName ="var_view_12";
		reUtil.setValueToElement(ap.getVNameTextbox(), viewName);
		reUtil.setValueToElement(ap.getuniqueVNameTextbox(), uViewName);
		reUtil.clickOnWebElement(ap.getSaveNewViewBtn());
		if(ap.getValidationlink().isDisplayed()) {
			reUtil.clickOnWebElement(ap.getValidationlink());
		}
		List<WebElement> savedViewList = ap.getSavedView();
		
		for(WebElement views : savedViewList ) 
			if(views.getText().contains(viewName)) {	
				sa.assertTrue(true);
			}else {
				sa.assertTrue(false);
			}
	}
	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void accTest03() throws InterruptedException {
		driver = tclogin.loginTest06();
		AccountsPage ap = new AccountsPage(driver);
		SoftAssert sa = new SoftAssert();
		reUtil.explicitWait(driver, ap.getAccTab());
		reUtil.clickOnItemOfList(ap.getTabsOnBar(), "Accounts");
			
		sa.assertTrue(driver.getTitle().contains("Accounts: Home"));
		String viewName = "var_view";
		reUtil.clickOnItemOfList(ap.getSavedView(), viewName);
		reUtil.explicitWait(driver, ap.getEditViewLink());
		reUtil.clickOnWebElement(ap.getEditViewLink());
		reUtil.explicitWait(driver, ap.getNameOnEditPage());
		sa.assertNotSame(ap.getNameOnEditPage().getText(), viewName);
		String newViewName = "new_var_view";
		ap.getNameOnEditPage().clear();
		reUtil.setValueToElement(ap.getNameOnEditPage(), newViewName);
		Select select = new Select(ap.getItemsOfFilterField());
		select.selectByVisibleText("Account Name");
		select= new Select(ap.getItemsOfOperator());
		select.selectByVisibleText("contains");
		ap.getFieldValvue().clear();
		reUtil.setValueToElement(ap.getFieldValvue(), "a");
		String fieldToAdd ="Last Activity";
//		reUtil.clickOnItemOfList(ap.getAvailableField(), fieldToAdd);
//		reUtil.clickOnWebElement(ap.getAddBtn());
		for(WebElement fields : ap.getSelectedFields() )
		if(fields.getText().contains(fieldToAdd)) {
			sa.assertTrue(true);
		}else{
			reUtil.clickOnItemOfList(ap.getAvailableField(), fieldToAdd);
			reUtil.clickOnWebElement(ap.getAddBtn());
		}
		
		reUtil.clickOnWebElement(ap.getEditSaveButton());
	}
	
	@Test(retryAnalyzer = com.sfdc.utilities.RetryFailedTests.class)
	public void accTest04() throws InterruptedException {
		driver = tclogin.loginTest06();
		AccountsPage ap = new AccountsPage(driver);
		SoftAssert sa = new SoftAssert();
		reUtil.explicitWait(driver, ap.getAccTab());
		reUtil.clickOnItemOfList(ap.getTabsOnBar(), "Accounts");
	
	
	}
	

}
