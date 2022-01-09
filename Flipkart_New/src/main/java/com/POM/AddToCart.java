package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart
{
@FindBy(xpath="//input[@title='Search for products, brands and more']") private WebElement searchBar;
@FindBy(xpath="//button[@type='submit']") private WebElement searchBtn;
@FindBy(xpath="//div[contains(text(),'realme Narzo 50A (Oxygen Blue, 64 GB)')]") private WebElement product1;

@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']") private WebElement addCart;


//POM Initialization
public AddToCart(WebDriver drv1)
{
PageFactory.initElements(drv1, this);
}


//Usage
public void SearchProd(String prodName)
{
searchBar.sendKeys(prodName);
}

public void SearchSubmitBtn()
{
searchBtn.click();
}

public void SelectProduct1()
{
product1.click();
}

public void AddProtToCart()
{
addCart.click();
}

}