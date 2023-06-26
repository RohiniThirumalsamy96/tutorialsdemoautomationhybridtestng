package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {

WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement accountpageinformation;
	
	public Accountpage(WebDriver driver) {
		this.driver=driver;
		//initialize the driver and this complete howmpage webelement using - this
		PageFactory.initElements(driver, this);
		
		
	}
	
	public boolean Accountpageverification() {
		boolean statuscheck=accountpageinformation.isDisplayed();
		return  statuscheck;
	}
	
	
}
