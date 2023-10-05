package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listner.ReportLogger;
import drivers.DriverManager;

public class CommonUtilities {
	protected void expliciteWaitElementToBeClickable(By by) {
		WebDriverWait clickableWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		clickableWait.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected void click(By by, String element) {
		expliciteWaitElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).click();
		ReportLogger.pass(element + " is clicked");
	}

	protected void sendKeys(By by, String value, String value1) {
		expliciteWaitElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
		ReportLogger.pass(value1 + " is entered successfully");
	}

	public static boolean isNotVisible(By element, String elementName) {
		try {
			if ((DriverManager.getDriver().findElement(element).isDisplayed())) {
				System.out.println(elementName + " is Displayed");
				return false;
			}
		} catch (Exception ex) {
			return true;
		}
		return true;
	}
	
	public static String getScreenshotName(String methodName) {
//		Date date = new Date() ;
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		String fileName =new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.png'").format(new Date());
		
//		String file = methodName + "_" + fileName  + ".png";
		return methodName + "_" + fileName;
	}

	
	public static String takeScreenshot(String methodName) throws FileNotFoundException {
		String fileName = getScreenshotName(methodName);		
		String directory = "/Reports/screenshots/";
		new File(directory).mkdirs();
		String path = System.getProperty("user.dir")+directory + fileName;
		try {
			File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
		} catch (Exception e) {
		}
		return path;
}
}