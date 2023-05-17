package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class HomePageTest extends BaseTest {
	
	@BeforeClass 
	public void homePageSetUp() throws InterruptedException{
		loginPage.doLogin("test1011@gmail.com", "test123@");
	}
	
	@Test
	public void homePageTextTest() {
		Assert.assertTrue(homePage.isHomePageTextExist());	
	}

}
