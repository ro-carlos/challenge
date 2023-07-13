package com.challenge.dataprovider;

import com.challenge.pages.menu.NavbarMenu;
import org.testng.annotations.DataProvider;


/**
 * Data provider class for test
 *
 * @author Carlos Rodríguez
 */
public class MainDataProvider {

	@DataProvider (name = "menuWithUrlsDataProvider", parallel = true)
	public static Object[][] menuWithUrlsDataProvider() {
		return new Object [][] {
				{ NavbarMenu.MAIN_PAGE, "https://en.wikipedia.org/wiki/Main_Page" },
				{ NavbarMenu.CONTENTS, "https://en.wikipedia.org/wiki/Wikipedia:Contents" },
				{ NavbarMenu.CURRENT_EVENTS, "https://en.wikipedia.org/wiki/Portal:Current_events" },
				{ NavbarMenu.ABOUT_WIKIPEDIA, "https://en.wikipedia.org/wiki/Wikipedia:About" }
		};
	}

	@DataProvider (name = "apiUserDataProvider", parallel = true)
	public static Object[][] apiUserDataProvider() {
		return new Object [][] {
				{ "sl" }, { "gn" }
		};
	}

	@DataProvider (name = "codingChallengeDataProvider", parallel = true)
	public static Object[][] codingChallengeDataProvider() {
		return new Object [][] {
				{ "Thanks", "For", "Attempting", "A", "Randall", "Reilly", "Coding", "Challenge" }
		};
	}
}
