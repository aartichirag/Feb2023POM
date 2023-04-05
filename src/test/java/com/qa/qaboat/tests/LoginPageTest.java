package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

		@Test
		public void loginPageTitleTest() {
			String actTitle = loginPage.getLoginPageTitle();
			System.out.println("Login Page Title:" + actTitle);
			Assert.assertEquals(actTitle, "Login - EpicDeal");
		}
		
		@Test
		public void forgotPwdLinkTest() {
			Assert.assertTrue(loginPage.isForgotPwdLinkExist());	
		}
		
		@Test
		public void loginPageUrlTest() {
		String loginUrl = loginPage.getLoginPageUrl();
		System.out.println("login page url is: " + loginUrl);
		Assert.assertTrue(loginUrl.contains("/login"));
		}
		
		@Test
		public void loginTest() {
			loginPage.doLogin("test@gmail.com", "test123");
		}
}
