package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.contraints.AppConstraints;
import com.qa.opencart.utility.ExcelUtility;

public class UserRegistrationTest extends BaseTest {

	@BeforeClass
	public void regSetUp() {
		regPage = loginPage.doRegistration();
	}

//	@DataProvider
//	public Object[][] dataRegistration() {
//		return new Object[][] { { "r", "qwrthsb", "juy@cvb.com", "878675664", "767ee", "Yes" },
//								{ "t", "qwrthsb", "uio@cvb.com", "878675665", "767ee", "no" },
//								{ "d", "qwrthsb", "9765@cvb.com", "878675666", "767ee", "no" },
//
//		};
//	}
	
	public String randomEmail() {
		Random random = new Random();
		String email="vaibhav"+random.nextInt(1000)+"@afd.com";
		return email;
	}
	
	
	@DataProvider
	public Object[][] dataRegistration() {
		ExcelUtility eu = new ExcelUtility();
		Object register [][] = eu.getTestData(AppConstraints.REGISTER_SHEET_NAME);
		return register;
	}

	@Test(dataProvider = "dataRegistration")
	public void userReg(String firstName, String lastName,String phone, String password,
			String subscribe) {
		boolean succflag = regPage.userRegistration(firstName, lastName, randomEmail(), phone, password, subscribe);
		Assert.assertEquals(succflag, true);

	}

}
