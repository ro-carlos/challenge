package com.challenge.tests;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.XmlSuite;

import com.challenge.driver.*;
import com.challenge.driver.factory.WebDriverFactory;
import com.challenge.report.ExtentReportsManager;
import com.challenge.utils.Browser;
import com.challenge.utils.PropertiesReader;
import com.relevantcodes.extentreports.*;


public class BaseTest {

	private Browser browser = Browser.CHROME;
	private static ThreadLocal<WebDriverWait> waitThreadLocal = new ThreadLocal<>();
	private final PropertiesReader propertiesReader = PropertiesReader.getInstance();
	private final Logger logger = LogManager.getLogger();

	@BeforeSuite(alwaysRun = true)
	public void setup(ITestContext context) {
		if (propertiesReader.getProperty("browser").equals("firefox")) {
			browser = Browser.FIREFOX;
		}
		context.getCurrentXmlTest().getSuite().setParallel(XmlSuite.ParallelMode.METHODS);
		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(propertiesReader.getProperty("threads")));
		getLogger().info("Setup Suite ThreadId: " + Thread.currentThread().getId());
	}

	@BeforeMethod(alwaysRun = true)
	public void setUpSuite(Method context) throws Exception {
		ExtentReportsManager.getInstance().setExtentTest(ExtentReportsManager.getInstance().getReport().startTest(context.getName()));
		getLogger().info("Setup Method ThreadId: " + Thread.currentThread().getId());
		getLogger().info("Setting up browser");
		ExtentReportsManager.getInstance().getExtentTest().log(LogStatus.INFO, "Test has started");

		CurrentWebDriver.getInstance().setWebDriver(WebDriverFactory.getDriver(browser));
		waitThreadLocal.set(new WebDriverWait(CurrentWebDriver.getInstance().getWebDriver(),
				Duration.ofSeconds(Long.parseLong(propertiesReader.getProperty("timeout")))));
		CurrentWebDriver.getInstance().getWebDriver().manage().window().maximize();
		CurrentWebDriver.getInstance().getWebDriver().get(propertiesReader.getProperty("baseUrl"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		getLogger().info("Closing browser");
		getLogger().info("TearDown ThreadId: " + Thread.currentThread().getId());
		if (CurrentWebDriver.getInstance().getWebDriver() != null) {
			CurrentWebDriver.getInstance().getWebDriver().quit();
			CurrentWebDriver.getInstance().removeWebDriver();
		}
		setResults(result);
	}

	protected WebDriverWait getWait() {
		return waitThreadLocal.get();
	}

	protected ExtentTest getReportLogger(){
		return ExtentReportsManager.getInstance().getExtentTest();
	}

	protected Logger getLogger() {
		return logger;
	}

	private void setResults(ITestResult result){
		ExtentReportsManager extentReportsManager = ExtentReportsManager.getInstance();

		if(result.getStatus() == ITestResult.FAILURE) {
			extentReportsManager.getExtentTest().log(LogStatus.FAIL, "Test has failed");
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentReportsManager.getExtentTest().log(LogStatus.PASS, "Test has passed");
		} else {
			extentReportsManager.getExtentTest().log(LogStatus.SKIP, "Test has been skipped");
		}
		extentReportsManager.getReport().endTest(extentReportsManager.getExtentTest());
		extentReportsManager.getReport().flush();
	}
}
