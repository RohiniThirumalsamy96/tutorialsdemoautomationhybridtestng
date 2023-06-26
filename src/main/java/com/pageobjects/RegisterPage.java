package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {
	
WebDriver driver;


	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;
	
	@FindBy(name="agree")
	private WebElement policyagree;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement contin;
	
	@FindBy(xpath="//div[@id='content']//h1")
	private WebElement accountsucesswarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement accountduplicatewarning;
	
	@FindBy(xpath="//input[@name='newsletter']")
	private WebElement subscription;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement policywarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following::div[1]")
	private WebElement firstwarn;
	
	@FindBy(xpath="//input[@id='input-lastname']/following::div[1]")
	private WebElement lastnamewarn;
	
	@FindBy(xpath="//input[@id='input-email']/following::div[1]")
	private WebElement emailwarn;
	
	@FindBy(xpath="//input[@id='input-telephone']/following::div[1]")
	private WebElement telephonewarn;
	
	@FindBy(xpath="//input[@id='input-password']/following::div[1]")
	private WebElement passwordwarn;
	
		
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}

	
	public void enterfirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void enteremail(String emailget) {
		email.sendKeys(emailget);
	}
	public void entertelephone(String no) {
		telephone.sendKeys(no);
	}
	public void enterpass(String epass) {
		password.sendKeys(epass);
	}
	public void enterconfirmpass(String cpass) {
		confirmpassword.sendKeys(cpass);
	}
	public void clickpolicy() {
		policyagree.click();
	}
	public Accountpage clickcontinue() {
		contin.click();
		return new Accountpage(driver);
	}
	public boolean verifysuccessloginwarning() {
		boolean statuscheck=accountsucesswarning.getText().contains("Your Account Has Been Created!");
		return statuscheck;
	}
	public void subscribenews() {
		subscription.click();
	}
	
	public boolean verifyduplicateaccountregisterwarning() {
		boolean statuscheck=accountduplicatewarning.getText().contains("Warning: E-Mail Address is already registered!");
		return statuscheck;
	}
	/*
	 * combines all this warning to single method - like this we can do for above as well
	 * 
	public boolean policywarning() {
		boolean statuscheck=policywarning.getText().contains("Warning: You must agree to the Privacy Policy!");
		return statuscheck;
	}
	
	public boolean firstnamewarning() {
		boolean statuscheck=firstwarn.getText().contains("First Name must be between 1 and 32 characters!");
		return statuscheck;
	}
	
	public boolean lastnamewarning() {
		boolean statuscheck=lastnamewarn.getText().contains("Last Name must be between 1 and 32 characters!");
		return statuscheck;
	}
	
	public boolean emailwarning() {
		boolean statuscheck=emailwarn.getText().contains("E-Mail Address does not appear to be valid!");
		return statuscheck;
	}
	
	public boolean telephonewarning() {
		boolean statuscheck=telephonewarn.getText().contains("Telephone must be between 3 and 32 characters!");
		return statuscheck;
	}
	
	public boolean passwordwarning() {
		boolean statuscheck=passwordwarn.getText().contains("Password must be between 4 and 20 characters!");
		return statuscheck;
	}
	*/
	
	public boolean checkallwarning() {
		boolean statuscheck=policywarning.getText().contains("Warning: You must agree to the Privacy Policy!");
		boolean statuscheck1=firstwarn.getText().contains("First Name must be between 1 and 32 characters!");
		boolean statuscheck2=lastnamewarn.getText().contains("Last Name must be between 1 and 32 characters!");
		boolean statuscheck3=emailwarn.getText().contains("E-Mail Address does not appear to be valid!");
		boolean statuscheck4=telephonewarn.getText().contains("Telephone must be between 3 and 32 characters!");
		boolean statuscheck5=passwordwarn.getText().contains("Password must be between 4 and 20 characters!");

		return statuscheck && statuscheck1 &&statuscheck2 && statuscheck3 && statuscheck4 && statuscheck5;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

	


}
