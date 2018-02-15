package com.time.CMAS.objectRepository.DigitalAdmin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.time.CMAS.utilities.UserAction;
import com.time.CMAS.utilities.Synchronization;

public class sizePage {

	WebDriver driver;
	Synchronization wait;

	public sizePage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(xpath = "//*[@id='sizeGrid']//span[@class='k-icon k-filter']")
	List<WebElement> btnDescFilter;

	@FindBy(xpath = "//input[@data-bind='value:filters[0].value']")
	WebElement txtDescriptionFilter;
	
	@FindBy(xpath = "//*[@id='add']")
	WebElement btnAdd;

	@FindBy(xpath = "//*[@id='save']")
	WebElement btnSave;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement btnCancel;

	@FindBy(xpath = "//*[@id='delete']")
	WebElement btnDelete;

	@FindBy(xpath = "//*[@id='description']")
	WebElement txtDescription;

	@FindBy(xpath = "//button[contains(text(),'Export')]")
	WebElement btnExport;
	
	@FindBy(xpath = "//ul[@class='k-list k-reset'][@aria-hidden='false']/li")
	WebElement optionFilter;
	
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	WebElement btnFilter;
	
	@FindBy(xpath = "//*[@id='sizeGrid']//td[1]")
	WebElement tblResultTD;
	

	public String getTableResult(String userAction) {
	   return UserAction.getElementValue(driver, tblResultTD, userAction);
	}

	public void enterDescription(String text, String userAction) {
		UserAction.enterText(driver, txtDescription, text, userAction);
	}

	public void clickAddButton(String userAction) {
		UserAction.sleep(5000);
		UserAction.click(driver, btnAdd, userAction);
	}

	public void clickSaveButton(String userAction) {
		UserAction.click(driver, btnSave, userAction);
		UserAction.sleep(5000);
	}

	public void clickCancelButton(String userAction) {
		UserAction.click(driver, btnCancel, userAction);
	}

	public void clickDescriptionFilterBtn(String userAction)
	{
		UserAction.sleep(10000);
		UserAction.click(driver, btnDescFilter.get(0), userAction);
	}
	
	public void enterDescriptionFilter(String text, String userAction) {
		UserAction.click(driver, txtDescriptionFilter, "Click Description Textbox");
		UserAction.enterText(driver, txtDescriptionFilter, text, userAction);
	}
	
	public void clickFilterBtn(String userAction)
	{
		UserAction.click(driver, btnFilter, userAction);
	}
	
	public void selectFilterOption(String userAction){
		UserAction.click(driver, optionFilter, userAction);
	}
	
}
