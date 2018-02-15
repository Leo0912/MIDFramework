package com.time.CMAS.objectRepository.DigitalAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.time.CMAS.utilities.UserAction;
import com.time.CMAS.utilities.Synchronization;

public class dashboardPage {

	WebDriver driver;
	Synchronization wait;

	public dashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='size']")
	WebElement lnkSize;

	@FindBy(xpath = "//*[@id='channel']")
	WebElement lnkChannel;

	@FindBy(xpath = "//*[@id='template']")
	WebElement lnkTemplate;

	@FindBy(xpath = ".//*[@id='header']/div[1]")
	WebElement user;

	public Boolean validateLogin() {
		String value = UserAction.getElementValue(driver, user, "Get Login User Value");
		if (value.contains("Hi")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickSize(String userAction) {
		UserAction.sleep(2000);
		UserAction.click(driver, lnkSize, userAction);
	}

	public void clickChannel(String userAction) {
		UserAction.click(driver, lnkChannel, userAction);
	}

	public void clickTemplate(String userAction) {
		UserAction.click(driver, lnkChannel, userAction);
	}
}
