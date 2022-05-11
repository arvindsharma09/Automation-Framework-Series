package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void AccountsPageTitleTest() {
		String actAccountsPageTitle = accPage.getAccountsPageTitle();
		System.out.println(actAccountsPageTitle);
		Assert.assertEquals(actAccountsPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test
	public void accPageHeaderTest() {
		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}

	@Test
	public void searchFieldExistTest() {
		Assert.assertTrue(accPage.isSearchboxExist());
	}
	
	@Test
	public void accSectionTest() {
		List<String> actSecList = accPage.getAccountPageSectionList();
		System.out.println("Accounts Section List :" + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
		
	}
	
	@Test
	public void doSearch() {
		srchPage = accPage.doSearch("Macbook");
	}
	
}
