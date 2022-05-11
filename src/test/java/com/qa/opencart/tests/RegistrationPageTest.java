package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void RegistrationPageSetUp() {
		registrationPage = loginPage.navigatetoRegisterPage();
	}
	
	public String getRandomEmail() {
		Random random = new Random();
		String email = "JanAutomation" + random.nextInt(1000)+ "@gmail.com";
		return email;
	}
	
	@Test
	public void RegistrationPageTitleTest() {
		String title = registrationPage.getRegistrationPageTitle();
		System.out.println("Registration Page Title is :" + title);
		Assert.assertEquals(title, Constants.REGISTRATION_PAGE_TITLE);
	}
	
	@Test
	public void RegistrationFormTest() {
		registrationPage.accountRegistrationForm("Arvind", "Sharma", getRandomEmail(), "7894562563", "Testing@123", "Testing@123");
	}

}
