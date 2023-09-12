package drivers;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.readPropertyFile;

public final class Driver {
	private Driver() {

	}

	
	public static void initDriver() throws IOException {
		if (Objects.isNull(DriverManager.getDriver()))
		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().get(readPropertyFile.getValue("urlOrangeHRM"));

	}

	public static void quiteDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) 
			DriverManager.getDriver().quit();
		DriverManager.unload();

	}
}

