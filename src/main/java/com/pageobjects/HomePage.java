package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccountdropdownmenu;
	
	@FindBy(linkText="Login")
	private WebElement clickonaccount;
	
	@FindBy(linkText="Register")
	private WebElement clickonregister;
	
	@FindBy(name="search")
	private WebElement searchboxfeild;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchboxbutton;
	
	
	
	//initialize the webelement once we come to this page
	public HomePage(WebDriver driver) {
		this.driver=driver;
		//initialize the driver and this complete howmpage webelement using - this
		PageFactory.initElements(driver, this);
		
		
	}
	
	//methods using them
	
	
	
	public Loginpage selectloginoption() {
		myaccountdropdownmenu.click();
		clickonaccount.click();
		return new Loginpage(driver);
	}
	public RegisterPage selectregisteroption() {
		myaccountdropdownmenu.click();
		clickonregister.click();
		return new RegisterPage(driver);
	}
	public Searchpage enterproddetails(String name) {
		searchboxfeild.sendKeys(name);
		searchboxbutton.click();
		return new Searchpage(driver);
		
	}
	
	public Searchpage clicksearchbox() {
		searchboxbutton.click();
		return new Searchpage(driver);
	}
	
	
	
}
