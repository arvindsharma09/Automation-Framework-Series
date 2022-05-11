package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Private By Locators
	
	private By productHeader = By.cssSelector("#content  h1");
	private By qty = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	
	//ProductInfo Page Constructor
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	// Page Actions
	
	public boolean isproductInfoHeaderExist() {
		return driver.findElement(productHeader).isDisplayed();
	}
	
	

}
