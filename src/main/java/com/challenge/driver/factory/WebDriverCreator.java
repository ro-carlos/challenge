package com.challenge.driver.factory;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;


public abstract class WebDriverCreator {
	public abstract WebDriver createWebDriver() throws MalformedURLException;
}
