package com.challenge.tests.home;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.challenge.pages.home.HomePage;
import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;
import com.challenge.tests.BaseTest;
import com.challenge.tests.dataprovider.MainDataProvider;


public class HomeTest extends BaseTest {



	@Test
	public void verifyTitlePageTest() {
		final HomePage homePage = getHomePage();
		final String pageTitle = homePage.getTitle();
		final String expectedPageTitle = "Randall Reilly";

		assertEquals(pageTitle, expectedPageTitle);
	}

	@Test (dataProvider = "menuWithUrlsDataProvider", dataProviderClass = MainDataProvider.class)
	public void openTalentIntelligenceLinks(TalentIntelligenceNavbarSubMenu submenu, String expectedUrl){
		final HomePage homePage = getHomePage();

		homePage.getNavbar().openTalentIntelligenceSubMenu(submenu);
		assertEquals(homePage.getUrl(), expectedUrl);
	}
}
