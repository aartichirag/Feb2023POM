package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.qaboat.utils.Constants;

public class ProductDetailsPageTest extends BaseTest {
	
	@BeforeClass 
	public void productDetailsPageSetUp() throws InterruptedException{
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchResultsPage = accountsPage.doSearch("apple");
		productDetailsPage = searchResultsPage.DoClickOnProduct();
	}
	
	@Test(priority = 1)
	public void productDetailsPageUrlTest() {
	String ProductDetailsPageUrl = productDetailsPage.getProductDetailsPageUrl();
	System.out.println("Prodct Details page url is: " + ProductDetailsPageUrl);
	Assert.assertTrue(ProductDetailsPageUrl.contains(Constants.PRODUCT_DETAILS_PAGE_URL));
	}
	
	@Test(priority = 2)
	public void ProductSkuTextTest() {
		Assert.assertTrue(productDetailsPage.getProductSkuText());	
	}
	
//	@Test(priority = 2)
//	public void productDetailsPageSkuTest() {
//	boolean ProductDetailsPageSku = productDetailsPage.getProductSku();
//	System.out.println("Prodct Details page SKU is: " + ProductDetailsPageSku);
//	Assert.assertTrue(ProductDetailsPageSku.contains(Constants.PRODUCT_DETAILS_PAGE_SKU));
//	}
	
	
}