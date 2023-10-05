package testCases;

import org.testng.annotations.Test;

import Test_Pages.AddUserPage;
import Test_Pages.LoginPage;
import drivers.BaseTest;
import utils.DataProviderWithExcel;

public class AddUserTest extends BaseTest {
	private AddUserTest() {

	}

	@Test
	public void AddUserPIM() throws InterruptedException {
		AddUserPage addUser = new AddUserPage();
		LoginPage login = new LoginPage();
		login.loginOrangeHRM("Admin", "admin123");
		addUser.addUser("Name", "Middlename", "Lastname");
	}
	
	
	@Test(dataProvider= "getData" , dataProviderClass = DataProviderWithExcel.class)
	public void AddUserPIMDataProvider(String name, String middleName , String lastName) throws InterruptedException {
		AddUserPage addUser = new AddUserPage();
		LoginPage login = new LoginPage();
		login.loginOrangeHRM("Admin", "admin123");
		addUser.addUser(name, middleName, lastName);
	}
}