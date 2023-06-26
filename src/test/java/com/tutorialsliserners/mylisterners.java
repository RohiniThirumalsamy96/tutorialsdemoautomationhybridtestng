package com.tutorialsliserners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.base;
import com.google.common.io.Files;
import com.utilities.Utilities;
import com.utilities.extentreport;

public class mylisterners implements ITestListener{
	ExtentReports extreport;
	ExtentTest extenttest ;
	String testname;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Exceution started");
		try {
			extreport=extentreport.generatereport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestStart(ITestResult result) {
		testname=result.getName();
		extenttest = extreport.createTest(testname);
		extenttest.log(Status.INFO, testname+"Exceution on test Start");
		System.out.println(testname+"Exceution on test Start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extenttest.log(Status.PASS, testname+"Exceution is passed");
		System.out.println(testname+"Exceution is passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		System.out.println(testname+"Exceution failed");
		
		extenttest.log(Status.INFO, result.getThrowable());
		
		//to get the failure details
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String Filepath =Utilities.capturescreenshot(driver,testname);
			extenttest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Filepath, "login checkfail").build());
			
			/*
			 * File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			Date dt=new Date();
			String date =dt.toString().replace(" ", "--").replace(":","--");
			String Filepath=System.getProperty("user.dir")+"\\Errorscreenshot\\"+testname+date+".png";
			try {
				FileHandler.copy(src, new File(Filepath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extenttest.addScreenCaptureFromPath(Filepath);
			extenttest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Filepath, "login checkfail").build());
			*/
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		extenttest.log(Status.FAIL, testname+"failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(testname+"Exceution skipped");
		//reason for skip
		System.out.println(result.getThrowable());
		extenttest.log(Status.SKIP, testname+"Exceution is skipped");
		extenttest.log(Status.INFO, result.getThrowable());
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Exceution finished");
		extreport.flush();
		File getEreport=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ereport.html");
		try {
			Desktop.getDesktop().browse(getEreport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
