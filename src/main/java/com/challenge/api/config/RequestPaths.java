package com.challenge.api.config;

/**
 * Requests paths for api test cases
 *
 * @author Carlos Rodríguez
 */
public enum RequestPaths {
	BOOKS("books"),
	BOOK_BY_BOOK_ABBR(BOOKS.getPath() + "/{bookAbbr}");

	private final String requestPath;

	RequestPaths(String path) {
		this.requestPath = path;
	}

	public String getPath() {
		return requestPath;
	}
}
