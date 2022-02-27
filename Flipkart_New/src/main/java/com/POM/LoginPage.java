package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
//Declaration
@FindBy(xpath="(//input[@type='text'])[2]") private WebElement Uname;

@FindBy(xpath="//input[@type='password']") private WebElement pwd;
@FindBy(xpath="(//button[@type='submit'])[2]") private WebElement loginButton;

@FindBy(xpath="//span[contains(text(),'Please enter Password')]") private WebElement invalidPWDmsg;
@FindBy(xpath="//span[contains(text(),'Please enter valid Email ID/Mobile number')]") private WebElement invalidUnamemsg;
@FindBy(xpath="//span[contains(text(),'Your username or password is incorrect')]") private WebElement invalidUnamePWDmsg;
// @FindBy(xpath="//span[contains(text(),'Your username or password is incorrect')]") private WebElement invalidUnamdPWDmsg;

             


//Initialization

public LoginPage(WebDriver drv1)
{
PageFactory.initElements(drv1, this);
}

//Usage
public void loginPageUsername(String username)
{
Uname.sendKeys(username);
}


public void loginPagePWD(String password)
{
pwd.sendKeys(password);
}


public void loginPageSubmit()
{
loginButton.click();
}

public String LogininvalidPWDmsg()
{
String error1 = invalidPWDmsg.getText();
return error1;
}

public String LogininvalidUnamemsg()
{
String error2 = invalidUnamemsg.getText();
return error2;
}

public String LogininvalidUnamdPWDmsg()
{
// String error3 = invalidUnamdPWDmsg.getText();

String error3 = invalidUnamePWDmsg.getText();

//System.out.println("ER: "+ error3);
return error3;
}

}