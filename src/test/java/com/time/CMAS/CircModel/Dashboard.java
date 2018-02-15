package com.time.CMAS.CircModel;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.time.CMAS.driverSetup.baseDriver;

public class Dashboard extends baseDriver{

	
	@BeforeMethod
	public void startReport(Method method){
		reportLogger = extent.createTest((this.getClass().getSimpleName()+" :: "+method.getName()),method.getName());
	}
	
	@Test(groups = { "smoke" ,"test1_Login"})
	public void dashboard() {
		page.loginPage_CircModel().login();
	}
}
