package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	
	@FindBy(linkText="HP LP3065")
	private WebElement validprodwarn;
	
	@FindBy(xpath="//div[@id='content']/h2/following::p[1]")
	private WebElement invalidprodwarn;

	WebDriver driver;
	
	public Searchpage(WebDriver driver) {
		this.driver=driver;
		//initialize the driver and this complete howmpage webelement using - this
		PageFactory.initElements(driver, this);
		
		
	}

	
	public boolean productavailable() {
		boolean statuscheck=validprodwarn.isDisplayed();
		return statuscheck;
	}
	
	public boolean invalidprod() {
		boolean statuscheck=false;
				//invalidprodwarn.getText().contains("There is no product that matches the search criteria.");
		return statuscheck;
	}
	
	
}
