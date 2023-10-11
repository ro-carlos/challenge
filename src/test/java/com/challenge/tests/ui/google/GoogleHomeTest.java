package com.challenge.tests.ui.google;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.challenge.dataprovider.MainDataProvider;
import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.google.GoogleHomePage;
import com.challenge.pages.google.GoogleResultPage;
import com.challenge.pages.home.HomePage;
import com.challenge.pages.menu.NavbarMenu;
import com.challenge.tests.BaseTest;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;


/**
 * Test class containing home page test cases
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.WEB)
public class GoogleHomeTest extends BaseTest {

	@Test
	public void verifyNonEmptyResults() {
		final GoogleHomePage homePage = new GoogleHomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		final String text = "Wikipedia";

		GoogleResultPage resultPage = homePage.search(text);
		assertTrue(resultPage.getResults() > 0, "There are valid result");
		//assertEquals(pageTitle, expectedPageTitle);
	}

	@Test
	public void verifyFirstResult() {
		final GoogleHomePage homePage = new GoogleHomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());
		final String text = "Wikipedia";
		final String expectedUrl = "https://es.wikipedia.org/";

		GoogleResultPage resultPage = homePage.search(text);
		resultPage.clickResult();

		assertTrue(resultPage.getUrl().contains(expectedUrl), "There are valid result");
		//assertEquals(pageTitle, expectedPageTitle);
	}

}
