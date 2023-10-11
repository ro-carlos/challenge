package com.challenge.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.challenge.utils.PropertiesReader;

/**
 * Chrome driver creator class
 *
 * @author Carlos Rodríguez
 */
public class ChromeDriverCreator extends WebDriverCreator {
	@Override
	public WebDriver createWebDriver() {
		//System.setProperty("webdriver.chrome.driver", PropertiesReader.getInstance().getProperty("chromeDriverPath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation","load-extension"});
		options.addArguments("--remote-allow-origins=*"); //https://github.com/SeleniumHQ/selenium/issues/11750 related issue
		return new ChromeDriver(options);
	}

}
