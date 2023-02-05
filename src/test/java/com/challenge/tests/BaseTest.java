package com.challenge.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.challenge.driver.*;
import com.challenge.driver.factory.WebDriverFactory;
import com.challenge.pages.home.HomePage;
import com.challenge.utils.Browser;
import com.challenge.utils.PropertiesReader;


public class BaseTest {

	private Browser browser = Browser.CHROME;
	private WebDriverWait wait;
	private final PropertiesReader propertiesReader = PropertiesReader.getInstance();
	private final Logger logger = LogManager.getLogger();

	@BeforeSuite
	public void setup(ITestContext context) {
		if (propertiesReader.getProperty("browser").equals("firefox")) {
			browser = Browser.FIREFOX;
		}
		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(5);
		getLogger().info("ThreadId: " + Thread.currentThread().getId());
	}

	@BeforeMethod
	public void parallelismSetup() throws Exception {
		getLogger().info("ThreadId: " + Thread.currentThread().getId());
		getLogger().info("Setting up browser");

		CurrentWebDriver currentWebDriver = CurrentWebDriver.getInstance();
		currentWebDriver.setWebDriver(WebDriverFactory.getDriver(browser));

		wait = new WebDriverWait(currentWebDriver.getWebDriver(),
				Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout"))));
		currentWebDriver.getWebDriver().manage().window().maximize();
		currentWebDriver.getWebDriver().get(propertiesReader.getProperty("baseUrl"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getLogger().info("Closing browser");
		if(CurrentWebDriver.getInstance().getWebDriver() != null){
			CurrentWebDriver.getInstance().getWebDriver().quit();
			CurrentWebDriver.getInstance().removeWebDriver();
		}
	}

	protected WebDriverWait getWait(){
		return wait;
	}

	protected Logger getLogger() {
		return logger;
	}

}
