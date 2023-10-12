package com.challenge.pages.google;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * Main page of app
 *
 * @author Carlos Rodríguez
 */
public class GoogleHomePage extends BasePage {

	@FindBy(css = "img[alt='Google']")
	private WebElement logo;

	@FindBy(id = "APjFqb")
	private WebElement searchInput;

	public GoogleHomePage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(logo);
	}

	/**
	 * Search results for a given text
	 *
	 * @return {@link GoogleResultPage}
	 */
	public GoogleResultPage search(String text){
		getActions().setText(searchInput, text);
		searchInput.sendKeys(Keys.ENTER);
		return new GoogleResultPage(getDriver(), getWait(), getReportsLogger());
	}
}
