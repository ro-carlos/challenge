package com.challenge.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.utils.BrowserActions;


public class BasePage {
	private final WebDriver driver;
	private final WebDriverWait wait;
	private final BrowserActions browserActions;
	private static final Logger logger = LogManager.getLogger();

	@FindBy(css = "body")
	private WebElement bodyElement;

	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.browserActions = new BrowserActions(driver, wait);
		PageFactory.initElements(this.driver, this);
		waitPageLoaded();
		pageLoadedElement();
	}

	public String getUrl(){
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait getWait() {
		return wait;
	}

	protected void pageLoadedElement(){
		getActions().waitElementForVisibility(bodyElement);
	}

	protected void waitPageLoaded(){
		getWait().until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(
				"complete"));
	}

	protected BrowserActions getActions(){
		return browserActions;
	}

	protected Logger getLogger(){
		return logger;
	}
}
