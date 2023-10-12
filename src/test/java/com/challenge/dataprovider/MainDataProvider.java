package com.challenge.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.challenge.api.dto.pet.*;


/**
 * Data provider class for tests
 *
 * @author Carlos Rodríguez
 */
public class MainDataProvider {

	@DataProvider (name = "searchResultGoogleDataProvider", parallel = true)
	public static Object[][] searchResultGoogleDataProvider() {
		return new Object [][] {
				{ "Wikipedia" },
				{ "wiki" }
		};
	}

	@DataProvider (name = "searchResultGoogleWithUrlDataProvider", parallel = true)
	public static Object[][] searchResultGoogleWithUrlDataProvider() {
		return new Object [][] {
				{ "Wikipedia", "https://es.wikipedia.org/" },
				{ "cr7 wikipedia", "https://es.wikipedia.org/" }
		};
	}

	@DataProvider (name = "validPetDataProvider", parallel = true)
	public static Object[][] validPetDataProvider() {
		final PetDto petDto = new PetDto();
		final CategoryDto categoryDto = new CategoryDto();
		final List<String> photosUrl = new ArrayList<>();
		final String photoUrl = "someImageUrl";
		final List<TagDto> tagsDto = new ArrayList<>();
		final TagDto tagDto = new TagDto();

		categoryDto.setId("1");
		categoryDto.setName("Dogs");
		photosUrl.add(photoUrl);
		tagDto.setId("1");
		tagDto.setName("tag name");
		tagsDto.add(tagDto);

		petDto.setId("100");
		petDto.setName("doggie 100");
		petDto.setCategory(categoryDto);
		petDto.setPhotoUrls(photosUrl);
		petDto.setTags(tagsDto);
		petDto.setStatus("available");

		return new Object [][] {
				{ petDto }
		};
	}

	@DataProvider (name = "invalidPetDataProvider", parallel = true)
	public static Object[][] invalidPetDataProvider() {
		final PetDto petDto = new PetDto();

		petDto.setId("-100");
		petDto.setName("doggie -100");

		return new Object [][] {
				{ petDto }
		};
	}
}
