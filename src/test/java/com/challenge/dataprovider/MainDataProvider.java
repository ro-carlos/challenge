package com.challenge.dataprovider;

import org.testng.annotations.DataProvider;

import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;


public class MainDataProvider {

	@DataProvider (name = "menuWithUrlsDataProvider", parallel = true)
	public static Object[][] menuWithUrlsDataProvider() {
		return new Object [][] {
				{ TalentIntelligenceNavbarSubMenu.OVERVIEW, "https://www.randallreilly.com/talent-intelligence/" },
				{ TalentIntelligenceNavbarSubMenu.TECHNOLOGIES, "https://www.randallreilly.com/talent-intelligence/stratas/" },
				{ TalentIntelligenceNavbarSubMenu.TALENT_PARTNERS, "https://www.randallreilly.com/talent-intelligence/recruiting-services/" },
				{ TalentIntelligenceNavbarSubMenu.STRATEGIC_RESULTS, "https://www.randallreilly.com/talent-intelligence/recruiting-campaigns/" },
				{ TalentIntelligenceNavbarSubMenu.QUALITY_APPLICANTS, "https://www.randallreilly.com/talent-intelligence/driver-media/" }
		};
	}

	@DataProvider (name = "codingChallengeDataProvider", parallel = true)
	public static Object[][] codingChallengeDataProvider() {
		return new Object [][] {
				{ "Thanks", "For", "Attempting", "A", "Randall", "Reilly", "Coding", "Challenge" }
		};
	}
}
