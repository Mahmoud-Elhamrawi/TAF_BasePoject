package Listeners;

import Utilities.LogUtility;
import org.testng.*;

public class ITestResults implements ITestListener{


    public void onStart(ITestContext context) {
      LogUtility.info("TC"+context.getName()+"start");
    }

    public void onTestSuccess(ITestResult result) {
        LogUtility.info("TC" +result.getStatus());
    }

    public void onTestFailure(ITestResult result) {
        LogUtility.info("TC"+result.getStatus());
    }

    public void onTestSkipped(ITestResult result) {
        LogUtility.info("TC"+result.getStatus());
    }

}
