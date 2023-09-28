package Listner;


import drivers.DriverFactory;

public class ReportLogger extends DriverFactory {

	private ReportLogger() {
	}

	public static void pass(String message) {
		ReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ReportManager.getExtentTest().skip(message);
	}
	public static String info(String description) {
		ReportManager.getExtentTest().info(description);
		log.info(description);
		return description;
	}


}
