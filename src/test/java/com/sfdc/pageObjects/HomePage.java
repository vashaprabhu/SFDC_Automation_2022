package com.sfdc.pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	public WebElement getUserMenuTab() {
		return userMenuTab;
	}
	
	public String getUserName() {
		String name = userMenuTab.getText();
		return name;
	}
	
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	List<WebElement> userMenuItems;
	
	public List<WebElement> getUserMenu(){
		return userMenuItems;
	}
	
	@FindBy(xpath = "//div/a[@title='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//div/a[@title='My Profile']")
	WebElement myProfile;
	
	
	public void getMenuItems() {
		for(WebElement items : userMenuItems) {
			String it = items.getText();
			System.out.println(it);
		}
	
	}
	
	public WebElement getMyprofile() {
		return myProfile;
	}
	
	@FindBy(xpath = "//div[@class='editPen']//descendant::a[@class='contactInfoLaunch editLink']/img")
	WebElement editIcon;
	
	public WebElement editIcon() {
		return editIcon;
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
	
	public WebElement getSaveAll() {
		return saveAll;
	}
	
	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	WebElement nameOnLeft;
	
	public String getLName() {
		return nameOnLeft.getText();
	}
	
	@FindBy(xpath = "//div/ul[@class='publisherFeedItemTypeChoices']/li")
	List<WebElement> publisherFeedItems;
	
	public List<WebElement> getPublisherFeedItems(){
		return publisherFeedItems;
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
	
	@FindBy(xpath ="//*[@id='chatterUploadFileAction']")
	WebElement uploadFromComp;
	
	public WebElement getUploadFromComp() {
		return uploadFromComp;
	}
	
	@FindBy(xpath ="//input[@id='chatterFile']")
	WebElement chooseFile;
	
	public WebElement getFileToUpload() {
		return chooseFile;
	}
	
	@FindBy(xpath ="//*[@id='publishersharebutton']")
	WebElement fileShareBtn;
	
	public void shareFile() {
		fileShareBtn.click();
	}
	
	@FindBy(xpath = "//div[@id='photoSection']")
	WebElement photoSection;
	
	public WebElement getPhotoSection() {
		return photoSection;
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Add Photo')]")
	WebElement uploadPhotoLink;
	
	public WebElement getUploadPhotoLink() {
		return uploadPhotoLink;
	}
	
//	public void clickPhotoUpload() {
//		Actions action = new Actions(ldriver);
//		action.moveToElement(photoSection).build().perform();
//		if(uploadPhotoLink.isDisplayed()) {
//			uploadPhotoLink.click();
//		}
//	}
	
	@FindBy(xpath="//form[@id='j_id0:uploadFileForm']/input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement choosePhoto;
	
	public void setPhoto(String photoPath) throws InterruptedException {
		FramePage frm = new FramePage(ldriver);
		ldriver = frm.framePhoto();
		if(choosePhoto.isDisplayed()) {
			choosePhoto.click();
			System.out.println("1");
			Thread.sleep(5000);
			System.out.println("2");
			choosePhoto.sendKeys(photoPath);
		}
		else {
			System.out.println("choosephoto is not clicking");
		}
		
	}
	
	@FindBy(xpath = "//div/input[@value='Save']")
	WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(xpath ="//div/a[@title='My Settings']")
	WebElement mySettings;
	
	public WebElement getSettings() {
		return mySettings;
	}
	
	@FindBy(xpath ="//div[@id='AutoNumber5']/div")
	List<WebElement> settingsList;
	
	public List<WebElement> getSettingsList() {
		return settingsList;
	}
	
	
	@FindBy(xpath = "//div[@id='PersonalInfo_child']/div[@class='setupLeaf']")
	List<WebElement> personalSettingMenu;
	
	public List<WebElement> getPersonalSettingMenu() {
		return personalSettingMenu;
	}
	
	@FindBy(xpath = "//a[contains(text(), '.csv file')]")
	WebElement dataIncsvFormat;
	
	public String getFormatDetails() {
		return dataIncsvFormat.getText();
	}
	
	@FindBy(xpath="//div[@id='DisplayAndLayout_child']/div[@class='setupLeaf']")
	List<WebElement> displayItems;
	
	public List<WebElement> getDisplayItems(){
		return displayItems;
	}
	
	@FindBy(xpath = "//div[@class='pShowMore']/a")
	WebElement linkToDownload;
	
	public WebElement getDownloadLink() {
		return linkToDownload;
	}
	
	@FindBy(xpath="//tbody/tr[@class='detailRow'][2]/td/select/option")
	List<WebElement> customAppOptions;
	
	public List<WebElement> getCustomeOptions(){
		return customAppOptions;
	}
	
	@FindBy(xpath = "//select[@id='duel_select_0']")
	WebElement availableTabs;
	
	public WebElement getAvailableTabs() {
		return availableTabs;
	}
	
	@FindBy(xpath = "//div[@class='zen-mbs text']/a/img[@class='rightArrowIcon']")
	WebElement addButton;
	
	public WebElement getAddButton() {
		return addButton;
	}
	
	@FindBy(xpath = "//select[@id='duel_select_1']/option")
	List<WebElement> tabsInSelectedTabs;
	
	public List<WebElement> getSelectedTabs(){
		return tabsInSelectedTabs;
	}
	
	@FindBy(xpath ="//input[@title='Save']")
	WebElement saveTabs;
	
	public WebElement getSaveTabs() {
		return saveTabs;
	}
	
	@FindBy(xpath = "//div[@class='text']/a/img[@class='leftArrowIcon']")
	WebElement removeButton;
	
	public WebElement getRemoveButton() {
		return removeButton;
	}
	
	@FindBy(xpath = "//div[@id='EmailSetup_child']/div")
	List<WebElement> emailItems;
	
	public List<WebElement> getEmailItems(){
		return emailItems;
	}
	
	@FindBy(id = "sender_name")
	WebElement emailName;
	
	public WebElement getEmailName() {
		return emailName;
	}
	
	@FindBy(id="sender_email")
	WebElement emailAddress;
	
	public WebElement getEmailAddress() {
		return emailAddress;
	}
	
	@FindBy(xpath ="//div[@class='requiredInput']/input[@type='radio'][2]")
	WebElement noRadioButton;
	
	public WebElement getRadioBtnForNo() {
		return noRadioButton;
	}
	
	@FindBy(xpath ="//div[@class='requiredInput']/input[@type='radio'][1]")
	WebElement yesRadioBtn;
	
	public WebElement getRadioBtnForYes() {
		return yesRadioBtn;
	}
	
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/child::input")
	WebElement saveButton;
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	@FindBy(xpath = "//div/a[@title='Developer Console (New Window)']")
	WebElement developerConsole;
	
	public WebElement getDevConsole() {
		return developerConsole;
	}
	
	@FindBy(xpath = "//div[@id='CalendarAndReminders_child']/div")
	List<WebElement> calenderItems;
	
	public List<WebElement> getCalenderOptions(){
		return calenderItems;
	}
	
	@FindBy(xpath = "//input[@title='Open a Test Reminder']")
	WebElement openARemainder;
	
	public WebElement getOpenRemainderBtn() {
		return openARemainder;
	}
	
	@FindBy(xpath = "//input[@name='dismiss_all']")
	WebElement dismissAllRem;
	
	public WebElement getDismissRemBtn() {
		return dismissAllRem;
	}
	
	@FindBy(xpath="//*[@title='Save']")
	WebElement saveActivity;
	
	public WebElement getSaveActivity() {
		return saveActivity;
	}
	
	
	
	
	

}
