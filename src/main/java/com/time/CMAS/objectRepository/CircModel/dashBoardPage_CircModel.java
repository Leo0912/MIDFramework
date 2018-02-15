package com.time.CMAS.objectRepository.CircModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.time.CMAS.utilities.UserAction;

public class dashBoardPage_CircModel {
	WebDriver driver;

	public dashBoardPage_CircModel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='loginBlock']/button[@class='loginButton']")
	WebElement btnSignIn;

	public void validateLogin() {
		//UserAction.click(driver, txtLogin, "Username textbox click");
		//UserAction.enterText(driver, txtLogin, "devarajl", "Username textbox text sent");
		//UserAction.click(driver, txtPassword, "Password textbox click");
		//UserAction.enterText(driver, txtPassword, "Aug@2017", "Password textbox text sent");
		UserAction.click(driver, btnSignIn, "Sign In Button Click");
	}
	
}
