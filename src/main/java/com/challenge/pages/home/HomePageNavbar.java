package com.challenge.pages.home;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.challenge.pages.menu.NavbarMenu;
import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Main page navbar to perform navigation to different menu options
 *
 * @author Carlos Rodríguez
 */
public class HomePageNavbar extends BasePage {

	private static final String MENU_TEMPLATE = "//nav[@class='primary-menu-wrapper']//ul[contains(@class, 'primary-menu')]/li/a[text()='%s']";
	private static final String SUB_MENU_TEMPLATE = "//ul[contains(@class, 'sub-menu')]//a[text()='%s']";

	private final Map<NavbarMenu, By> menu = Map.of(
			NavbarMenu.TALENT_INTELLIGENCE, getLocator(MENU_TEMPLATE, NavbarMenu.TALENT_INTELLIGENCE.getName()),
			NavbarMenu.ASSET_INTELLIGENCE,  getLocator(MENU_TEMPLATE, NavbarMenu.ASSET_INTELLIGENCE.getName()),
			NavbarMenu.RISK_INTELLIGENCE, getLocator(MENU_TEMPLATE, NavbarMenu.RISK_INTELLIGENCE.getName()),
			NavbarMenu.INDUSTRIES, getLocator(MENU_TEMPLATE, NavbarMenu.INDUSTRIES.getName()),
			NavbarMenu.RESOURCES, getLocator(MENU_TEMPLATE, NavbarMenu.RESOURCES.getName()),
			NavbarMenu.ABOUT, getLocator(MENU_TEMPLATE, NavbarMenu.ABOUT.getName()),
			NavbarMenu.CONTACT_US, getLocator(MENU_TEMPLATE, NavbarMenu.CONTACT_US.getName()));

	public HomePageNavbar(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	/**
	 * Navigates to certain Talent Intelligence submenu
	 * @param submenu {@link TalentIntelligenceNavbarSubMenu}
	 *
	 */
	public void openTalentIntelligenceSubMenu(TalentIntelligenceNavbarSubMenu submenu){
		var menuLocator = menu.get(NavbarMenu.TALENT_INTELLIGENCE);
		var subMenuLocator = getLocator(SUB_MENU_TEMPLATE, submenu.getName());

		getLogger().info("Navigating to subMenu: " + submenu.getName());
		getReportsLogger().log(LogStatus.INFO,"Hovering menu " + NavbarMenu.TALENT_INTELLIGENCE.getName());
		getActions().hoverElement(menuLocator);

		getReportsLogger().log(LogStatus.INFO,"Clicking subMenu " + submenu.getName());
		getActions().waitAndClick(subMenuLocator);
	}

	/**
	 * Retrieves locator given template and menu name
	 * @param template {@link String}
	 * @param menu {@link String}
	 *
	 * @return {@link By} locator
	 */
	private By getLocator(String template, String menu) {
		return By.xpath(String.format(template, menu));
	}
}
