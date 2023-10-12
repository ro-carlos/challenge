package com.challenge.api.client;

import com.challenge.api.config.BaseRequest;
import com.challenge.api.config.RequestPaths;
import com.challenge.api.dto.pet.PetDto;
import com.challenge.utils.PropertiesReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 * Contains pet requests
 *
 * @author Carlos Rodríguez
 */
public class PetClient extends BaseRequest {

	private static final PropertiesReader propertiesReader = PropertiesReader.getInstance();
	public static final String PET_API_BASE_URL = propertiesReader.getProperty("petServiceUrl");

	private static final String PET_ID = "petId";

	public Response sendPostPet(PetDto pet, int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(PET_API_BASE_URL)
				.setBasePath(RequestPaths.PET.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.setBody(pet)
				.build();
		return sendPostRequest(requestSpecification, statusCode);
	}

	public Response sendGetPet(String petId, int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(PET_API_BASE_URL)
				.setBasePath(RequestPaths.PET_BY_ID.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.addPathParam(PET_ID, petId)
				.build();
		return sendGetRequest(requestSpecification, statusCode);
	}

	public Response sendPutPet(PetDto pet, int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(PET_API_BASE_URL)
				.setBasePath(RequestPaths.PET.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.setBody(pet)
				.build();
		return sendPutRequest(requestSpecification, statusCode);
	}

	public Response sendDeletePet(String petId, int statusCode) {
		RequestSpecification requestSpecification =  new RequestSpecBuilder()
				.setBaseUri(PET_API_BASE_URL)
				.setBasePath(RequestPaths.PET_BY_ID.getPath())
				.setContentType(ContentType.JSON)
				.setAccept("application/json")
				.addPathParam(PET_ID, petId)
				.build();
		return sendDeleteRequest(requestSpecification, statusCode);
	}
}
