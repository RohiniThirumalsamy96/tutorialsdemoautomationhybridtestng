package com.tutorialsqa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.base;
import com.pageobjects.HomePage;
import com.pageobjects.Searchpage;

public class SearchTest extends base{
		public WebDriver driver;
		Searchpage searchpage;
		HomePage homepage;
		public SearchTest() {
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
		homepage=new HomePage(driver);
	}
	
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifysearchwithvalidprod() {
		
		
		
		searchpage=homepage.enterproddetails(dataprop.getProperty("validprod"));
		Assert.assertTrue(searchpage.productavailable());
		
	}
	
	@Test(priority=2)
	public void verifysearchwithinvalidprod() {
		
		
		
		searchpage=homepage.enterproddetails(dataprop.getProperty("invalidprod"));
		Assert.assertTrue(searchpage.invalidprod());
		
	}
	
	@Test(priority=3,dependsOnMethods= {"verifysearchwithinvalidprod"})
	public void verifysearchwithoutprodname() {
		

		
		searchpage=homepage.clicksearchbox();
		Assert.assertTrue(searchpage.invalidprod());
	}
	
	

}
