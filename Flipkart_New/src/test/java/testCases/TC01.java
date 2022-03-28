package testCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POM.LoginPage;
import com.Util.PropertiesFile;
import com.Util.CustomListner;
import com.config.DriverPathConfig;
import com.config.Path;

@Listeners(CustomListner.class)
public class TC01
{
	DriverPathConfig lpage = new DriverPathConfig();
	WebDriver driver;
	LoginPage login1;
	FileInputStream propFile;
	Properties pr;
	PropertiesFile pf;
	CustomListner sc;
	
	@BeforeClass(enabled=true)
	public void openBrowser() throws IOException
	{
		driver = lpage.BrowserConfig();
		driver.get(Path.loginURL);
		
		login1 = new LoginPage(driver);
		
		pf = new PropertiesFile();
		
		sc = new CustomListner();
		
	//	pr = new Properties();
	//	propFile = new FileInputStream(Path.prop);	
	}
		
//	@BeforeMethod(enabled=true)
//	public void pageRefresh() throws InterruptedException
//	{
//		driver.navigate().refresh();
//		Thread.sleep(1000);
//	}
	
	@AfterMethod
	public void pageRefresh() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "LTestData")
	public Object[][] loginTestData()
	{	
		Object[][] data = lpage.getExcelSheetData("Login");
		
		return data;
	}
	
	@Test(dataProvider = "LTestData")
	public void logintest01(String usname, String pass) throws InterruptedException
	{		
		login1.loginPageUsernamePWD(usname, pass);
	
		Thread.sleep(5000);
		login1.loginPageSubmit();
		Thread.sleep(5000);
	
//		String actURL = driver.getCurrentUrl();
//		String expURL = "https://www.flipkart.com/";
//		
//		//Verify the test case pass or fail
//		Assert.assertEquals(actURL, expURL, "Test case failed, user not logged in");
		
//		driver.quit();
		
	}
	
	
//	//FT_300_01 - Verify Flipkart login page by passing valid username and valid password test box
//	@Test(enabled=false)
//	public void ValUnameValPWD() throws InterruptedException
//	{
//	
//		login1.loginPageUsernamePWD("9850350719","Welcome@001");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("Welcome@001");
////		Thread.sleep(500);
//		
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		String actURL = Path.loginURL;
//		String expURL = "https://www.flipkart.com/aaaaaa";
//		
//		//Verify the test case pass or fail
//		Assert.assertEquals(actURL, expURL, "Test case failed, user not logged in");
//		
//	}
//	//FT_300_02 - Verify Flipkart login page by passing valid username and invalid password
//	@Test(enabled=true, priority=1)
//	public void ValUnameInvPWD() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("9850350719", "abcdef");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("abcdef");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamdPWDmsg();
//		String expectedErrorText = "Yours username or password is incorrect";
//		
//		//Verify the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText, "Error message does not match with expected error");
//	}
//	
//	//FT_300_03 - Verify Flipkart login page by passing invalid username and valid password
//	@Test(enabled=true, priority=2)
//	public void InvUnameValPWD() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("irshadtelsang", "Welcome@001");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("Welcome@001");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamdPWDmsg();
//		String expectedErrorText = "Your username or password is incorrect";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	//FT_300_04 - Verfiy Flipkart login page by passing invalid username and invalid password
//	@Test(priority = 3, enabled=true)
//	public void InvUnameInvPWD() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("98509","ab3434cdef");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("ab3434cdef");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamemsg();
//		//System.out.println("Error on page: " +actualErrorText);
//		String expectedErrorText = "Please enter valid Email ID/Mobile number";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	//FT_300_05 - Verfiy Flipkart login page by passing blank username and blank password
//	@Test(priority = 4, enabled=true)
//	public void BlnkUnameBlnkPWD() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("","");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamemsg();
//		// System.out.println("Error on page: "+ actualErrorText);
//		
//		String expectedErrorText = "Please enter valid Email ID/Mobile number";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	//FT_300_06- Verify Flipkart login page by passing valid username and blank password
//	@Test(priority = 5, enabled=true)
//	public void ValUnameBlnkPWD() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("9850350719","");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidPWDmsg();
//		// System.out.println(actualErrorText);
//		String expectedErrorText = "Please enter Password";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	
//	//FT_300_07 - Verify Flipkart login page by passing blank username and valid password
//	@Test(priority = 6, enabled=true)
//	public void BlnkUnameValPWD() throws InterruptedException
//	{
//	
//		login1.loginPageUsernamePWD("","Welcome@001");
//		Thread.sleep(500);
//		
//		//Call password method and pass password as argument
////		login1.loginPagePWD("Welcome@001");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamemsg();
//		String expectedErrorText = "Please enter valid Email ID/Mobile number";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	
//	//FT_300_08 - Verfiy Flipkart login page login button is functional or not by passing blank username and blank password
//	@Test(priority = 7, enabled=true)
//	public void BlnkUnameBlnkPWD2() throws InterruptedException
//	{
//		//Call user name method and pass username as argument
//		login1.loginPageUsernamePWD("","");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("");
////		Thread.sleep(500);
//		
//		//call method to click submit button
//		login1.loginPageSubmit();
//		Thread.sleep(1000);
//		
//		//Call method LogininvalidPWDmsg to get the error message on webpage
//		String actualErrorText = login1.LogininvalidUnamemsg();
//		// System.out.println("Error on page: " + actualErrorText);
//		String expectedErrorText = "Please enter valid Email ID/Mobile number";
//		
//		//compare the webpage error message with given error message
//		Assert.assertEquals(actualErrorText, expectedErrorText);
//	}
//	
//	//FT_300_09 - Verfiy Flipkart login page login button is functional or not by passing valid username and valid password
//	@Test(priority = 8, enabled=true)
//	public void ValUnameValPWD2() throws InterruptedException
//	{
//		login1.loginPageUsernamePWD("9850350719","Welcome@001");
//		Thread.sleep(500);
//		
////		login1.loginPagePWD("Welcome@001");
////		Thread.sleep(500);
//		
//		login1.loginPageSubmit();
//		Thread.sleep(3000);
//		
//		driver.navigate().refresh();
//		
//		String actualURL = driver.getCurrentUrl();
//		String expectedtURL = "https://www.flipkart.com/";
//		
//		Assert.assertEquals(actualURL, expectedtURL);
//	}
//	
//	
//	@Test(enabled=false)
//	public void ReadPropertiesFile() throws IOException
//	{
//		String value1 = PropertiesFile.ReadPropertyFileContents("URL");
//	//	pr.load(propFile);
//	//	String value = pr.getProperty("URL");
//		System.out.println("Properties data: " + value1);
//	}
	
}