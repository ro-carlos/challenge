package com.challenge.api.config;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Requests interface
 *
 * @author Carlos Rodríguez
 */
public interface RestAssuredClient {
	Response sendGetRequest(RequestSpecification requestSpecification, int statusCode);

	Response sendPostRequest(RequestSpecification requestSpecification, int statusCode);

}
