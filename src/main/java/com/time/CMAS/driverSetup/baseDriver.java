package com.time.CMAS.driverSetup;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.time.CMAS.utilities.PageCollection;
import com.time.CMAS.utilities.Utility;

public class baseDriver {

	public static WebDriver driver;
	// public NgWebDriver ngWebDriver;
	public static ExtentReports extent;
	public static ExtentTest reportLogger;
	public static ExtentHtmlReporter htmlReporter;
	
	public static PageCollection page;

	@BeforeTest
	public void driver() {
		page = new PageCollection(getWebDriver());
	}


	@Parameters({ "browser", "url" })
	@BeforeSuite
	public void setUp(String browser, String url, ITestContext suite) {
		initialize(browser, url);
		//System.out.println("Suite Name--->"+suite.getSuite().getName());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport_"+suite.getSuite().getName()+".html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		// extent.addSystemInfo("Environment","Environment Name")
		// extent.addSystemInfo("Host Name",
		// "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation
		// Testing")
		// .addSystemInfo("User Name", "Rajkumar SM");
		// loading the external xml file (i.e., extent-config.xml) which was
		// placed under the base directory
		// You could find the xml file below. Create xml file in your project
		// and copy past the code mentioned below

		//extent.loadConfig(new File("./Resources/extent-config.xml"));
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create reference of TakesScreenshot
				// logger.log(LogStatus.FAIL, "Test Case Failed is
				// "+result.getName());
				reportLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
				reportLogger.fail("Snapshot below: " + reportLogger.addScreenCaptureFromPath(Utility.takeScreenShot(driver, result.getName())));
				// System.out.println("Screenshot taken");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			reportLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			reportLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		extent.flush();
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		extent.close();
	}

	public void initialize(String browser, String url) {
		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver",
			//		"Resources/drivers/resource/windows/googlechrome/32bit/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// ngWebDriver = new NgWebDriver(driver);
			driver.get(url);
			break;
		default:
			System.out.println("No browser sent");
		}
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}
