package testCases;

import Listner.Reports;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test_Pages.LoginPage;
import Test_Pages.LogoutPage;
import drivers.BaseTest;
import drivers.DriverManager;

public final class LoginTest extends BaseTest{
	private LoginTest() {

	}

	@Test
	public void LoginLogoutOrangeHRM() throws InterruptedException {
		LogoutPage logout =new LogoutPage();
		LoginPage login = new LoginPage();
		login.loginOrangeHRM("Admin","admin123");
		
		String s = DriverManager.getDriver().getTitle();
		Assert.assertEquals(s, "OrangeHRM");
		logout.logoutOrangeHRM();
		
	}
}
