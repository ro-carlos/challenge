package com.challenge.api.client;

import com.challenge.api.config.RequestPaths;
import com.challenge.api.config.BaseRequest;
import com.challenge.utils.PropertiesReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Contains books requests
 *
 * @author Carlos Rodríguez
 */
public class BookClient extends BaseRequest {

	private static final PropertiesReader propertiesReader = PropertiesReader.getInstance();
	public static final String BOOK_API_BASE_URL = propertiesReader.getProperty("bookServiceUrl");
	private static final String AUTHORIZATION_TOKEN = propertiesReader.getProperty("authorizationToken");

	private static final String BOOK_NAME = "bookAbbr";
	private static final String AUTHORIZATION = "Authorization";

	public Response sendGetBooks(int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(BOOK_API_BASE_URL)
				.setBasePath(RequestPaths.BOOKS.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.build();
		return sendGetRequest(requestSpecification, statusCode);
	}

	public Response sendGetBook(String bookAbbr, int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(BOOK_API_BASE_URL)
				//.addHeader(AUTHORIZATION, "Bearer " + propertiesReader.getProperty(AUTHORIZATION_TOKEN))
				.setBasePath(RequestPaths.BOOK_BY_BOOK_ABBR.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.addPathParam(BOOK_NAME, bookAbbr)
				.build();
		return sendGetRequest(requestSpecification, statusCode);
	}

}
