package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchResultsPage {
	
			//1. declare the private driver
			private ChromeDriver driver;
			
			//2. page constructor
			public SearchResultsPage(ChromeDriver driver) {
				this.driver = driver;
			}
			
			//3.By locators
			private By searchResultsText = By.xpath("//div[contains(@class, 'content-left')]/h4/span[contains(text(),'apple')]");
			private By productTitleLinkText = By.xpath("//a/h6[contains(text(), 'Apple MacBook Pro 2019 Model (13-Inch, Intel Core i5, 1.4Ghz, 8GB, 128GB)')]");
		
			
			//4. page actions
				
			public String getSearchResultsPageUrl() {
				return driver.getCurrentUrl();
			}
			
			public boolean isSearchResultsTextExist() {
				return driver.findElement(searchResultsText).isDisplayed();
			}
			
			public String isproductTitleLinkTextExist() {
				return driver.findElement(productTitleLinkText).getText();
			}
			
			public ProductDetailsPage DoClickOnProduct() {
				driver.findElement(productTitleLinkText).click();
				return new ProductDetailsPage(driver);
			}
			
}
