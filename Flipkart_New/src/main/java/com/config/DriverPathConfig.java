package com.config;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverPathConfig
{
	public static WebDriver drv1;
	public static Workbook book;

	public static WebDriver BrowserConfig()
	{
		System.setProperty("webdriver.chrome.driver", Path.driverpath);
		drv1 = new ChromeDriver();

		return drv1;
	}

	public void ScreenshotTakerMethod()
	{	
		Date dt = new Date();
		String date = dt.toString();
		date = date.replace(":", "_");
		
		File src = ((TakesScreenshot) drv1).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Jazz\\git\\Flipkart_New\\Flipkart_New\\Screenshots\\Screenshot"+date+".jpeg");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public Object[][] getExcelSheetData(String sheetname)
	{
		File f1 = new File(Path.excelpath);
		try 
		{
			book = WorkbookFactory.create(f1);
		} 
		catch (EncryptedDocumentException e) 
		{	
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Sheet sh = book.getSheet(sheetname);
		
		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for(int k=0; k<sh.getRow(0).getLastCellNum(); k++)
			{
				XSSFCell celldata = (XSSFCell) sh.getRow(i).getCell(k);
			//	System.out.println("type of cell is: " + celldata.getCellType());
				CellType celltype = celldata.getCellType();
				
				String cellidfy = celltype.toString();
				data[i][k] = sh.getRow(i+1).getCell(k).toString();
			//	data[i][k] = sh.getRow(i+1).getCell(k).getStringCellValue();
				
//				if (cellidfy.equals("STRING"))
//				{
//					data[i][k] = sh.getRow(i+1).getCell(k).toString();
//				}
//				else if (cellidfy.equals("NUMERIC"))
//				{
//					data[i][k] = sh.getRow(i+1).getCell(k).getNumericCellValue();
//				}
			}
		}
		
		return data;
		
	}
	
}
