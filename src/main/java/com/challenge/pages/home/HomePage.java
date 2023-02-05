package com.challenge.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;


public class HomePage extends BasePage {

	@FindBy(css = ".site-logo > a")
	private WebElement logo;

	@FindBy(css="#site-header div.site-logo > span")
	private WebElement title;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(logo);
	}

	public String getTitle(){
		getLogger().info("Returning home page title");
		return getActions().getText(title);
	}

	public HomePageNavbar getNavbar(){
		return new HomePageNavbar(getDriver(), getWait());
	}
}
