package com.config;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DriverPathConfig
{
	public static WebDriver drv1;

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
}
