package testCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.LoginPage;
import com.Util.PropertiesFile;
import com.config.DriverPathConfig;
import com.config.Path;

public class TC01
{
	DriverPathConfig lpage = new DriverPathConfig();
	WebDriver driver;
	LoginPage login1;
	FileInputStream propFile;
	Properties pr;
	PropertiesFile pf;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		driver = lpage.BrowserConfig();
		driver.get(Path.loginURL);
		
		login1 = new LoginPage(driver);
		
		pf = new PropertiesFile();
		
	//	pr = new Properties();
	//	propFile = new FileInputStream(Path.prop);
		
	
	}
	
	
	@BeforeMethod
	public void pageRefresh() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	//FT_300_01 - Verify Flipkart login page by passing valid username and valid password test box
	@Test(enabled=false)
	public void ValUnameValPWD() throws InterruptedException
	{
	
		login1.loginPageUsername("9850350719");
		Thread.sleep(500);
		
		login1.loginPagePWD("Welcome@001");
		Thread.sleep(500);
		
		login1.loginPageSubmit();
		Thread.sleep(1000);
	}
	
	//FT_300_02 - Verify Flipkart login page by passing valid username and invalid password
	@Test(enabled=false)
	public void ValUnameInvPWD() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("9850350719");
		Thread.sleep(500);
		
		login1.loginPagePWD("abcdef");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamdPWDmsg();
		System.out.println(actualErrorText);
		
		String expectedErrorText = "Your username or password is incorrect";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	//FT_300_03 - Verify Flipkart login page by passing invalid username and valid password
	@Test(enabled=false)
	public void InvUnameValPWD() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("irshadtelsang");
		Thread.sleep(500);
		
		login1.loginPagePWD("Welcome@001");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamdPWDmsg();
		String expectedErrorText = "Your username or password is incorrect";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	//FT_300_04 - Verfiy Flipkart login page by passing invalid username and invalid password
	@Test(priority = 1)
	public void InvUnameInvPWD() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("98509");
		Thread.sleep(500);
		
		login1.loginPagePWD("ab3434cdef");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamemsg();
		// System.out.println("Error on page: " +actualErrorText);
		String expectedErrorText = "Please enter valid Email ID/Mobile number";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	//FT_300_05 - Verfiy Flipkart login page by passing blank username and blank password
	@Test(priority = 2)
	public void BlnkUnameBlnkPWD() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("");
		Thread.sleep(500);
		
		login1.loginPagePWD("");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamemsg();
		// System.out.println("Error on page: "+ actualErrorText);
		
		String expectedErrorText = "Please enter valid Email ID/Mobile number";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	//FT_300_06- Verify Flipkart login page by passing valid username and blank password
	@Test(priority = 3)
	public void ValUnameBlnkPWD() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("9850350719");
		Thread.sleep(500);
		
		login1.loginPagePWD("");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidPWDmsg();
		// System.out.println(actualErrorText);
		String expectedErrorText = "Please enter Password";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	
	//FT_300_07 - Verify Flipkart login page by passing blank username and valid password
	@Test(priority = 4)
	public void BlnkUnameValPWD() throws InterruptedException
	{
	
		login1.loginPageUsername("");
		Thread.sleep(500);
		
		//Call password method and pass password as argument
		login1.loginPagePWD("Welcome@001");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamemsg();
		String expectedErrorText = "Please enter valid Email ID/Mobile number";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	
	//FT_300_08 - Verfiy Flipkart login page login button is functional or not by passing blank username and blank password
	@Test(priority = 5)
	public void BlnkUnameBlnkPWD2() throws InterruptedException
	{
		//Call user name method and pass username as argument
		login1.loginPageUsername("");
		Thread.sleep(500);
		
		login1.loginPagePWD("");
		Thread.sleep(500);
		
		//call method to click submit button
		login1.loginPageSubmit();
		Thread.sleep(1000);
		
		//Call method LogininvalidPWDmsg to get the error message on webpage
		String actualErrorText = login1.LogininvalidUnamemsg();
		// System.out.println("Error on page: " + actualErrorText);
		String expectedErrorText = "Please enter valid Email ID/Mobile number";
		
		//compare the webpage error message with given error message
		Assert.assertEquals(actualErrorText, expectedErrorText);
	}
	
	//FT_300_09 - Verfiy Flipkart login page login button is functional or not by passing valid username and valid password
	@Test(priority = 6)
	public void ValUnameValPWD2() throws InterruptedException
	{
		login1.loginPageUsername("9850350719");
		Thread.sleep(500);
		
		login1.loginPagePWD("Welcome@001");
		Thread.sleep(500);
		
		login1.loginPageSubmit();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		String actualURL = driver.getCurrentUrl();
		String expectedtURL = "https://www.flipkart.com/";
		
		Assert.assertEquals(actualURL, expectedtURL);
	}
	
	
	@Test
	public void ReadPropertiesFile() throws IOException
	{
		String value1 = pf.ReadPropertyFileContents("URL");
	//	pr.load(propFile);
	//	String value = pr.getProperty("URL");
		System.out.println("Properties data: " + value1);
	}
	
}