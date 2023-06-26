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
import org.testng.annotations.Test;

import com.base.base;
import com.pageobjects.Accountpage;
import com.pageobjects.HomePage;
import com.pageobjects.RegisterPage;
import com.utilities.Utilities;

public class RegisterTest extends base  {
	public WebDriver driver;
	RegisterPage registerpage;
	Accountpage accountpage;
	public RegisterTest() {
		try {
			super.base();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void browsersetup() {
		driver=setupbrowser(prop.getProperty("browser"));
		HomePage homepage=new HomePage(driver);
		registerpage=homepage.selectregisteroption();
	}
	
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	@Test(priority=1)
	public void verifyregisterwithmandatoryfeilds() {
		
		registerpage.enterfirstname(dataprop.getProperty("firstname"));
		registerpage.enterlastname(dataprop.getProperty("lastname"));
		registerpage.enteremail(Utilities.getuniqueemail());
		registerpage.entertelephone(dataprop.getProperty("telephone"));
		registerpage.enterpass(prop.getProperty("validpass"));
		registerpage.enterconfirmpass(prop.getProperty("validpass"));
		registerpage.clickpolicy();
		accountpage=registerpage.clickcontinue();
		
		Assert.assertTrue(registerpage.verifysuccessloginwarning(),"Sucessfully registered");
		
		
	}

	@Test(priority=2)
	public void verifyregisterwithallfeilds() {
		registerpage.enterfirstname(dataprop.getProperty("firstname"));
		registerpage.enterlastname(dataprop.getProperty("lastname"));
		registerpage.enteremail(Utilities.getuniqueemail());
		registerpage.entertelephone(dataprop.getProperty("telephone"));
		registerpage.enterpass(prop.getProperty("validpass"));
		registerpage.enterconfirmpass(prop.getProperty("validpass"));
		registerpage.subscribenews();
		registerpage.clickpolicy();
		accountpage=registerpage.clickcontinue();
		
		Assert.assertTrue(registerpage.verifysuccessloginwarning(),"Sucessfully registered");
		
	}
	
	@Test(priority=3)
	public void verifyregisterwithexistingemail() {
		
		registerpage.enterfirstname(dataprop.getProperty("firstname"));
		registerpage.enterlastname(dataprop.getProperty("lastname"));
		registerpage.enteremail(prop.getProperty("validemail"));
		registerpage.entertelephone(dataprop.getProperty("telephone"));
		registerpage.enterpass(prop.getProperty("validpass"));
		registerpage.enterconfirmpass(prop.getProperty("validpass"));
		registerpage.subscribenews();
		registerpage.clickpolicy();
		accountpage=registerpage.clickcontinue();
		
		Assert.assertTrue(registerpage.verifyduplicateaccountregisterwarning(),"already Sucessfully registered");
				
		
		
	}
	
	@Test(priority=4)
	public void verifyregisterwithoutgivingdetails() {
		accountpage=registerpage.clickcontinue();
		
		
		Assert.assertTrue(registerpage.checkallwarning(),"unable to register");
		
		
		
	}
}
