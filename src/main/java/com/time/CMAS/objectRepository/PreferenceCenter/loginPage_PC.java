package com.time.CMAS.objectRepository.PreferenceCenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.time.CMAS.utilities.UserAction;
import com.time.CMAS.utilities.Utility;

public class loginPage_PC {

	WebDriver driver;

	public loginPage_PC(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='z_zipcode']")
	WebElement txtZipCode;
	
	@FindBy(xpath = "//*[@id='AccountNumberLoginMainDiv']//label[contains(text(),'Zip/Postal')]")
	WebElement radioZipCode;

	@FindBy(xpath = "//*[@id='z_accountnumber']")
	WebElement txtAccountNo;

	@FindBy(xpath = "//*[@id='z_email']")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@id='zipAccountLoginButton']")
	WebElement btnLogin;

	@FindBy(xpath = "//*[@id='radioErrorHighLightDiv']//label[@for='emailradio2']")
	WebElement selectEmail;
	
	public void login() {
		UserAction.click(driver, radioZipCode, "Select Zip code Option");
		UserAction.enterText(driver, txtZipCode, Utility.getProperty("pc_zip"), "Zipcode textbox text sent");
		UserAction.enterText(driver, txtAccountNo, Utility.getProperty("pc_accountID"), "Account No text sent");
		UserAction.enterText(driver, txtEmail, "skip498@skip498.com", "Email textbox text sent");
		UserAction.click(driver, btnLogin, "Sign In Button Click");
		UserAction.click(driver, selectEmail, "Select Default Email ID");
	}
}
