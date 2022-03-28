package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POM.AddToCart;
import com.POM.LoginPage;
import com.Util.CustomListner;
import com.config.DriverPathConfig;
import com.config.Path;

@Listeners(CustomListner.class)
public class AddToCartTC01
{
	DriverPathConfig mpage = new DriverPathConfig();
	WebDriver driver2;
	LoginPage lpage2;
	AddToCart addcart;
	TC01 loginmethod;

	@BeforeClass
	public void openBrowser2() throws InterruptedException
	{
		driver2 = mpage.BrowserConfig();
		driver2.get(Path.loginURL);
		Thread.sleep(4000);
		
		lpage2 = new LoginPage(driver2);
		addcart = new AddToCart(driver2);
	
	}
	
	@Test(priority=1)
	public void loginmethod() throws InterruptedException
	{
		lpage2.loginPageUsernamePWD("9850350719","Welcome@001");
		Thread.sleep(500);
		
		lpage2.loginPageSubmit();
		Thread.sleep(1000);
		
		String actURL = Path.loginURL;
		String expURL = "https://www.flipkart.com/";
		
		//Verify the test case pass or fail
		Assert.assertEquals(actURL, expURL, "Test case failed, user not logged in");
	}

	@Test(priority=2)
	public void SearchAndAddToCart() throws InterruptedException
	{
		Thread.sleep(3000);
		addcart.SearchProd("realme mobile");
		Thread.sleep(500);
	
		addcart.SearchSubmitBtn();
		Thread.sleep(500);
	
		Thread.sleep(5000);
		addcart.SelectProduct1();
		
		Thread.sleep(5000);
		Set<String> totalbrowsers = driver2.getWindowHandles();
		System.out.println("total open windows :" + totalbrowsers.size());
		
		Iterator<String> tab = totalbrowsers.iterator();
		while(tab.hasNext())
		{
		String mainwind = tab.next();
		String childwind = tab.next();
		
		driver2.switchTo().window(childwind);
		Thread.sleep(1000);
		addcart.AddProtToCart();
		
		
	}
}

}