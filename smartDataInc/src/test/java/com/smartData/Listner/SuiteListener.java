package com.smartData.Listner;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite Execution Started: " + suite.getName());
        // Additional setup or actions before the suite starts
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite Execution Finished: " + suite.getName());
        // Additional teardown or actions after the suite finishes
    }
}