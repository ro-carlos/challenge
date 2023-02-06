package com.challenge.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {

	private final WebDriver driver;
	private final WebDriverWait wait;

	private final Actions actions;
	private static final Logger logger = LogManager.getLogger();

	public BrowserActions(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(this.driver);
	}

	public String getText(WebElement element){
		return waitElementForVisibility(element).getText();
	}

	public void waitPageLoaded(){
		getWait().until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(
				"complete"));
	}

	public WebElement waitElementForVisibility(WebElement element){
		return getWait().until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitLocatorForVisibility(By locator){
		getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getDriver().findElement(locator);
	}

	public boolean isLocatorPresent(By locator){
		try {
			return waitLocatorForVisibility(locator).isDisplayed();
		}catch (TimeoutException e){
			getLogger().info("Element not present: " + locator);
		}
		return false;
	}

	public void waitAndClick(By locator){
		waitAndClick(waitLocatorForVisibility(locator));
	}


	public void waitAndClick(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void hoverElement(By locator){
		hoverElement(waitLocatorForVisibility(locator));
	}

	public void hoverElement(WebElement element){
		getActions().moveToElement(element).perform();
	}

	public void switchToIframe(WebElement iframe){
		getDriver().switchTo().frame(iframe);
	}

	public void switchToIframe(String iframe){
		getDriver().switchTo().frame(iframe);
	}

	public void switchToIframe(int iframe){
		getDriver().switchTo().frame(iframe);
	}

	protected WebDriver getDriver(){
		return driver;
	}

	protected WebDriverWait getWait(){
		return wait;
	}

	protected Actions getActions(){
		return actions;
	}

	protected Logger getLogger(){
		return logger;
	}

}
