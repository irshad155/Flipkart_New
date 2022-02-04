package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Util.PropertiesFile;
import com.config.Path;

public class PropFileDemo 
{
	public static void main(String[] args) throws IOException 
	{
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", Path.driverpath);
		WebDriver drv1 = new ChromeDriver(option);
		drv1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		drv1.get(PropertiesFile.ReadPropertyFileContents("URL"));
	
	}
	

}
