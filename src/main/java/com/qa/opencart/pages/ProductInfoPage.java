package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
//import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.contraints.AppConstraints;
import com.qa.opencart.utility.ElementUtil;

public class ProductInfoPage  {
	
	@SuppressWarnings("unused")
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private LinkedHashMap<String, String> prdmap;

	// 1. by locators:
	By productHeader = By.cssSelector("div#content h1");
	By productImages = By.cssSelector("ul.thumbnails img");
	By productdata = By.cssSelector("div#content p");
	//By prdmetadata = By.cssSelector("div#content ul.list-unstyled li");
	By metadata = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	By prdpriceinfo = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	// 2. const...
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeaderValue() {
		//By mainProduct = By.xpath("//h1[text()='" + mainProductName + "']");
		
		String productHeaderVal =  eleUtil.doElementGetText(productHeader);
		System.out.println("prod header: " + productHeaderVal);
		return productHeaderVal;
	}
	
	public int getProductImagesCount() {
		int imagesCount = eleUtil.waitForElementsToBeVisible(productImages, AppConstraints.SHORT_TIME_OUT).size();
		System.out.println("images count: " + imagesCount);
		return imagesCount;
	}
	
	public String getProductDetailInfo() {
		//By mainProduct = By.xpath("//h1[text()='" + mainProductName + "']");
		
		String productdetails =  eleUtil.doElementFractionGetText(productdata);
		System.out.println("prod header: " + productdetails);
		return productdetails;
	}
	
	public LinkedHashMap<String, String> getMetaInfoData() {
		//prdmap =new HashMap<String,String>();
	//	prdmap =new TreeMap<String,String>();
		prdmap =new LinkedHashMap<String,String>();
		
		prdmap.put("Product Name", getProductHeaderValue());

		getproductmetadata();
		getproductpricingdata();
		System.out.println("----------Actual Product Info------------");
		prdmap.forEach((k,v)->System.out.println(k+":"+v));
		return prdmap;
}
	
	private void getproductmetadata() {
		
		List<WebElement> prdlist =	eleUtil.getElements(metadata);
			for(WebElement e : prdlist) {
			String text = e.getText();
			String meta[]= text.split(":");
			String key = meta[0].trim();
			String value = meta[1].trim();
			prdmap.put(key, value);
		}
		
	}
	
	private void getproductpricingdata() {
		List<WebElement> prdprice =	eleUtil.getElements(prdpriceinfo);
		String actprice = prdprice.get(0).getText().trim();
		String exctaxprice = prdprice.get(1).getText().trim();
		prdmap.put("productpricing", actprice);
		prdmap.put("extproductprice", exctaxprice);
	}
	

}
