package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.qaboat.utils.Constants;

public class LoginPageTest extends BaseTest {

		@Test
		public void loginPageTitleTest() {
			String actTitle = loginPage.getLoginPageTitle();
			System.out.println("Login Page Title:" + actTitle);
			Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
		}
		
		@Test
		public void forgotPwdLinkTest() {
			Assert.assertTrue(loginPage.isForgotPwdLinkExist());	
		}
		
		@Test
		public void loginPageUrlTest() {
//		String loginUrl = loginPage.getLoginPageUrl();
//		System.out.println("login page url is: " + loginUrl);
//		Assert.assertTrue(loginUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
			
		Assert.assertTrue(loginPage.getLoginPageUrl()); //use for the ElementUtil
		}
		
		@Test
		public void loginTest() throws InterruptedException {
//			accountsPage = loginPage.doLogin("test1011@gmail.com", "test123@"); //hard coded value
			
			accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")); //un and pwd is config.properties
			//username.trim() - we can use for the remove space
			String accurl = accountsPage.getAccountsPageUrl();
			System.out.println(accurl);
			Assert.assertTrue(accurl.contains(Constants.ACCOUNTS_PAGE_URL));
			
		}
}
