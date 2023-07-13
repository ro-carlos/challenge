package com.challenge.tests.api.book;

import static org.testng.Assert.*;

import java.util.List;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import com.challenge.api.dto.BooksResponseDto;
import com.challenge.api.client.BookClient;
import com.challenge.dataprovider.MainDataProvider;
import com.challenge.tests.BaseTest;
import com.challenge.utils.TestInfo;
import com.challenge.utils.TestType;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

/**
 * Test class containing book api test cases
 *
 * @author Carlos Rodríguez
 */
@TestInfo(testType = TestType.API)
public class BookApiTest extends BaseTest {

	@Test
	public void verifyBooksTest() {
		BookClient bookClient = new BookClient();
		Response response = bookClient.sendGetBooks(HttpStatus.SC_OK);
		List<BooksResponseDto> booksResponseDto = response.body().jsonPath().getList("$");

		getReportLogger().log(LogStatus.INFO, "Checking book response size");
		assertTrue(booksResponseDto.size() > 0, String.format("Response has %s book(s)", booksResponseDto.size()));
	}

	@Test(dataProvider = "apiUserDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyBookTest(String bookAbbr) {
		BookClient bookClient = new BookClient();
		Response response = bookClient.sendGetBook(bookAbbr, HttpStatus.SC_OK);

		BooksResponseDto userResponseDto = response.getBody().as(BooksResponseDto.class);

		getReportLogger().log(LogStatus.INFO, String.format("Checking book abbrev %s ", bookAbbr));
		assertTrue(userResponseDto.getAbbrev().containsValue(bookAbbr), "Book bookAbbr is valid");
	}
}
