package com.smartData.Listner;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("Test Suite Execution Started");
        // Additional setup or actions before the suite execution starts
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test Suite Execution Finished");
        // Additional teardown or actions after the suite execution finishes
    }
}
