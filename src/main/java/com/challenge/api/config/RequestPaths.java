package com.challenge.api.config;

/**
 * Requests paths for api test cases
 *
 * @author Carlos Rodríguez
 */
public enum RequestPaths {
	PET("pet"),
	PET_BY_ID(PET.getPath() + "/{petId}");

	private final String requestPath;

	RequestPaths(String path) {
		this.requestPath = path;
	}

	public String getPath() {
		return requestPath;
	}
}
