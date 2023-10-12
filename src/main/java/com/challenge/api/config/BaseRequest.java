package com.challenge.api.config;

import static io.restassured.RestAssured.given;

import com.challenge.utils.PropertiesReader;

import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Contains configuration for Api Request creation
 *
 * @author Carlos Rodríguez
 */
public abstract class BaseRequest implements RestAssuredClient {

	private static final PropertiesReader propertiesReader = PropertiesReader.getInstance();

	private final RestAssuredConfig config = RestAssuredConfig.config().httpClient(
			HttpClientConfig.httpClientConfig()
					.setParam("http.socket.timeout", Integer.parseInt(propertiesReader.getProperty("apiTimeout")))
					.setParam("http.connection.timeout", Integer.parseInt(propertiesReader.getProperty("apiTimeout"))));

	@Override
	public Response sendPostRequest(RequestSpecification requestSpecification, int statusCode) {
		return given().config(config).spec(requestSpecification).when().post().then().statusCode(
				statusCode).extract().response();
	}

	@Override
	public Response sendGetRequest(RequestSpecification requestSpecification, int statusCode) {
		return given().config(config).spec(requestSpecification).when().get().then().statusCode(
				statusCode).extract().response();
	}

	@Override
	public Response sendPutRequest(RequestSpecification requestSpecification, int statusCode) {
		return given().config(config).spec(requestSpecification).when().put().then().statusCode(
				statusCode).extract().response();
	}

	@Override
	public Response sendDeleteRequest(RequestSpecification requestSpecification, int statusCode) {
		return given().config(config).spec(requestSpecification).when().delete().then().statusCode(
				statusCode).extract().response();
	}
}
