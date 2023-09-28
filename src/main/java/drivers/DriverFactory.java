package drivers;

import java.io.IOException;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.readPropertyFile;

public class DriverFactory {
	protected DriverFactory() {

	}

	public static Logger log = null;
	 void initDriver() throws IOException {
		if (Objects.isNull(DriverManager.getDriver()))	
		DriverManager.setDriver(new ChromeDriver());
		log = Logger.getLogger(getClass());
		String path = System.getProperty("user.dir");
		PropertyConfigurator.configure(path + "./src/main/resource/log4j.properties");
		DriverManager.getDriver().get(readPropertyFile.getValue("urlOrangeHRM"));

	}

	public static void quiteDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) 
			DriverManager.getDriver().quit();
		DriverManager.unload();

	}
}

