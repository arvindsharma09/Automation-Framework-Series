package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By Locators

	private By searchHeader = By.cssSelector("#content h1");
	private By products= By.cssSelector(".caption a");

	// Search Results Page Constructor
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Page Actions
	
	public boolean isSearchPageHeaderExist() {
		return driver.findElement(searchHeader).isDisplayed();
	}
	
	public ProductInfoPage selectProduct(String Productname) {
		System.out.println("Product Name is " + Productname);
		List<WebElement> productList = driver.findElements(products);
		for(WebElement e: productList ) {
			String text=e.getText();
			if(text.equals(productList)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
		
	}
	
	
}
