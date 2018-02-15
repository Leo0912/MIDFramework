package com.time.CMAS.objectRepository.DigitalAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.time.CMAS.utilities.UserAction;
import com.time.CMAS.utilities.Utility;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@ng-model='login.username']")
	WebElement txtLogin;

	@FindBy(xpath = "//input[@ng-model='login.password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement btnSignIn;

	public void login() {
		UserAction.click(driver, txtLogin, "Username textbox click");
		UserAction.enterText(driver, txtLogin, Utility.getProperty("circModeluser"), "Username textbox text sent");
		UserAction.click(driver, txtPassword, "Password textbox click");
		UserAction.enterText(driver, txtPassword, Utility.getProperty("circModelpassword"), "Password textbox text sent");
		UserAction.click(driver, btnSignIn, "Sign In Button Click");
	}
}
