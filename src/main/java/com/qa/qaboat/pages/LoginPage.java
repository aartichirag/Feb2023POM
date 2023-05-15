package com.qa.qaboat.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.qaboat.utils.Constants;
import com.qa.qaboat.utils.ElementUtil;

import io.netty.util.Constant;

public class LoginPage {
	
	//1. declare the private driver
		private ChromeDriver driver;
		private ElementUtil eleUtil; //ElementUtil class

		
		//2. page constructor
		public LoginPage(ChromeDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver); ////ElementUtil class
		}
		
		//3.By locators
		private By email = By.cssSelector("#email"); //id("username")
		private By password = By.cssSelector("#password"); //id("password")
		private By signIn = By.xpath("//button[contains(text(), 'SIGN IN')]");
		private By forgotPwdLink = By.linkText("forgot password?");
//		private By accountInfoText = By.cssSelector(".panel-header");
		
		//4. page actions
		public String getLoginPageTitle() {
//			return driver.getTitle();
			return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, 5); //use for the ElementUtil Class
		}
		
		public boolean getLoginPageUrl() {
//			return driver.getCurrentUrl();
			return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, 5); //use for the ElementUti class
		}
		
		public boolean isForgotPwdLinkExist() {
//			return driver.findElement(forgotPwdLink).isDisplayed();
			return eleUtil.doIsDisplayed(forgotPwdLink); //ElementUtil class
		}
		
		public AccountsPage doLogin(String un, String pwd) throws InterruptedException {
			System.out.println("Login with: "+un+" : "+pwd);
			
			driver.findElement(email).sendKeys(un);		
			driver.findElement(password).sendKeys(pwd);		
			
//			driver.findElement(signIn).click(); //we can use this line but my code is not work that's why i use JS code
		
			/*
			 * We can use JavaScript Code for signIn Button::
			 */
			
			WebElement signInButton = driver.findElement(signIn);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", signInButton);
			
			/*
			 * ElementUtil class::
			*/
//			eleUtil.doSendKeys(email, un);	
//			eleUtil.doSendKeys(password, pwd); 
//			eleUtil.doClick(signIn); 
			
			Thread.sleep(5000);
			return new AccountsPage(driver);
		}


}
