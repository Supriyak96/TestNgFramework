package Test_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.DriverManager;
import utils.CommonUtilities;

public class LogoutPage extends CommonUtilities {
	private final By welcomeLink = By.className("oxd-userdropdown-img");
	private final By logoutBtn = By.xpath("//a[text()='Logout']");

	public void logoutOrangeHRM() throws InterruptedException {
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until((d -> d.findElement(welcomeLink).isEnabled()));
		click(welcomeLink, "WelcomeLink");
		click(logoutBtn, "LogoutBtn");
	}
}