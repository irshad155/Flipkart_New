package com.Util;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.config.DriverPathConfig;

public class CustomListner extends DriverPathConfig implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{		
		ScreenshotTakerMethod();
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		ScreenshotTakerMethod();
	}
}
