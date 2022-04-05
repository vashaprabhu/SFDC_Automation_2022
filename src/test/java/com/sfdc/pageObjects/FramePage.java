package com.sfdc.pageObjects;

import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
	
WebDriver ldriver;
	
	public FramePage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement frame1;
	
	public WebDriver frameHandling1() {
		ldriver.switchTo().frame(frame1);
		return ldriver;
		
	}
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement frame2;
	
	public WebDriver frameHandling2() {
		ldriver.switchTo().frame(frame2);
		return ldriver;
	}
	
	public WebDriver backFromFrame2() {
		ldriver.switchTo().defaultContent();
		return ldriver;
	}

}
