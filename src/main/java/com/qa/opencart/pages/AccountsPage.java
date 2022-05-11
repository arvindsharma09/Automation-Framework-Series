package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By Locators

	private By search = By.name("search");
	private By Header = By.cssSelector("#logo a");
	private By accSectionList = By.cssSelector("div#content h2");
	private By searchbutton = By.cssSelector("#search button");
	
	//public Accounts Page Constructor
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// Page Actions
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isSearchboxExist() {
		return driver.findElement(search).isDisplayed();
	}
	
	public boolean isAccountPageHeaderExist() {
		return driver.findElement(Header).isDisplayed();
	}
	
	public SearchResultsPage doSearch(String productName) {
		driver.findElement(search).sendKeys(productName);
		driver.findElement(searchbutton).click();
		return new SearchResultsPage(driver);
		
	}
	
	public List<String> getAccountPageSectionList() {
		List<WebElement> secList =driver.findElements(accSectionList);
		List<String> accSecList = new ArrayList<String>();
		
		for(WebElement e : secList ) {
			String text = e.getText();
			accSecList.add(text);
		}
		return accSecList;
	}
}
