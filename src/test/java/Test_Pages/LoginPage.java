package Test_Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import Listner.ReportLogger;
import Listner.ReportManager;
import Listner.Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import drivers.BaseTest;
import drivers.DriverManager;
import utils.CommonUtilities;

public class LoginPage extends CommonUtilities {
	
	private final By username = By.name("username");
	private final By password = By.name("password");
	private final By loginBtn = By.xpath("//button[@type='submit']");
	
	

	public void loginOrangeHRM(String value1, String value2) throws InterruptedException {
//		//Explicit wait
//		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//		wait.until((d->d.findElement(username).isEnabled()));
//		
//		WebDriverWait clickableWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//        clickableWait.until(ExpectedConditions.elementToBeClickable(username));
//		//ReportManager.getExtentTest().pass("Enter user name ");
		
		sendKeys(username, value1,"Username");
		sendKeys(password, value2,"Password");
		click(loginBtn,"LoginBtn");		
}
}
