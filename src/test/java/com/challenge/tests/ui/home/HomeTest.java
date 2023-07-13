package com.challenge.tests.ui.home;

import static org.testng.Assert.assertEquals;

import com.challenge.pages.menu.NavbarMenu;
import org.testng.annotations.Test;

import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.home.HomePage;
import com.challenge.tests.BaseTest;
import com.challenge.dataprovider.MainDataProvider;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;


/**
 * Test class containing home page test cases
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.WEB)
public class HomeTest extends BaseTest {

	@Test
	public void verifyPageTitleTest() {
		final HomePage homePage = new HomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		final String pageTitle = homePage.getTitle();
		final String expectedPageTitle = "Wikipedia";

		assertEquals(pageTitle, expectedPageTitle);
	}

	@Test (dataProvider = "menuWithUrlsDataProvider", dataProviderClass = MainDataProvider.class)
	public void openTalentIntelligenceLinksTest(NavbarMenu menu, String expectedUrl){
		final HomePage homePage = new HomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		homePage.getNavbar().openMenu(menu);
		assertEquals(homePage.getUrl(), expectedUrl);
	}
}
