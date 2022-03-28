package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.config.DriverPathConfig;

public class ExcelPrint 
{
	DriverPathConfig drconfig = new DriverPathConfig();
	
	@DataProvider
	public Object[][] readexceldata()
	{
		Object[][] data = drconfig.getExcelSheetData("UserDetails");
		return data;
	}
	
	@Test(dataProvider="readexceldata")
	public void reade(String username, String passw, String email, String city)
	{
		System.out.println(username);
		System.out.println(passw);
		System.out.println(email);
		System.out.println(city);
		System.out.println();
		
	}
	
//	@AfterMethod
//	public void pagerefresh()
//	{
//		System.out.println("Page has been refreshed");
//	}
//	
	
}
