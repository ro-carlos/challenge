package com.challenge.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.utils.BrowserActions;


public class BasePage {
	private final WebDriver driver;
	private final WebDriverWait wait;
	private final BrowserActions browserActions;
	private static final Logger logger = LogManager.getLogger();

	private By mobileMenuLocator = By.cssSelector("div.header-titles-wrapper button[data-toggle-body-class='showing-menu-modal']");

	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.browserActions = new BrowserActions(driver, wait);
		PageFactory.initElements(this.driver, this);
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait getWait() {
		return wait;
	}

	protected boolean isResponsive(){
		return getActions().isLocatorPresent(mobileMenuLocator);
	}

	protected By getMobileMenuLocator(){
		return  mobileMenuLocator;
	}

	protected BrowserActions getActions(){
		return browserActions;
	}

	protected Logger getLogger(){
		return logger;
	}
}
