package Listner;

public class ReportLogger {
	
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
}
