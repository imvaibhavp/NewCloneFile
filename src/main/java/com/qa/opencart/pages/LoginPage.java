package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.contraints.AppConstraints;
import com.qa.opencart.utility.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By btnclick = By.xpath("//input[@type='submit']");
	private By img = By.xpath("//img[@title='naveenopencart']");
	private By forgotten = By.linkText("Forgotten Password");
	private By searchField = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By Register = By.linkText("Register");
	private By Linkempro = By.xpath("((//span[@class='transition'])[2]//a)[2]");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		 eleutil = new ElementUtil(driver);
	}

	public String getTitle() {
		String title = eleutil.waitForTitleToBe(AppConstraints.LOGIN_PAGE_TITLE, AppConstraints.SHORT_TIME_OUT);
		System.out.println("Your title is" + title);
		return title;
	}

	public String getCurrentUrl() {
		String url = eleutil.waitForUrl(AppConstraints.SHORT_TIME_OUT,AppConstraints.LOGIN_PAGE_URL) ;
		System.out.println("Your title is" + url);
		return url;
	}

	public boolean getLinkPresent() {
		return eleutil.waitForElementPresence(forgotten, AppConstraints.SHORT_TIME_OUT).isDisplayed();

	}

	public boolean getLogo() {
		return driver.findElement(img).isDisplayed();
	}

	public AccountPage doOpenCartLogin(String Username, String Password) {
		System.out.println("Your cat login is :" + Username + Password);
		eleutil.doSendKeys(emailid, Username);
		eleutil.doSendKeys(password, Password);
		eleutil.doClick(btnclick);

		//return eleutil.waitForTitleContains(AppConstraints.Home_TITLE,AppConstraints.SHORT_TIME_OUT);
		return new AccountPage(driver);

	}
	
	public SearchResultsPage performSearchWithoutLogin(String prdName) {
		System.out.println("searching for : " + prdName);
		eleutil.doSendKeysWithWait(searchField, 10, prdName);
		eleutil.doClick(searchIcon);
		return new SearchResultsPage(driver);
		
	}
	
	public RegistrationPage doRegistration() {
		eleutil.doClick(Register);
		return new RegistrationPage(driver);
		
	}
	
	public RegistrationPage doRegistration1() {
		eleutil.doClick(Linkempro);
		return new RegistrationPage(driver);
		
	}
}
