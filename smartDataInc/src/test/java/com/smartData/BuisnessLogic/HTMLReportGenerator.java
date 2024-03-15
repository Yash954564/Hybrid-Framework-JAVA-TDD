package com.smartData.BuisnessLogic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HTMLReportGenerator {
	protected static ExtentReports report;
	public static String dest;
	public static String time;
	public static ExtentTest test;

	static {
	    report = new ExtentReports(System.getProperty("user.dir") + "//Reports//ExtentReport//" + "ExtentReportResults"+System.currentTimeMillis()+".html");
	}
	
    public static String capture(String Name)throws IOException {
        File scrFile = ((TakesScreenshot) Operations.driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File(System.getProperty("user.dir") + "//Reports//Screenshots//"+Name+"" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }
    
	@BeforeTest
	public void Reportsetup()
	{
		try
		{
			report = new ExtentReports(System.getProperty("user.dir") + "//Reports//ExtentReport//" + "ExtentReportResults"+System.currentTimeMillis()+".html");
//			report=new ExtentReports("E://StudyWorkpace//ExtentReport_Demo//ExtentReport//Report.html",true);
			//report=new ExtentReports("E://GIT_Project//TestNG_ExtentReport_Maven//ExtentReport//Report"+System.currentTimeMillis()+".html",true);
			report.addSystemInfo("HostName", "Pravin")
			.addSystemInfo("Environment", "SIT")
			.addSystemInfo("User","Ambadas")
			.addSystemInfo("Project Name", "Propchilli.com");
			report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

				
		}
		catch(Exception ex)
		{
			System.out.println("Issue is"+ex.getMessage());
		}
	}
	@AfterMethod
	public void getReport(ITestResult result) {
		try {
			String screnshotpath = capture(result.getName());
			if (result.getStatus() == ITestResult.FAILURE) {

				// String info=result.getThrowable();
				test.log(LogStatus.FAIL, result.getThrowable());
				test.log(LogStatus.FAIL, "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
				test.log(LogStatus.FAIL, "Test Case Fail is:- "+result.getName());


			}
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				test.log(LogStatus.PASS, "Test Case pass is:- "+result.getName());
				test.log(LogStatus.PASS, "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
			}
			else if(result.getStatus()==ITestResult.SKIP)
			{
				test.log(LogStatus.SKIP, "test Case skip is:- "+result.getName());
			}
			else if(result.getStatus()==ITestResult.STARTED)
			{test.log(LogStatus.INFO, "Test Case started");

			}
			report.endTest(test);

		} catch (Exception es) {
			System.out.println(" Report genration Excepion is:- " + es.getMessage());
		}
	}
	@AfterTest
	public void endTest()
	{
		try {
	        if (test != null) {
	            report.endTest(test);
	        }
	    } catch (Exception ex) {
	        System.out.println("Exception while ending test: " + ex.getMessage());
	    } finally {
	        if (report != null) {
	            report.flush();
	            report.close();
	        }
	    }
	}



	
}
