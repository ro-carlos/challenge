package com.challenge.tests.home;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.home.HomePage;
import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;
import com.challenge.tests.BaseTest;
import com.challenge.dataprovider.MainDataProvider;


/**
 * Test class containing home page test cases
 *
 * @author Carlos Rodríguez
 */
public class HomeTest extends BaseTest {

	@Test
	public void verifyTitlePageTest() {
		final HomePage homePage = new HomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		final String pageTitle = homePage.getTitle();
		final String expectedPageTitle = "Randall Reilly";

		assertEquals(pageTitle, expectedPageTitle);
	}

	@Test (dataProvider = "menuWithUrlsDataProvider", dataProviderClass = MainDataProvider.class)
	public void openTalentIntelligenceLinksTest(TalentIntelligenceNavbarSubMenu submenu, String expectedUrl){
		final HomePage homePage = new HomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		homePage.getNavbar().openTalentIntelligenceSubMenu(submenu);
		assertEquals(homePage.getUrl(), expectedUrl);
	}
}
