package com.challenge.pages.google;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.challenge.pages.wikipedia.HomeWikipediaPage;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * Results page
 *
 * @author Carlos Rodríguez
 */
public class GoogleResultPage extends BasePage {

	@FindBy(id = "search")
	private WebElement searchResultsContainer;

	@FindBy(css = "#search > div  h3")
	private List<WebElement> searchResults;


	public GoogleResultPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(searchResultsContainer);
	}

	/**
	 * Retrieves the number of results
	 *
	 * @return {@code int}
	 */
	public int getResults(){
		return searchResults.size();
	}

	/**
	 * Clicks on specific result
	 *
	 * @param index {@code int]
	 *
	 * @return {@link HomeWikipediaPage}
	 */
	public HomeWikipediaPage clickResult(int index){
		getActions().waitAndClick(searchResults.get(index));
		return new HomeWikipediaPage(getDriver(), getWait(), getReportsLogger());
	}


}
