package com.challenge.tests.home;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.challenge.driver.CurrentWebDriver;
import com.challenge.pages.home.HomePage;
import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;
import com.challenge.tests.BaseTest;
import com.challenge.dataprovider.MainDataProvider;


public class HomeTest extends BaseTest {

	@Test
	public void verifyTitlePageTest() {
		final HomePage homePage = new HomePage(CurrentWebDriver.getInstance().getWebDriver(), getWait(), getReportLogger());
		final String pageTitle = homePage.getTitle();
		final String expectedPageTitle = "Randall Reilly";

		assertEquals(pageTitle, expectedPageTitle);
	}

	@Test (dataProvider = "menuWithUrlsDataProvider", dataProviderClass = MainDataProvider.class)
	public void openTalentIntelligenceLinksTest(TalentIntelligenceNavbarSubMenu submenu, String expectedUrl){
		final HomePage homePage = new HomePage(CurrentWebDriver.getInstance().getWebDriver(), getWait(), getReportLogger());

		homePage.getNavbar().openTalentIntelligenceSubMenu(submenu);
		assertEquals(homePage.getUrl(), expectedUrl);
	}
}
