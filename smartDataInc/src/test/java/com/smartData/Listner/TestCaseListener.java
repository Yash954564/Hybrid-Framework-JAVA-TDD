package com.smartData.Listner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestCaseListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Case '" + result.getName() + "' Execution Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case '" + result.getName() + "' Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case '" + result.getName() + "' Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case '" + result.getName() + "' Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used in this example
    }

    @Override
    public void onStart(ITestContext context) {
        // Not used in this example
    }

    @Override
    public void onFinish(ITestContext context) {
        // Not used in this example
    }

}
