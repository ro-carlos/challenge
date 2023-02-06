package com.challenge.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.challenge.report.ExtentReportsManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class HomePage extends BasePage {

	@FindBy(css = ".site-logo > a")
	private WebElement logo;

	@FindBy(css="#site-header div.site-logo > span")
	private WebElement title;

	public HomePage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(logo);
	}

	public String getTitle(){
		getLogger().info("Returning home page title");
		getReportsLogger().log(LogStatus.INFO,"Returning home page title");
		return getActions().getText(title);
	}

	public HomePageNavbar getNavbar(){
		getReportsLogger().log(LogStatus.INFO,"Getting home page navbar");
		return new HomePageNavbar(getDriver(), getWait(), getReportsLogger());
	}
}
