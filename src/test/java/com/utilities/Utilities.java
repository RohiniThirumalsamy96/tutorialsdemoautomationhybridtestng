package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.base.base;

public class Utilities {
	
	public static String getuniqueemail() {
		Date dt=new Date();
		String date =dt.toString().replace(" ", "--").replace(":","--");
		return "rohinirose"+date+"@gamil.com";
	}
	
	public static final int implicitwaittime=50;
	public static final int pageloadtime=50;
	
	public static Object[][] getdatafromexcel(String Sheetname) throws IOException {
		
		File Excelfile=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tutorialtestdata\\Testdata.xlsx");
		FileInputStream excelinputstream = null;
		try {
			excelinputstream= new FileInputStream(Excelfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb= new XSSFWorkbook(excelinputstream);
		XSSFSheet sheet = wb.getSheet(Sheetname);
		int rowsize=sheet.getLastRowNum();
		int colsize=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowsize][colsize];
		for(int i=0;i<rowsize;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<colsize;j++) {
				XSSFCell cell = row.getCell(j);
				 switch(cell.getCellType()) {
				 case Cell.CELL_TYPE_STRING:
					 data[i][j]=cell.getStringCellValue();
					 break;
				 case Cell.CELL_TYPE_NUMERIC:
					 //here we will get data in form of double from excel but its numberic so convert to int ad then to string because we
					 //we need enter them in email as string
					 data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					 break;
					 
				 case Cell.CELL_TYPE_BOOLEAN:
					 data[i][j]=cell.getBooleanCellValue();
					 break;
					 
				 }
			}
			
		}
		
		return data;
		
	}
	
	public static String capturescreenshot(WebDriver driver,String testname) {
		

		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		Date dt=new Date();
		String date =dt.toString().replace(" ", "--").replace(":","--");
		String Filepath=System.getProperty("user.dir")+"\\Errorscreenshot\\"+testname+date+".png";
		try {
			FileHandler.copy(src, new File(Filepath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Filepath;
		
	}
	
	

}
