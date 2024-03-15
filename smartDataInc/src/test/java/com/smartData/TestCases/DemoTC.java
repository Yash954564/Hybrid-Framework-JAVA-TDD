package com.smartData.TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.smartData.BuisnessLogic.HTMLReportGenerator;
import com.smartData.Config.*;

public class DemoTC extends HTMLReportGenerator{
	@Test(priority = 0)
	public static void demo() throws IOException {
		try {
			test=report.startTest("Demo1");
			test.log(LogStatus.INFO, "Test Started"+test.getStartedTime());
			Config.BLoperation.openURL();
			test.log(LogStatus.PASS," URL opening"+test.addScreenCapture(capture("openurl"))+"");
			Config.BLoperation.sendkey("//input[@id='email']", "admin", "Entering Id");
			Config.BLoperation.sendkey("//input[@id='password']", "password", "Entering Password");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			  
		} 
		
	}
	
}
 