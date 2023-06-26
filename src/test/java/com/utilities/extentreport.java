package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {
	
	public static ExtentReports generatereport() throws IOException {
		Properties prop=new Properties();
		File fileprop= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsdemoconfig\\config.properties");
		FileInputStream fisprop=new FileInputStream(fileprop);
		prop.load(fisprop);
		
		ExtentReports extentreport=new ExtentReports();
		File extentreportpath=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ereport.html");
		
		ExtentSparkReporter sparkreport=new ExtentSparkReporter(extentreportpath);
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("Tutorial test automation report");
		sparkreport.config().setDocumentTitle("Extent Report for Tutorialninja");
		sparkreport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkreport);
		
		extentreport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentreport.setSystemInfo("BrowserName", prop.getProperty("browser"));
		extentreport.setSystemInfo("Author", prop.getProperty("Author"));		
		extentreport.setSystemInfo("Email", prop.getProperty("validemail"));
		extentreport.setSystemInfo("password", prop.getProperty("Rohini96@#"));
		extentreport.setSystemInfo("OS NAme", System.getProperty("os.name"));		
		extentreport.setSystemInfo("java version", System.getProperty("java.version"));
		extentreport.setSystemInfo("username", System.getProperty("user.name"));
		
		return extentreport;
		
	}

}
