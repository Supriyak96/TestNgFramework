package Listner;


import com.aventstack.extentreports.model.Media;

import drivers.DriverFactory;

public class ReportLogger extends DriverFactory {

	private ReportLogger() {
	}

	public static void pass(String message) {
		ReportManager.getExtentTest().get().pass(message);
	}

	public static void fail(String message) {
		ReportManager.getExtentTest().get().fail(message);
	}

	public static void skip(String message) {
		ReportManager.getExtentTest().get().skip(message);
	}
	public static String info(String description) {
		ReportManager.getExtentTest().get().info(description);
		log.info(description);
		return description;
	}


}
