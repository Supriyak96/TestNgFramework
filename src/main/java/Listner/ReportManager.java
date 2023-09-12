package Listner;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ReportManager {
private ReportManager() {
}

    private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    static void unloadExtent() {
        extTest.remove();
    }

}


