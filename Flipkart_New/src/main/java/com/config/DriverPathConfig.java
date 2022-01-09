package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPathConfig
{
	public WebDriver drv1;


	public WebDriver BrowserConfig()
	{
		System.setProperty("webdriver.chrome.driver", Path.driverpath);
		drv1 = new ChromeDriver();

		return drv1;
	}
}
