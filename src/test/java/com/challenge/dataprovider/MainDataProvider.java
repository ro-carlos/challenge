package com.challenge.dataprovider;

import org.testng.annotations.DataProvider;


/**
 * Data provider class for tests
 *
 * @author Carlos Rodríguez
 */
public class MainDataProvider {

	@DataProvider (name = "searchResultGoogleDataProvider", parallel = true)
	public static Object[][] searchResultGoogleDataProvider() {
		return new Object [][] {
				{ "Wikipedia" },
				{ "wiki" }
		};
	}

	@DataProvider (name = "searchResultGoogleWithUrlDataProvider", parallel = true)
	public static Object[][] searchResultGoogleWithUrlDataProvider() {
		return new Object [][] {
				{ "Wikipedia", "https://es.wikipedia.org/" },
				{ "cr7 wikipedia", "https://es.wikipedia.org/" }
		};
	}
}
