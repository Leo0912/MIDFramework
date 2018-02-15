package com.time.CMAS.objectRepository.CircModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.time.CMAS.utilities.UserAction;
import com.time.CMAS.utilities.Utility;

public class loginPage_CircModel {

	WebDriver driver;

	public loginPage_CircModel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='username']")
	WebElement txtLogin;

	@FindBy(xpath = "//*[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//*[@id='loginBlock']/button[@class='loginButton']")
	WebElement btnSignIn;

	public void login() {
		UserAction.click(driver, txtLogin, "Username textbox click");
		UserAction.enterText(driver, txtLogin, Utility.getProperty("circModeluser"), "Username textbox text sent");
		UserAction.click(driver, txtPassword, "Password textbox click");
		UserAction.enterText(driver, txtPassword, Utility.getProperty("circModelpassword"), "Password textbox text sent");
		UserAction.click(driver, btnSignIn, "Sign In Button Click");
	}
}
