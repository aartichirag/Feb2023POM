package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//1. declare the private driver
	private WebDriver driver;
	
	//2. page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3.By locators
	private By email = By.cssSelector("#email");
	private By password = By.cssSelector("#password");
	private By signIn = By.xpath("//button[contains(text() , 'SIGN IN')]");
	private By forgotPwdLink = By.linkText("forgot password?");
//	private By accountInfoText = By.cssSelector(".panel-header");
	
	//4. page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		System.out.println("Login With:" + un + " : " + pwd);
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		
	}

}
