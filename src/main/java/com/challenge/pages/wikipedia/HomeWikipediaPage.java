package com.challenge.pages.wikipedia;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * Wikipedia page
 *
 * @author Carlos Rodríguez
 */
public class HomeWikipediaPage extends BasePage {

	@FindBy(css = "img.mw-logo-icon")
	private WebElement logo;

	public HomeWikipediaPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(logo);
	}

	/**
	 * Retrieves title text
	 *
	 * @return {@link String}
	 */
	public String getTitle(){
		return getDriver().getTitle();
	}

}
