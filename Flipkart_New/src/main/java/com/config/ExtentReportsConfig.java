package com.config;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsConfig 
{
	public static void main(String[] args) 
	{
		ExtentHtmlReporter extnreport = new ExtentHtmlReporter("flipkartextentreport.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		ExtentReportsConfig extent = new ExtentReportsConfig();
		
		//attach report
//		extent.attachReporter(extnreport);

	}

}
