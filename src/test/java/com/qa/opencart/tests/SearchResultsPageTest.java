package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchResultsPageTest extends BaseTest {
	
	@BeforeClass
	public void searchPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		srchPage = accPage.doSearch("Macbook");
	}
	
	
	
	@Test
	public void srchPageHeaderText() {
		Assert.assertTrue(srchPage.isSearchPageHeaderExist());
	}

}
