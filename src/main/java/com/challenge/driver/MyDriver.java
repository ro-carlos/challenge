package com.challenge.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.challenge.utils.PropertiesReader;


public class MyDriver {
	private WebDriver driver;

	public MyDriver(Browser browser) {
		switch (browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver",
						PropertiesReader.getInstance().getProperty("chromeDriverPath"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				driver = new ChromeDriver(options);
				break;
		}
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}
}
