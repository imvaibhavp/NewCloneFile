package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.contraints.AppConstraints;

public class LoginTests extends BaseTest {

	@Test(priority = 1)
	public void getTitle() {
		String acttitle = loginPage.getTitle();
		Assert.assertEquals(acttitle, AppConstraints.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 3)
	public void getUrl() {
		String actURL = loginPage.getCurrentUrl();
		Assert.assertEquals(actURL,AppConstraints.LOGIN_PAGE_URL);
	}

	@Test(priority = 4)
	public void getUrl1() {
		String actURL1 = loginPage.getCurrentUrl();
		Assert.assertEquals(actURL1.contains(AppConstraints.LOGIN_PAGE_URL_FRACTION), true);
	}

	@Test(priority = 5)
	public void getLink() {
		Assert.assertEquals(loginPage.getLinkPresent(), true);
	}

	@Test(priority = 6)
	public void doLoginTest() {
		accPage = loginPage.doOpenCartLogin(prop.getProperty("Username"),prop.getProperty("Password"));
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstraints.Home_TITLE);
	}
	
	@Test(priority = 2)
	public void doLoginTest1() {
		accPage = loginPage.doOpenCartLogin(prop.getProperty("Username"),prop.getProperty("Password"));
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstraints.Home_TITLE);
	}
	
//	@Test
//	public void doClickTest() {
//		loginPage.doRegistration1();
//		
//	}
	
}
