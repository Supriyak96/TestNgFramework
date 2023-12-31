package Listner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Reports {
	Reports() {
	}
	static String fileName =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'_report.html'").format(new Date());
	private static ExtentReports reports;

	public static void initReports() {
		if (Objects.isNull(reports)) {
			reports = new ExtentReports();
			ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("Reports/"+fileName);
			htmlReport.config().setTheme(Theme.STANDARD);
			htmlReport.config().setDocumentTitle("Selenium Framework");
			htmlReport.config().setReportName("Orange HRM Test");
			reports.attachReporter(htmlReport);
		}
	}

	public static void createTest(String testCaseName) {
		ReportManager.getExtentTest().set(reports.createTest(testCaseName));
//    ExtentTest test1 = reports.createTest("Login Test");
//        test1.fail("Checking logs");
	}

	public static void closeReport() throws IOException {
		if (Objects.nonNull(reports)) {
			reports.flush();
		}
		Desktop.getDesktop().browse(new File("Reports/"+fileName).toURI());
	}
}
