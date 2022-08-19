package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.contraints.AppConstraints;
import com.qa.opencart.utility.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. by locators:

	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By accPageHeaders = By.cssSelector("div#content h2");

	// 2. const...
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions:
	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstraints.Home_TITLE, AppConstraints.SHORT_TIME_OUT);
		System.out.println("Acc page title : " + title);
		return title;
	}

	public String getAccountsPageUrl() {
		String url = eleUtil.waitForUrl(AppConstraints.SHORT_TIME_OUT, AppConstraints.LOGIN_PAGE_URL_FRACTION);
		System.out.println("Acc page url : " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, AppConstraints.SHORT_TIME_OUT).isDisplayed();
	}

	public boolean isSearchFieldExist() {
		return eleUtil.waitForElementVisible(searchField, AppConstraints.SHORT_TIME_OUT).isDisplayed();
	}

	public List<String> getAccountSectionsHeaderList() {
		return eleUtil.getAllElementsTextList(accPageHeaders, AppConstraints.SHORT_TIME_OUT);
	}
	
	
	//common page actions:
	public SearchResultsPage doSearch(String productName) {
		System.out.println("searching for : " + productName);
		eleUtil.doSendKeysWithWait(searchField, 10, productName);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}
	
	
	
	

}