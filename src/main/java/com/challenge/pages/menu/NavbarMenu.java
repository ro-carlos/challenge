package com.challenge.pages.menu;

/**
 * Enum class containing navbar menu
 *
 * @author Carlos Rodríguez
 */
public enum NavbarMenu {
	TALENT_INTELLIGENCE("Talent Intelligence"),
	ASSET_INTELLIGENCE("Asset Intelligence"),
	 RISK_INTELLIGENCE("Risk Intelligence"),
	INDUSTRIES("Industries"),
	RESOURCES("Resources"),
	ABOUT("About"),
	CONTACT_US("About Us");

	private String name;

	private NavbarMenu(String action) {
		this.name = action;
	}

	public String getName() {
		return this.name;
	}
}
