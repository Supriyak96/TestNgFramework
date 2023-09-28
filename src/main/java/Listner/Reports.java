package Listner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Reports {
	Reports() {
	}

	private static ExtentReports reports;

	public static void initReports() {
		if (Objects.isNull(reports)) {
			reports = new ExtentReports();
			ExtentSparkReporter sparkReport = new ExtentSparkReporter("target/Reports.html");
			sparkReport.config().setTheme(Theme.STANDARD);
			sparkReport.config().setDocumentTitle("Selenium Framework");
			sparkReport.config().setReportName("Orange HRM Test");
			reports.attachReporter(sparkReport);
		}
	}

	public static void createTest(String testCaseName) {
		ReportManager.setExtentTest(reports.createTest(testCaseName));
//    ExtentTest test1 = reports.createTest("Login Test");
//        test1.fail("Checking logs");
	}

	public static void closeReport() throws IOException {
		if (Objects.nonNull(reports)) {
			reports.flush();
		}
		Desktop.getDesktop().browse(new File("target/Reports.html").toURI());
	}
}
