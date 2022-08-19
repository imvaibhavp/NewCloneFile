package com.qa.opencart.tests;

import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class PerformSearchTestWithoutLogin extends BaseTest {
	

	
	
	@Test
	public void performSearchTest(String Searchkey, String productName) {
		
		
		searchResPage = loginPage.performSearchWithoutLogin("MacBook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		String productinfo = productInfoPage.getProductDetailInfo();
		Assert.assertEquals(productinfo, "Latest Intel mobile architecture");

	}
	
	

}
