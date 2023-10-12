package com.challenge.tests.ui.google;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.challenge.dataprovider.MainDataProvider;
import com.challenge.driver.CurrentWebDriverManager;
import com.challenge.pages.google.GoogleHomePage;
import com.challenge.pages.google.GoogleResultPage;
import com.challenge.pages.wikipedia.HomeWikipediaPage;
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

	@Test (dataProvider = "searchResultGoogleDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyNonEmptyResults(String text) {
		final GoogleHomePage homePage = new GoogleHomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		GoogleResultPage resultPage = homePage.search(text);
		assertTrue(resultPage.getResults() > 0, "Results page has valid results");
	}

	@Test (dataProvider = "searchResultGoogleWithUrlDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyFirstResultUrl(String text, String expectedUrl) {
		final GoogleHomePage homePage = new GoogleHomePage(CurrentWebDriverManager.getInstance().getWebDriver(), getWait(), getReportLogger());

		GoogleResultPage resultPage = homePage.search(text);
		HomeWikipediaPage homeWikipediaPage = resultPage.clickResult(0);

		assertTrue(homeWikipediaPage.getUrl().contains(expectedUrl), "Url is valid");
		assertFalse(homeWikipediaPage.getTitle().isBlank(), "Header text is not empty");
	}

}
