package testCases;

import org.testng.annotations.Test;

import Test_Pages.AddUserPage;
import Test_Pages.LoginPage;
import drivers.BaseTest;

public class AddUserTest extends BaseTest {
	private AddUserTest() {
		
	}
	@Test()
	public static void AddUserPIM() throws InterruptedException {
	AddUserPage addUser = new AddUserPage();
	LoginPage login = new LoginPage();
	login.loginOrangeHRM("Admin","admin123");
	addUser.addUser("kirti", "john", "smith");

}
	
	
}