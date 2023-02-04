package com.challenge.pages.menu;

public enum TalentIntelligenceNavbarSubMenu {
	OVERVIEW("Overview"),
	TECHNOLOGIES("Technologies"),
	TALENT_PARTNERS("Talent  Partners"),
	STRATEGIC_RESULTS("Strategic Results"),
	QUALITY_APPLICANTS("Quality Applicants");

	private String name;

	private TalentIntelligenceNavbarSubMenu(String action) {
		this.name = action;
	}

	public String getName() {
		return this.name;
	}
}
