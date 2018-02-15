package com.time.CMAS.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UserAction {

	static SoftAssert softAssert = new SoftAssert();

	public static void click(WebDriver driver, WebElement ele, String userAction) {
		try {
			boolean condition = Synchronization.waitForElement(driver, ele);
			Assert.assertTrue(condition,ele +"");
			ele.click();
			System.out.println("User Test Action:\t" + userAction);
			// logger code goes here
		} catch (Exception e) {
			softAssert.fail(ele + " is not displayed as Expected");
			e.printStackTrace();
		}
	}

	public static void openBrowser(WebDriver driver, String URL, String userAction) {
		try {
			driver.get(URL);
			System.out.println("User Test Action:\t" + userAction);
			// logger code goes here
		} catch (Exception e) {
			softAssert.fail("Unable to open URL: " + URL);
			e.printStackTrace();
		}
	}
	
	public static void sleep(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			softAssert.fail("Sleep Function failed");
			e.printStackTrace();
		}
	}
	

	public static void acceptAlert(WebDriver driver, String userAction) {
		try {

			System.out.println("User Test Action:\t" + userAction);
			// logger code goes here
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getElementValue(WebDriver driver, WebElement ele, String userAction) {
		try {
			boolean condition = Synchronization.waitForElement(driver, ele);
			Assert.assertTrue(condition,ele +"");
			System.out.println("User Test Action:\t" + userAction);
			// logger code goes here
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele.getText();
	}

	public static void enterText(WebDriver driver, WebElement ele, String sendText, String userAction) {
		try {
			boolean condition = Synchronization.waitForElement(driver, ele);
			Assert.assertTrue(condition,ele +"");
			ele.sendKeys(sendText);
			System.out.println("User Test Action:\t" + userAction);
			// logger code goes here
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchingFrame(WebElement ele, WebDriver driver) {
		try {
			driver.switchTo().frame(ele);
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to Switch to Frame");
		}
	}

	public void switchingToDefaultFrame(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to Switch to default Frame");
		}
	}

	public static void selectDropDownByText(WebElement WE, String VisibleText) {
		try {
			Select selObj = new Select(WE);
			selObj.selectByVisibleText(VisibleText);
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to select Drop down by Text");
		}
	}

	// select the dropdown using "select by index", so pass IndexValue as '2'
	public static void selectDropDownByIndex(WebElement WE, int IndexValue) {
		try {

			Select selObj = new Select(WE);
			selObj.selectByIndex(IndexValue);
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to select Drop down by Index");
		}
	}

	// select the dropdown using "select by value", so pass Value as
	// 'thirdcolor'
	public static void selectDropDownByValue(WebElement WE, String Value) {
		try {

			Select selObj = new Select(WE);
			selObj.selectByValue(Value);
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to select Drop down by Value");
		}
	}

	public static void MouseOver(WebElement we, WebDriver driver) {
		try {

			Actions actObj = new Actions(driver);
			actObj.moveToElement(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to do Mouse Over");
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		try {
			(new Actions(driver)).dragAndDrop(source, target).perform();
		}
		catch (Exception e) {
			e.printStackTrace();
			// Reporter.log("Error Occured in function switchingFrame
			// "+e.getMessage());
			softAssert.fail("Unable to Drag & Drop");
		}
	}
}
