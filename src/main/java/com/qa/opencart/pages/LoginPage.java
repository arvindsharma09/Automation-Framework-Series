package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By Locators
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.xpath("//input[@value='Login']");
	private By forgotPwd = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By dummy = By.id("dummy");

	// 2. public Login page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Page Actions

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isForgetpwdLinkExist() {
		return driver.findElement(forgotPwd).isDisplayed();
	}

	public AccountsPage doLogin(String username, String pwd) {
		driver.findElement(emailid).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new AccountsPage(driver);
	}

	public boolean isRegisterLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	
	public RegistrationPage navigatetoRegisterPage() {
		if(isRegisterLinkExist()) {
			driver.findElement(registerLink).click();
			return new RegistrationPage(driver);
		}
		return null;
	}
	
}
