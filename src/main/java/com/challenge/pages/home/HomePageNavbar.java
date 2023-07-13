package com.challenge.pages.home;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.challenge.pages.menu.NavbarMenu;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Main page navbar to perform navigation to different menu options
 *
 * @author Carlos Rodríguez
 */
public class HomePageNavbar extends BasePage {

	private static final String MENU_TEMPLATE = "//ul[@class='vector-menu-content-list']//li[@class='mw-list-item']//span[text()='%s']/parent::a";

	@FindBy(id = "vector-main-menu-dropdown")
	private WebElement menuDropdownButton;

	private final Map<NavbarMenu, By> menu = Map.of(
			NavbarMenu.MAIN_PAGE, getLocator(NavbarMenu.MAIN_PAGE.getName()),
			NavbarMenu.CONTENTS,  getLocator(NavbarMenu.CONTENTS.getName()),
			NavbarMenu.CURRENT_EVENTS, getLocator(NavbarMenu.CURRENT_EVENTS.getName()),
			NavbarMenu.ABOUT_WIKIPEDIA, getLocator(NavbarMenu.ABOUT_WIKIPEDIA.getName()));

	public HomePageNavbar(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	/**
	 * Navigates to certain Talent Intelligence menu
	 * @param menuOption {@link NavbarMenu}
	 *
	 */
	public void openMenu(NavbarMenu menuOption){
		var menuLocator = menu.get(menuOption);

		getLogger().info("Navigating to subMenu: " + menuOption.getName());
		getReportsLogger().log(LogStatus.INFO,"Clicking menu dropdown");
		getActions().waitAndClick(menuDropdownButton);

		getReportsLogger().log(LogStatus.INFO,"Clicking menu option " + menuOption.getName());
		getActions().waitAndClick(menuLocator);
	}

	/**
	 * Retrieves locator given template and menu name
	 * @param menu {@link String}
	 *
	 * @return {@link By} locator
	 */
	private By getLocator(String menu) {
		return By.xpath(String.format(MENU_TEMPLATE, menu));
	}
}
