package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.qaboat.utils.Constants;
import com.qa.qaboat.utils.ElementUtil;

import io.netty.util.Constant;

public class AccountsPage {
	
		//1. declare the private driver
		private ChromeDriver driver;
		private ElementUtil eleUtil;
		
		//2. page constructor
		public AccountsPage(ChromeDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver); 
		}
		
		//3.By locators
		private By dashboardLinkText = By.xpath("//ul[contains(@class, 'account-sidebar')]//a[contains(text(), 'Dashboard')]");	
		private By ordersLinkText = By.xpath("//ul[contains(@class, 'account-sidebar')]//a[contains(text(), 'My Orders')]");
		private By logoutLinkText = By.xpath("//ul[contains(@class, 'account-sidebar')]//a[contains(text(), 'Logout')]");
		private By searchField = By.xpath("//div[contains(@class, 'header-search-lg')]//input[contains(@class, 'search-input')]");
		private By searchButton = By.xpath("//div[contains(@class, 'header-search-right')]//button[contains(@type, 'submit') ]");
		
		//4. page actions
		public String getAccountsPageTitle() {
//			return driver.getTitle();
			return eleUtil.doGetTitle(Constants.ACCOUNTS_PAGE_TITLE, 5); //ElementUtil Class
		}
		
		public String getAccountsPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public boolean getDashboardLinkText() {
//			return driver.findElement(dashboardLinkText).isDisplayed();			
			return eleUtil.doIsDisplayed(dashboardLinkText); //ElementUtil Class
		}
		
		public boolean getOrdersLinkText() {
//			return driver.findElement(ordersLinkText).isDisplayed();	
			return eleUtil.doIsDisplayed(ordersLinkText); //ElementUtil Class
		}
		
		public boolean getLogoutLinkText() {
//			return driver.findElement(logoutLinkText).isDisplayed();
			return eleUtil.doIsDisplayed(logoutLinkText); //ElementUtil Class
		}
		
		public boolean searchFieldExist() {
//			return driver.findElement(searchField).isDisplayed();	
			return eleUtil.doIsDisplayed(searchField); //ElementUtil Class
		}
		
		public SearchResultsPage doSearch(String productName) throws InterruptedException {
			System.out.println("Searching for: " + productName);
//			driver.findElement(searchField).clear();
//			driver.findElement(searchField).sendKeys(productName);
//			driver.findElement(searchButton).click();
			
			eleUtil.doClear(searchField);
			eleUtil.doSendKeys(searchField, productName);
			eleUtil.doClick(searchButton);
			
			
			Thread.sleep(5000);
			return new SearchResultsPage(driver);
		}
}
