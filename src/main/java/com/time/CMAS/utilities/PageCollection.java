package com.time.CMAS.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.time.CMAS.objectRepository.CircModel.dashBoardPage_CircModel;
import com.time.CMAS.objectRepository.CircModel.loginPage_CircModel;
import com.time.CMAS.objectRepository.DigitalAdmin.dashboardPage;
import com.time.CMAS.objectRepository.DigitalAdmin.loginPage;
import com.time.CMAS.objectRepository.DigitalAdmin.sizePage;
import com.time.CMAS.objectRepository.PreferenceCenter.loginPage_PC;

public class PageCollection {

	loginPage login;
	dashboardPage dashBoard;
	sizePage size;
	loginPage_PC login_PC;
	loginPage_CircModel login_CircModel;
	dashBoardPage_CircModel dashBoard_CircModel;

	public PageCollection(WebDriver driver) {
		//Page collection for Digital Admin
		login = PageFactory.initElements(driver, loginPage.class);
		dashBoard = PageFactory.initElements(driver, dashboardPage.class);
		size = PageFactory.initElements(driver, sizePage.class);
		
		//Page collection for Preference Center
		login_PC = PageFactory.initElements(driver, loginPage_PC.class);
		
		//Page collection for CircModel
		login_CircModel = PageFactory.initElements(driver, loginPage_CircModel.class);
		dashBoard_CircModel = PageFactory.initElements(driver, dashBoardPage_CircModel.class);
	}

	//Page collection for Digital Admin
	public loginPage loginPage() {
		return login;
	}

	public dashboardPage dashBoardPage() {
		return dashBoard;
	}

	public sizePage sizePage() {
		return size;
	}
	
	
	//Page collection for Preference Center
	public loginPage_PC loginPage_PC() {
		return login_PC;
	}
	
	//Page collection for CircModel
	public loginPage_CircModel loginPage_CircModel() {
		return login_CircModel;
	}
	public dashBoardPage_CircModel dashBoardPage_CircModel() {
		return dashBoard_CircModel;
	}
	
	
}
