package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class HomePage {
	
			//1. declare the private driver
			private ChromeDriver driver;
						
			//2. page constructor
			public HomePage(ChromeDriver driver) {
				this.driver = driver;		
			}
			
			//3.By locators
			private By homePageText = By.xpath("//div[contains(@class, 'feature-details' )]//h6[contains(text(), '24/7 SUPPORT')]");
			private By loginTitleLinkText = By.xpath("//ul[contains(@class, 'list-inline top-nav-right-list')]//li/a[contains(text(), 'Login')]");
			
			
			//4. page actions
			public boolean isHomePageTextExist() {
				return driver.findElement(homePageText).isDisplayed();
			}
			
			public LoginPage doLogin() {
				driver.findElement(loginTitleLinkText).click();
				return new LoginPage(driver);
			}

}
