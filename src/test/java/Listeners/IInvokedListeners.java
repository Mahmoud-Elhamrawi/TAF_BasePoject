package Listeners;

import Utilities.LogUtility;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedListeners implements IInvokedMethodListener {


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        LogUtility.info("before invoked");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LogUtility.info("after invoked");
        if(testResult.getStatus()==ITestResult.FAILURE)
        {
            LogUtility.error("TC" + testResult.getName() +"fail");
            Utility.takeScreenShot(getDriver(),testResult.getName());
        }
    }
}
