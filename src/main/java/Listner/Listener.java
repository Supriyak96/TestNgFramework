package Listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import drivers.DriverFactory;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ReportLogger.fail(result.getMethod().getMethodName() + " is failed");
		// attache sc code
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportLogger.skip(result.getMethod().getMethodName() + " is skiped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		Reports.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			Reports.closeReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}