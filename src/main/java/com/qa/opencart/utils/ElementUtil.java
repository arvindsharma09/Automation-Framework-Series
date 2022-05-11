package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	// *********************** Drop-Down Utilities *********************************************

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> OptionList = select.getOptions();
		System.out.println(OptionList.size());

		for (WebElement e : OptionList) {
			String Text = e.getText();
			// System.out.println(Text);
			if (Text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void doSelectChoice(By locator, String value) {
		List<WebElement> choiceList = getElements(locator);

		for (WebElement e : choiceList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	
	}
	
	//************************************Actions Util *******************************************
	
	public void SelectSubMenu(By parentmenu, By childmenu) throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(getElement(parentmenu)).perform();
		Thread.sleep(3000);
		getElement(childmenu).click();
	
}
}
