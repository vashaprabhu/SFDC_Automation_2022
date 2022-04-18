package com.sfdc.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement login;
	
	@FindBy(id="rememberUn")
	WebElement rememberMeChkBox;
	
	@FindBy(xpath = "//a[@id='forgot_password_link']")
	WebElement forgotPPasswordLink;
	
	@FindBy(id= "error")
	WebElement errorWithoutPassword;
	
	public String getErrorWithoutPassword() {
		String errMsg = errorWithoutPassword.getText();
		return errMsg;
	}
	
	
	@FindBy(xpath = "//div/span[@id='idcard-identity']")
	WebElement userNameAfterLogout;
	
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getRememberme() {
		return rememberMeChkBox;
	}
	
	public WebElement getForgotPassword() {
		return forgotPPasswordLink;
	}
	
	
	public WebElement getLoginBtn() {
		return login;
	}
	
	public String getUNAfterLogout() {
		String usrnameLater = userNameAfterLogout.getText();
		return usrnameLater;
	}
	
	@FindBy(id = "error")
	WebElement wrongCredentialsMsg;
	
	public String msgAfterWrongCredentials() {
		String msgToCheck = wrongCredentialsMsg.getText();
		return msgToCheck;
	}
	
	

}
