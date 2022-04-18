package com.sfdc.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReusableUtilities {
	
	public WebDriver driver;
	
	public void clickOnItemOfList(List<WebElement> webelementList, String item) {
		for(WebElement set :webelementList ) {
			if(set.getText().equalsIgnoreCase(item)) {
				try{
					set.click();
					break;
				}catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
		}
	}
	
	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickOnWebElement(WebElement element) {
		element.click();
	}
	
	public void mouseHovarClick(WebDriver driver, WebElement moveTill, WebElement clickOn) {
		Actions action = new Actions(driver);
		action.moveToElement(moveTill).build().perform();
		if(clickOn.isDisplayed()) {
			clickOn.click();
		}
	}
	
	public void setValueToElement(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public boolean listHasItem(List<WebElement> elementList, String item) {
		boolean hasItem = false;
		for(WebElement it : elementList) {
			if(it.getText().equalsIgnoreCase(item)) {
				hasItem = true;
			}else {
				hasItem = false;
			}
		}
		return hasItem;
	}


}
