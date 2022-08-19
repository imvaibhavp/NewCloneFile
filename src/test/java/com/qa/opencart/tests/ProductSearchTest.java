package com.qa.opencart.tests;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductSearchTest extends BaseTest {



	@BeforeClass
	public void productSearchSetup() {
		accPage = loginPage.doOpenCartLogin(prop.getProperty("Username"), prop.getProperty("Password"));

	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { 
			{ "iPhone", "iPhone" },
			{ "Macbook", "MacBook Pro" },
			{ "Macbook", "MacBook Air" },
			{ "samsung", "Samsung Galaxy Tab 10.1" } 
			};
	}

	@Test(dataProvider = "getProductData")
	public void productSearchTest(String Searchkey, String productName) {
		searchResPage = accPage.doSearch(Searchkey);
		productInfoPage = searchResPage.selectProduct(productName);
		String actProductHeaderName = productInfoPage.getProductHeaderValue();
		Assert.assertEquals(actProductHeaderName, productName);
	}

	@DataProvider
	public Object[][] getProductCountData() {
		return new Object[][] { { "iPhone", "iPhone", 6 }, { "Macbook", "MacBook Pro", 4 },
				{ "Macbook", "MacBook Air", 4 }, { "samsung", "Samsung Galaxy Tab 10.1", 7 } };
	}

	@Test(dataProvider = "getProductCountData")
	public void productImagesCountTest(String Searchkey, String productName, int countimg) {
		searchResPage = accPage.doSearch(Searchkey);
		productInfoPage = searchResPage.selectProduct(productName);
		int actImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actImagesCount, countimg);
	}

	@DataProvider
	public Object[][] getProductInfo() {
		return new Object[][] { { "iPhone", "iPhone",
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name or number in your address book, a favorites list, or a call log. It also automatically syncs all your contacts from a PC, Mac, or Internet service. And it lets you select and listen to voicemail messages in whatever order you want just like email." },
				{ "Macbook", "MacBook Pro", "Latest Intel mobile architecture" }, };
	}

	@Test(dataProvider = "getProductInfo")
	public void getDescriptiondata(String Searchkey, String productName, String FractionValue) {
		searchResPage = accPage.doSearch(Searchkey);
		productInfoPage = searchResPage.selectProduct(productName);
		String productinfo = productInfoPage.getProductDetailInfo();
		Assert.assertEquals(productinfo, FractionValue);

	}
	
	@Test
	public void getProductMetaTest() {
		searchResPage = accPage.doSearch("MacBook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		
	//	HashMap<String, String> actproductinfo = productInfoPage.getMetaInfoData();
		LinkedHashMap<String, String> actproductinfo = productInfoPage.getMetaInfoData();
//		Assert.assertEquals(actproductinfo.get("Brand"), "Apple");
//		Assert.assertEquals(actproductinfo.get("Reward Points"), "800");
//		Assert.assertEquals(actproductinfo.get("Availability"), "In Stock");
//		Assert.assertEquals(actproductinfo.get("productpricing"), "$2,000.00");
//		Assert.assertEquals(actproductinfo.get("extproductprice"), "Ex Tax: $2,000.00");
	
		softassert.assertEquals(actproductinfo.get("Brand"), "Apple");
		softassert.assertEquals(actproductinfo.get("Reward Points"), "800");
		softassert.assertEquals(actproductinfo.get("Availability"), "In Stock");
		softassert.assertEquals(actproductinfo.get("productpricing"), "$2,000.00");
		softassert.assertEquals(actproductinfo.get("extproductprice"), "Ex Tax: $2,000.00");
		
		softassert.assertAll();
	
	
	}
	
	

}
