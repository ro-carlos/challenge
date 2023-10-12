package com.challenge.tests.api.pet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.challenge.api.client.PetClient;
import com.challenge.api.dto.pet.PetDto;
import com.challenge.dataprovider.MainDataProvider;
import com.challenge.tests.BaseTest;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;


/**
 * Test class containing pet api test cases
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.API)
public class PetApiTest extends BaseTest {

	@Test (dataProvider = "validPetDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyPostPetTest(final PetDto pet) {
		PetClient petClient = new PetClient();
		Response response = petClient.sendPostPet(pet, HttpStatus.SC_OK);
		PetDto petResponseDto = response.getBody().as(PetDto.class);

		getReportLogger().log(LogStatus.INFO, "Checking pet response");
		assertEquals(petResponseDto.getId(), pet.getId(), String.format("Pet id %s is present ", petResponseDto.getId()));
		assertEquals(petResponseDto.getName(), pet.getName(), String.format("Pet name %s is present ", petResponseDto.getName()));
		assertEquals(petResponseDto.getCategory().getId(), pet.getCategory().getId(), String.format("Pet category id %s is present ", petResponseDto.getCategory().getId()));
		assertEquals(petResponseDto.getCategory().getName(), pet.getCategory().getName(), String.format("Pet category name %s is present ", petResponseDto.getCategory().getName()));
		assertEquals(petResponseDto.getPhotoUrls(), pet.getPhotoUrls(), String.format("Pet photoUrls %s is present ", petResponseDto.getPhotoUrls()));
		assertEquals(petResponseDto.getTags(), pet.getTags(), String.format("Pet tags %s is present ", petResponseDto.getTags()));
		assertEquals(petResponseDto.getStatus(), pet.getStatus(), String.format("Pet status %s is present ", petResponseDto.getStatus()));
	}

	@Test (dataProvider = "validPetDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyGetPetTest(final PetDto pet) {
		PetClient petClient = new PetClient();
		Response response = petClient.sendGetPet(pet.getId(), HttpStatus.SC_OK);
		PetDto petResponseDto = response.getBody().as(PetDto.class);

		getReportLogger().log(LogStatus.INFO, "Checking pet response");
		assertEquals(petResponseDto.getId(), pet.getId(), String.format("Pet id %s is present ", petResponseDto.getId()));
	}

	@Test (dataProvider = "validPetDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyPutPetTest(final PetDto pet) {
		pet.setStatus("updated");
		PetClient petClient = new PetClient();
		Response response = petClient.sendPutPet(pet, HttpStatus.SC_OK);
		PetDto petResponseDto = response.getBody().as(PetDto.class);

		getReportLogger().log(LogStatus.INFO, "Checking pet response");
		assertEquals(petResponseDto.getId(), pet.getId(), String.format("Pet id %s is present ", petResponseDto.getId()));
		assertEquals(petResponseDto.getStatus(), pet.getStatus(), String.format("Pet status %s is present ", petResponseDto.getStatus()));
	}

	@Test (dataProvider = "validPetDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyDeletePetTest(final PetDto pet) {
		PetClient petClient = new PetClient();
		Response response = petClient.sendDeletePet(pet.getId(), HttpStatus.SC_OK);

		getReportLogger().log(LogStatus.INFO, "Checking pet response");
		assertTrue(response.getBody().prettyPrint().contains("deleted"), String.format("Pet id %s was deleted", pet.getId()));
	}

	@Test (dataProvider = "invalidPetDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyInvalidGetPetTest(final PetDto pet) {
		PetClient petClient = new PetClient();
		Response response = petClient.sendGetPet(pet.getId(), HttpStatus.SC_NOT_FOUND);

		getReportLogger().log(LogStatus.INFO, "Checking pet response");
		assertTrue(response.getBody().prettyPrint().contains("not found"), String.format("Pet id %s was not found", pet.getId()));
	}
}
