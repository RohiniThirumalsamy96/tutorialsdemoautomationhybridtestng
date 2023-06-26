package com.tutorialsqa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.base;
import com.pageobjects.Accountpage;
import com.pageobjects.HomePage;
import com.pageobjects.Loginpage;
import com.utilities.Utilities;

import java.util.Date;


public class LoginTest extends base{
	public WebDriver driver;
	Loginpage loginpage;
	public LoginTest() {
		try {
			super.base();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void browsersetup() throws IOException {
		driver=setupbrowser(prop.getProperty("browser"));
		
		HomePage homepage=new HomePage(driver);
		//to move to login page
		loginpage=homepage.selectloginoption();

		
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	@Test(priority=1,dataProvider="login")
	public void verifyloginwithvalidcredentials(String email,String pass) {
		loginpage.enteremailandpass(email, pass);
		Accountpage accountpage=loginpage.clicklogin();
		
		Assert.assertTrue(accountpage.Accountpageverification(),dataprop.getProperty("successloginmessage"));
		
	}
	@DataProvider(name="login")
	public Object[][] suplydata() throws IOException {
		//getdatafromexcel is a static method we will call with classname
		Object[][] data = Utilities.getdatafromexcel("Login");
		
		
		return data;
		
	}
	@Test(priority=2)
	public void verifyinvlaidlogincredentials() {
		loginpage.enteremailandpass(Utilities.getuniqueemail(), dataprop.getProperty("inavlidpass"));
		Accountpage accountpage=loginpage.clicklogin();
		
		Assert.assertTrue(loginpage.waningmessage(),"unabel to loigin with invalid cred");
		
	}
	
	@Test(priority=3)
	public void verifyinvlaidemailandvalidpass() {
		loginpage.enteremailandpass(Utilities.getuniqueemail(), prop.getProperty("validpass"));
		
		loginpage.clicklogin();
		
		Assert.assertTrue(loginpage.waningmessage(),"unabel to loigin with invalid cred");
		
	}
	@Test(priority=4)
	public void verifyvlaidemailandinvalidpass() {
		
		loginpage.enteremailandpass(prop.getProperty("validemail"),dataprop.getProperty("inavlidpass"));
		loginpage.clicklogin();
		
		Assert.assertTrue(loginpage.waningmessage(),"unabel to loigin with invalid cred");
		
	}
	
	@Test(priority=5)
	public void verifywthoutcred() {
		
		loginpage.clicklogin();
		
		Assert.assertTrue(loginpage.waningmessage(),"unabel to loigin with invalid cred");
		
		
		
	}
	
	
	

}
