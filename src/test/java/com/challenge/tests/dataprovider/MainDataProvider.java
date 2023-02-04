package com.challenge.tests.dataprovider;

import org.testng.annotations.DataProvider;

import com.challenge.pages.menu.TalentIntelligenceNavbarSubMenu;


public class MainDataProvider {

	@DataProvider (name = "menuWithUrlsDataProvider", parallel = false)
	public static Object[][] menuWithUrlsDataProvider() {
		return new Object [][] {
				{ TalentIntelligenceNavbarSubMenu.OVERVIEW, "https://www.randallreilly.com/talent-intelligence/" },
				{ TalentIntelligenceNavbarSubMenu.TECHNOLOGIES, "https://www.randallreilly.com/talent-intelligence/stratas/" },
				{ TalentIntelligenceNavbarSubMenu.TALENT_PARTNERS, "https://www.randallreilly.com/talent-intelligence/recruiting-services/" },
				{ TalentIntelligenceNavbarSubMenu.STRATEGIC_RESULTS, "https://www.randallreilly.com/talent-intelligence/recruiting-campaigns/" },
				{ TalentIntelligenceNavbarSubMenu.QUALITY_APPLICANTS, "https://www.randallreilly.com/talent-intelligence/driver-media/" },
		};
	}
}
