package com.challenge.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.challenge.driver.Browser;
import com.challenge.driver.MyDriver;
import com.challenge.pages.home.HomePage;
import com.challenge.utils.PropertiesReader;


public class BaseTest {

	private final PropertiesReader propertiesReader = PropertiesReader.getInstance();
	private MyDriver myDriver;
	private WebDriverWait wait;
	private final Logger logger = LogManager.getLogger();
	private HomePage homePage;

	@BeforeSuite
	public void setup() {
		Browser browser = Browser.CHROME;
		if (propertiesReader.getProperty("browser").equals("firefox")) {
			browser = Browser.FIREFOX;
		}
		getLogger().info("Setting up browser");
		myDriver = new MyDriver(browser);
		wait = new WebDriverWait(myDriver.getWebDriver(),
				Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout"))));
		myDriver.getWebDriver().manage().window().maximize();
		homePage = new HomePage(myDriver.getWebDriver(), wait);
	}

	@BeforeMethod
	public void goHome() {
		getLogger().info("Navigating to home page");
		myDriver.getWebDriver().get(propertiesReader.getProperty("baseUrl"));
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		getLogger().info("Closing browser");
		myDriver.getWebDriver().quit();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	protected Logger getLogger() {
		return logger;
	}

}
