package com.time.CMAS.DigitalAdmin;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.time.CMAS.driverSetup.baseDriver;
import com.time.CMAS.utilities.Utility;

public class SizePage_TCs extends baseDriver {


	@BeforeMethod
	public void startReport(Method method){
		reportLogger = extent.createTest((this.getClass().getSimpleName()+" :: "+method.getName()),method.getName());
	}


	@Test(groups = { "smoke" })
	public void test1_OpenPageSize() {
		Assert.assertTrue(page.dashBoardPage().validateLogin());
		page.dashBoardPage().clickSize("Click Size Link");
	}

	@Test (dependsOnMethods="test1_OpenPageSize", groups = { "smoke" })
	public void test2_AddRecord() throws IOException {
		page.sizePage().clickAddButton("Add Button Click");
		page.sizePage().enterDescription(Utility.global_Description , "Enter Description Text");
		page.sizePage().clickSaveButton("Save Button Click");
	    reportLogger.pass("Snapshot below: " + reportLogger.addScreenCaptureFromPath(Utility.takeScreenShot(driver, "dependsOnMethods")));
	}

	@Test (dependsOnMethods="test2_AddRecord")
	public void test3_ValidateSavedRecord() throws IOException {
		page.dashBoardPage().clickChannel("Click Channel Link");
		page.dashBoardPage().clickSize("Click Size Link");
		page.sizePage().clickDescriptionFilterBtn("Click Description Filter");
		page.sizePage().enterDescriptionFilter(Utility.global_Description, "Enter Saved Description in Filter textbox: " + Utility.global_Description);
		page.sizePage().selectFilterOption("Select Filter Option");
		page.sizePage().clickFilterBtn("Click Filter button in Description Filter");
		Assert.assertEquals(page.sizePage().getTableResult("Get Result Row Value"),Utility.global_Description);
	    reportLogger.pass("Snapshot below: " + reportLogger.addScreenCaptureFromPath(Utility.takeScreenShot(driver, "test3_ValidateSavedRecord")));
	}
}
