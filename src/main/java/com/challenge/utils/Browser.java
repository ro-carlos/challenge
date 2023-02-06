package com.challenge.utils;

public enum Browser {
	FIREFOX("Firefox"), CHROME("Chrome");

	private String name;

	private Browser(String action) {
		this.name = action;
	}

	public String getName() {
		return this.name;
	}
}
