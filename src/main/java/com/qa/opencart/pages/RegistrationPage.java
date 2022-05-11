package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private Locators

	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By Password = By.id("input-password");
	By PwdConfirm = By.id("input-confirm");
	By privacyPolicy = By.name("agree");
	//By continutBtn = By.xpath("//input[@value='Continue']");

	// Registration Page Constructor

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Page Actions

	public String getRegistrationPageTitle() {
		return driver.getTitle();
	}

	public void accountRegistrationForm(String FN, String LN, String emailid, String phone, String pwd, String cnfpwd) {
		driver.findElement(firstName).sendKeys(FN);
		driver.findElement(lastName).sendKeys(LN);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(PwdConfirm).sendKeys(cnfpwd);
		driver.findElement(privacyPolicy).click();
		//driver.findElement(continutBtn).click();

	}

}
