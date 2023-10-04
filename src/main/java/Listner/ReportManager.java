package Listner;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ReportManager {
	private ReportManager() {
	}
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public static ThreadLocal<ExtentTest> getExtentTest() {
		return extentTest;
	}

//	public static void setExtentTest(ThreadLocal<ExtentTest> test) {
//		extTest.set(test);
//	}
//
//	static void unloadExtent() {
//		extTest.remove();
//	}
}
