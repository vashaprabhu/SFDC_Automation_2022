package com.sfdc.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
WebDriver ldriver;
		
	public AccountsPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//li[@id='Account_Tab']")
	WebElement accTab;
	
	public WebElement getAccTab() {
		return accTab;
	}
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement newAccBtn;
	
	public WebElement getNewAccBtn() {
		return newAccBtn;
	}
	
	@FindBy(xpath = "//ul[@id='tabBar']/li")
	List<WebElement> tabsOnTabbar;
	
	public List<WebElement> getTabsOnBar(){
		return tabsOnTabbar;
	}
	
	@FindBy(xpath = "//*[@class='requiredInput']/input")
	WebElement accNameTBox;
	
	public WebElement getAccNameTBox() {
		return accNameTBox;
	}
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[@name='save']")
	WebElement accSaveBtn;
	
	public WebElement getAccSaveBtn() {
		return accSaveBtn;
	}
	
	@FindBy(xpath = "//div/a[@class='x-tool x-tool-close']")
	WebElement customerKnowledgePopupClose;
	
	public WebElement getClosedCustomerKnow() {
		return customerKnowledgePopupClose;
	}
	
	@FindBy(xpath = "//div[@class='textBlock']/h2")
	WebElement accNameDisplayed;
	
	public String getAccName() {
		return accNameDisplayed.getText();
		
	}
	
	@FindBy(xpath = "//span[@class='fFooter']/descendant::a[2]")
	WebElement createNewViewLink;
	
	public WebElement getCreateNewView() {
		return createNewViewLink;
		
	}
	
	@FindBy(id = "fname")
	WebElement vNameTextbox;
	
	public WebElement getVNameTextbox() {
		return vNameTextbox;
	}
	
	@FindBy(id = "devname")
	WebElement uniqueVNameTextbox;
	
	public WebElement getuniqueVNameTextbox() {
		return uniqueVNameTextbox;
	}
	@FindBy(xpath = "(//input[@name='save'])[1]")
	WebElement saveNewView;
	
	public WebElement getSaveNewViewBtn() {
		return saveNewView;
	}
	
	@FindBy(xpath ="//select[@title='View:']/option")
	List<WebElement> savedView;
	
	public List<WebElement> getSavedView() {
		return savedView;
	}
	@FindBy(linkText = "here")
	WebElement validationLink;
	
	public WebElement getValidationlink() {
		return validationLink;
	}
	
	@FindBy(xpath = "//span[@class='fFooter']/a[contains(text(), 'Edit')]")
	WebElement editView;
	
	public WebElement getEditViewLink() {
		return editView;
	}
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement nameOnEditPage;
	
	public WebElement getNameOnEditPage() {
		return nameOnEditPage;
	}
	
	@FindBy(xpath = "//*[@id='fcol1']")
	WebElement itemsOfFilterField;
	
	public WebElement getItemsOfFilterField() {
		return itemsOfFilterField;
	}
	
	@FindBy(xpath = "//select[@title='Operator 1']")
	WebElement itemsOfOperator;
	
	public WebElement getItemsOfOperator() {
		return itemsOfOperator;
	}
	
	@FindBy(id = "fval1")
	WebElement fieldValue;
	
	public WebElement getFieldValvue() {
		return fieldValue;
	}
	
	@FindBy(xpath = "//select[@id='colselector_select_0']/option")
	List<WebElement> availableFields;
	
	public List<WebElement> getAvailableField() {
		return availableFields;
	}
	
	@FindBy(xpath = "//a[@id='colselector_select_0_right']")
	WebElement addFiledBtn;
	
	public WebElement getAddBtn() {
		return addFiledBtn;
	}
	
	@FindBy(xpath = "//select[@id='colselector_select_1']/option")
	List<WebElement> selectedFields;
	
	public List<WebElement> getSelectedFields() {
		return selectedFields;
	}
	
	@FindBy(xpath = "(//td[@class='pbButtonb'])[1]/input[@title='Save']")
	WebElement saveEditViewPage;
	
	public WebElement getEditSaveButton() {
		return saveEditViewPage;
	}
}
