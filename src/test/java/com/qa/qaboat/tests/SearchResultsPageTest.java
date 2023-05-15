package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.qaboat.utils.Constants;

public class SearchResultsPageTest extends BaseTest {
	
	@BeforeClass 
	public void searchResultsPageSetUp() throws InterruptedException{
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchResultsPage = accountsPage.doSearch("apple");
	}
	
	@Test
	public void searchResultsPageUrlTest() {
	String searchResultsPageUrl = searchResultsPage.getSearchResultsPageUrl();
	System.out.println("Search Results page url is: " + searchResultsPageUrl);
	Assert.assertTrue(searchResultsPageUrl.contains(Constants.SEARCH_RESULTS_PAGE_URL));
	}
	
	@Test
	public void searchResultsTextTest() {
		Assert.assertTrue(searchResultsPage.isSearchResultsTextExist());	
	}
	
	@Test
	public void isproductTitleLinkTextExistTest() {
	String productTitleText = searchResultsPage.isproductTitleLinkTextExist();
	System.out.println("Product Title Text : " + productTitleText);
	Assert.assertTrue(productTitleText.contains(Constants.PRODUCT_TITLE_TEXT));
	}
	
}
