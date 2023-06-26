package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement pass;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningmesage;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;

	public Loginpage(WebDriver driver) {
		this.driver=driver;
		//initialize the driver and this complete howmpage webelement using - this
		PageFactory.initElements(driver, this);
		
		
	}
	/*
	public void enteremail(String emailget) {
		email.sendKeys(emailget);
	}
	
	public void enterpass(String passwordget) {
		pass.sendKeys(passwordget);
	}
	*/
	
	public Accountpage clicklogin() {
		loginbutton.click();
		return new Accountpage(driver);
	}
	
	public boolean waningmessage() {
		boolean statusinvalidlogin=warningmesage.getText().contains("Warning: No match for E-Mail Address and/or Password.");
		return statusinvalidlogin;
	}
	
	//we can combine locators like this i am doing only for login page
	public void enteremailandpass(String emailget,String passwordget) {
		email.sendKeys(emailget);
		pass.sendKeys(passwordget);
	}
	
	
}
