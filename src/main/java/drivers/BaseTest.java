package drivers;

import java.io.IOException;

import Listner.Reports;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected BaseTest() {
	}

	@BeforeMethod()
	public void setUP() throws IOException {
		DriverFactory dr= new DriverFactory();
		dr.initDriver();
	}

	@AfterMethod()
	public void closeBrowser() {
		DriverFactory.quiteDriver();
	}
}
