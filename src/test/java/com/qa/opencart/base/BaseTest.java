package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	
	public DriverFactory df;
	
	public LoginPage loginPage;
	public AccountPage accPage;
	public SearchResultsPage searchResPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage regPage;
	
	public SoftAssert softassert;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		
		prop = df. initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softassert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
