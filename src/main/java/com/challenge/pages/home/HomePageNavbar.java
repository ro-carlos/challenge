package com.challenge.pages.home;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.challenge.pages.menu.NavbarMenu;
import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;


public class HomePageNavbar extends BasePage {

	private static final String WEB_MENU_TEMPLATE = "//nav[@class='primary-menu-wrapper']//ul[contains(@class, 'primary-menu')]/li/a[text()='%s']";
	private static final String MOBILE_MENU_TEMPLATE = "//nav[@class='mobile-menu']/ul/li/div/a[text()='%s']";
	private static final String MOBILE_MENU_WITH_SUB_MENUS_TEMPLATE = "//nav[@class='mobile-menu']/ul/li/div/a[text()='%s']/following-sibling::button";
	private static final String WEB_SUB_MENU_TEMPLATE = "//ul[contains(@class, 'sub-menu')]//a[text()='%s']";
	private static final String MOBILE_SUB_MENU_TEMPLATE = "//nav[@class='mobile-menu']//ul[contains(@class, 'active')]//li//a[text()='%s']";


	private final Map<NavbarMenu, By> webMenu = Map.of(
			NavbarMenu.TALENT_INTELLIGENCE, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.TALENT_INTELLIGENCE.getName()),
			NavbarMenu.ASSET_INTELLIGENCE,  getLocator(WEB_MENU_TEMPLATE, NavbarMenu.ASSET_INTELLIGENCE.getName()),
			NavbarMenu.RISK_INTELLIGENCE, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.RISK_INTELLIGENCE.getName()),
			NavbarMenu.INDUSTRIES, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.INDUSTRIES.getName()),
			NavbarMenu.RESOURCES, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.RESOURCES.getName()),
			NavbarMenu.ABOUT, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.ABOUT.getName()),
			NavbarMenu.CONTACT_US, getLocator(WEB_MENU_TEMPLATE, NavbarMenu.CONTACT_US.getName()));

	private final Map<NavbarMenu, By> mobileMenu = Map.of(
			NavbarMenu.TALENT_INTELLIGENCE, getLocator(
					MOBILE_MENU_WITH_SUB_MENUS_TEMPLATE, NavbarMenu.TALENT_INTELLIGENCE.getName()),
			NavbarMenu.ASSET_INTELLIGENCE,  getLocator(
					MOBILE_MENU_WITH_SUB_MENUS_TEMPLATE, NavbarMenu.ASSET_INTELLIGENCE.getName()),
			NavbarMenu.RISK_INTELLIGENCE, getLocator(MOBILE_MENU_TEMPLATE, NavbarMenu.RISK_INTELLIGENCE.getName()),
			NavbarMenu.INDUSTRIES, getLocator(MOBILE_MENU_TEMPLATE, NavbarMenu.INDUSTRIES.getName()),
			NavbarMenu.RESOURCES, getLocator(MOBILE_MENU_WITH_SUB_MENUS_TEMPLATE, NavbarMenu.RESOURCES.getName()),
			NavbarMenu.ABOUT, getLocator(MOBILE_MENU_TEMPLATE, NavbarMenu.ABOUT.getName()),
			NavbarMenu.CONTACT_US, getLocator(MOBILE_MENU_TEMPLATE, NavbarMenu.CONTACT_US.getName()));

	public HomePageNavbar(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void openTalentIntelligenceSubMenu(TalentIntelligenceNavbarSubMenu submenu){
		var menuLocator = webMenu.get(NavbarMenu.TALENT_INTELLIGENCE);
		var subMenuLocator = getLocator(WEB_SUB_MENU_TEMPLATE, submenu.getName());
		if(!isWebResponsive()){
			menuLocator = mobileMenu.get(NavbarMenu.TALENT_INTELLIGENCE);
			subMenuLocator = getLocator(MOBILE_SUB_MENU_TEMPLATE, submenu.getName());
			getActions().waitAndClick(getMobileMenuLocator());
			getActions().waitAndClick(menuLocator);
		}else{
			getActions().hoverElement(menuLocator);
		}
		getActions().waitAndClick(subMenuLocator);
	}

	private By getLocator(String template, String menu) {
		return By.xpath(String.format(template, menu));
	}
}
