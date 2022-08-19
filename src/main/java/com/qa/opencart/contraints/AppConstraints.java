package com.qa.opencart.contraints;

import java.util.Arrays;
import java.util.List;

public class AppConstraints {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	public static final String LOGIN_PAGE_LINK = "Forgotten Password";
	public static final String Home_TITLE = "My Account";
	public static final List<String> EXPECTED_ACCOUNTS_HEADERS_LIST = Arrays.asList("My Account",
			"My Affiliate Account", "My Orders", "Newsletter");

	public static final int SHORT_TIME_OUT = 5;
	public static final int MEDIUM_TIME_OUT = 10;
	public static final int LARGE_TIME_OUT = 15;
	public static final int SMALL_DEFAULT_TIME_OUT = 0;
	public static final String REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";

}
