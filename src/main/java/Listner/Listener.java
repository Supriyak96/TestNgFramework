package Listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import utils.CommonUtilities;

public class Listener  implements ITestListener {

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
		String methodName = result.getMethod().getMethodName();
		String path = "";

		try {
			path = CommonUtilities.takeScreenshot(methodName);
			ReportManager.getExtentTest().get().fail("<b><font color=red> Screenshot of failure</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception ex) {
			ReportManager.getExtentTest().get().fail("Test Failed, unable to attach screenshot.");
		}

	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		ReportLogger.skip(result.getMethod().getMethodName() + " is skiped");
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