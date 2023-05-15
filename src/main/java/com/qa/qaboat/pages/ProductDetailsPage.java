package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.qaboat.utils.Constants;
import com.qa.qaboat.utils.ElementUtil;

public class ProductDetailsPage {
	
		//1. declare the private driver
		private ChromeDriver driver;
			
		//2. page constructor
		public ProductDetailsPage(ChromeDriver driver) {
			this.driver = driver;
		}
			
		//3.By locators
		private By ProductSkuText = By.xpath("//div[contains(@class, 'details-info-bottom' )]//ul/li[contains(text(), 'PUYNR7RX' )]");	
		
			
		//4. page actions
//		public String getAccountsPageTitle() {
//			return driver.getTitle();			
//		}
			
		public String getProductDetailsPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public boolean getProductSkuText() {
			return driver.findElement(ProductSkuText).isDisplayed();
		}
		
//		public boolean getProductSku() {
//			return driver.equals(getProductSku());
//		}

}
