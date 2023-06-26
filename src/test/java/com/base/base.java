package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.Utilities;

public class base {
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public WebDriver setupbrowser(String browsername) {
		

		if(browsername.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(browsername.equalsIgnoreCase("chrome")) {
			driver=new FirefoxDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitwaittime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageloadtime));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
	
	public void base() throws IOException {
		prop=new Properties();
		dataprop= new Properties(); 
		File file= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsdemoconfig\\config.properties");
		File datafile= new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialtestdata\\Testdata.properties");
		FileInputStream fis1= new FileInputStream(datafile);
		dataprop.load(fis1);
		
		try {
			FileInputStream fis= new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String screenshot() throws IOException {
		setupbrowser("chrome");
		Date d= new Date();
		String testname=d.toString().replace(" ","--").replace(":","--");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"\\ErrorScreenshot\\"+testname+".png");
		//copy file is missing we have to add it
		return des.getAbsolutePath();
		
		
	}
		
		

}
