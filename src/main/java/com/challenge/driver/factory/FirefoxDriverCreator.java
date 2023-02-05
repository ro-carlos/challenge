package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverCreator extends WebDriverCreator{
	@Override
	public WebDriver createWebDriver() {
		return new FirefoxDriver();
	}

}
