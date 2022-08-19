package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.contraints.AppConstraints;
import com.qa.opencart.utility.ElementUtil;

public class RegistrationPage {

	@SuppressWarnings("unused")
	private WebDriver driver;
	private ElementUtil eleutil;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By emailid = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeyes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeno = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");

	private By checkbox = By.xpath("//input[@type='checkbox']");
	private By submit = By.xpath("//input[@type='submit']");

	private By sucessMessg = By.cssSelector("div#content h1");
	private By logout = By.linkText("Logout");
	private By Registration = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	public Boolean userRegistration(String firstname, String lastname, String emailid, String telephone,
			String password, String subscribe) {

		eleutil.doSendKeysWithWait(this.firstname, AppConstraints.SHORT_TIME_OUT, firstname);
		eleutil.doSendKeys(this.lastname, lastname);
		eleutil.doSendKeys(this.emailid, emailid);
		eleutil.doSendKeys(this.telephone, telephone);
		eleutil.doSendKeys(this.password, password);
		eleutil.doSendKeys(this.confirmpassword, password);
		if (subscribe.equalsIgnoreCase("yes")) {
			eleutil.doClick(this.subscribeyes);
		} else {
			eleutil.doClick(this.subscribeno);
		}

		eleutil.doClick(checkbox);
		eleutil.doClick(submit);

		String actsuccmsg = eleutil.waitForElementVisible(sucessMessg, AppConstraints.MEDIUM_TIME_OUT).getText();
		if (actsuccmsg.contains(AppConstraints.REGISTER_SUCCESS_MESSAGE)) {
			eleutil.doClick(logout);
			eleutil.doClick(Registration);
			return true;
		}

		return false;

	}

	public void gotoRegPage() {
		
	}
}