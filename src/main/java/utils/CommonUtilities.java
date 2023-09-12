package utils;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
		ReportLogger.pass( element  + " is clicked");
		
	}
	protected void sendKeys(By by, String value, String value1) {
		expliciteWaitElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
		ReportLogger.pass(value1  + " is entered successfully");
		
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

}
