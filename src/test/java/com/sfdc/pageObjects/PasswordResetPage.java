package com.sfdc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
WebDriver ldriver;
	
	public PasswordResetPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//div/input[@type='email']")
	WebElement userNameToResetPassword;
	
	public void setUNForPassword(String name) {
		userNameToResetPassword.sendKeys(name);
	}
	
	@FindBy(xpath = "//div/input[@type='submit']")
	WebElement continueBtn;
	
	public void clickOnContinue() {
		continueBtn.click();
	}
	
	@FindBy(xpath = "//div/h1[@id='header']")
	WebElement resetMsg;
	
	public String getResetMsg() {
		String resetmsg = resetMsg.getText();
		return resetmsg;
	}
	
	@FindBy(xpath = "//div/a[contains(text(), 'Return')]")
	WebElement returnToLogin;
	
	public void clickReturnToLogin() {
		returnToLogin.click();
	}
}
