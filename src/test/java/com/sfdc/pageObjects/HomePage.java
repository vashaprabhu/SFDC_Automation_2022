package com.sfdc.pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id = "userNavButton")
	WebElement userMenuTab ;
	
	public String getUserName() {
		String name = userMenuTab.getText();
		return name;
	}
	
	public void clickUserMenuTab()
	{
		userMenuTab.click();
	}
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	List<WebElement> userMenuItems;
	
	@FindBy(xpath = "//div/a[@title='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//div/a[@title='My Profile']")
	WebElement myProfile;
	
	public void clickLogout() {
			for(WebElement items : userMenuItems) {
				String it = items.getText();
				if(it.contains("Logout")) {
					logout.click();
				}
			}
	}
	
	public void getMenuItems() {
		for(WebElement items : userMenuItems) {
			String it = items.getText();
			System.out.println(it);
		}
	
	}
	
	public WebElement getMyprofile() {
		for(WebElement items : userMenuItems) {
			String it = items.getText();
			if(it.contains("My Profile")) {
				System.out.println("yes "+myProfile.getText());
			}
		}
		return myProfile;
	}
	
	@FindBy(xpath = "//div[@class='editPen']//descendant::a[@class='contactInfoLaunch editLink']/img")
	WebElement editIcon;
	
	public WebElement editIcon() {
		return editIcon;
	}
	
	public void clickEditIcon() {
		editIcon.click();
	}
	
	@FindBy(xpath = "//div[@class='zen-header']//ul//li[1]")
	WebElement aboutTab;
	
	public void clickAboutTab() {
		FramePage frm = new FramePage(ldriver);
		ldriver = frm.frameHandling1();
		aboutTab.click();
	}
	
	@FindBy(xpath = "//*[@id='lastName']")
	WebElement lnAbout;
	
	public void setLastname(String ln) {
		lnAbout.clear();
		lnAbout.sendKeys(ln);
	}
	
	@FindBy(xpath = "//*[@value='Save All']")
	WebElement saveAll;
	
	public void clickSaveAll() {
		saveAll.click();
	}
	
	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	WebElement nameOnLeft;
	
	public String getLName() {
		return nameOnLeft.getText();
	}
	
	@FindBy(xpath = "//div/ul[@class='publisherFeedItemTypeChoices']/li")
	List<WebElement> publisherFeedItems;
	
	public void clickOnItemInList(String item) {
		for(WebElement it : publisherFeedItems) {
			if(it.getText().equals(item)) {
				it.click();
			}
		}
	}
	
	@FindBy(xpath = "//body[@contenteditable='true']")
	WebElement placeHolder;
	
	public void setTextOnPost(String str) {
		FramePage frm = new FramePage(ldriver);
		ldriver = frm.frameHandling2();
		placeHolder.sendKeys(str);
	}
	
	@FindBy(xpath = "//span/input[@id='publishersharebutton']")
	WebElement shareBtn;
	
	public void clickShareBtn() {
		FramePage frm = new FramePage(ldriver);
		ldriver = frm.backFromFrame2();
		shareBtn.click();
	}
	
	
	
	
	
	
	
	
	
	

}
