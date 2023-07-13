package com.challenge.tests.ui.codingchallenge;

import static org.testng.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import com.challenge.dataprovider.MainDataProvider;

/**
 * Test class containing simple test case
 *
 * @author Carlos Rodríguez
 */
public class CodingChallengeTest {

	@Test (dataProvider = "codingChallengeDataProvider", dataProviderClass = MainDataProvider.class)
	public void verifyLongestWord(String[] words) {
		String longestWord = getLongestString(words);
		LogManager.getLogger().info("Longest String: " + longestWord);

		assertNotNull(longestWord);
	}

	private String getLongestString(String[] words){
		return Arrays.stream(words).max(Comparator.comparingInt(String::length)).get();
	}
}
