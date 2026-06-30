package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=================================");
        System.out.println("STARTED : " + result.getName());
        System.out.println("=================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=================================");
        System.out.println("PASSED : " + result.getName());
        System.out.println("=================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=================================");
        System.out.println("FAILED : " + result.getName());
        System.out.println("Reason : " + result.getThrowable());
        System.out.println("=================================");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("=================================");
        System.out.println("SKIPPED : " + result.getName());
        System.out.println("=================================");
    }
}