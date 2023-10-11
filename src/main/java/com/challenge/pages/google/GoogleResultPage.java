package com.challenge.pages.google;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.pages.BasePage;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * Main page of app
 *
 * @author Carlos Rodríguez
 */
public class GoogleResultPage extends BasePage {

	@FindBy(id = "search")
	private WebElement searchResultsDiv;

	@FindBy(css = "#search > div  h3")
	private List<WebElement> searchResults;


	public GoogleResultPage(WebDriver driver, WebDriverWait wait, ExtentTest reportsLogger) {
		super(driver, wait, reportsLogger);
	}

	@Override
	protected void pageLoadedElement() {
		getActions().waitElementForVisibility(searchResultsDiv);
	}

	public int getResults(){
		return searchResults.size();
	}

	public void clickResult(){
		searchResults.get(0).click();
	}


}
