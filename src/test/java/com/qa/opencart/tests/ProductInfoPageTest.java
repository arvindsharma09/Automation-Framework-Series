package com.qa.opencart.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		srchPage = accPage.doSearch("Macbook");
		driver.findElement(By.linkText("MacBook Pro")).click();
		
	}
	
	@Test
	public void productInfoHeaderTest() {
		Assert.assertTrue(srchPage.isSearchPageHeaderExist());
	}
	
	

}
