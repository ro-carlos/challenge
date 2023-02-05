package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.challenge.utils.PropertiesReader;


public class ChromeDriverCreator extends WebDriverCreator {
	@Override
	public WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver", PropertiesReader.getInstance().getProperty("chromeDriverPath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation","load-extension"});
		return new ChromeDriver(options);
	}

}
