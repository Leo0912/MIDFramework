package com.time.CMAS.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static Date d = new Date();
	public static String global_Description = "9 x " + d.getTime();
	static String propFileName = "./src/main/java/com/time/CMAS/utilities/config.properties";

	// Function to take Screenshot
	public static String takeScreenShot(WebDriver driver, String methodName) {
		String path = "";
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("MMddyyyyhhmmss");
			// Save ScreenShot
			FileUtils.copyFile(scrFile, new File("./ErrorSS/Test_" + methodName + "_SS_" + ft.format(dNow) + ".png"));
			path = System.getProperty("user.dir") + "/ErrorSS/Test_" + methodName + "_SS_" + ft.format(dNow) + ".png";
			System.out.println("fn_" + methodName + "_SS_" + ft.format(dNow) + ".png Saved Successfully!!");
		} catch (Exception e) {
			System.out.println("Unable to take Screenshot");
			// e.printStackTrace();
		}
		return path;
	}

	public static String getProperty(String property) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = null;
		try {

			input = new FileInputStream(propFileName);
			prop.load(input);
			// get the property value and print it out
			value = prop.getProperty(property);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
