package com.challenge.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * Main page of app
 *
 * @author Carlos Rodríguez
 */
public class HomePage extends BasePage {

	@FindBy(css = "a.mw-logo > img")
	private WebElement logo;

	@FindBy(css="#Welcome_to_Wikipedia > a")
	private WebElement title;

	@FindBy(id = "searchInput")
	private WebElement searchInput;

	public HomePage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(logo);
	}

	/**
	 * Retrieves page title text
	 *
	 * @return {@link String}
	 */
	public String getTitle(){
		getLogger().info("Returning home page title");
		getReportsLogger().log(LogStatus.INFO,"Returning home page title");
		return getActions().getText(title);
	}

	/**
	 * Retrieves navbar instance
	 *
	 * @return {@link HomePageNavbar}
	 */
	public HomePageNavbar getNavbar(){
		getReportsLogger().log(LogStatus.INFO,"Getting home page navbar");
		return new HomePageNavbar(getDriver(), getWait(), getReportsLogger());
	}
}
