package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQA 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Chrome Driver\\chrome 97\\chromedriver.exe");
		WebDriver drv = new ChromeDriver();
		
		drv.get("https://demoqa.com");
		
		drv.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(5000);
		
		
		drv.findElement(By.xpath("//div[contains(text(),'Elements')]")).click();
		
	}

}
