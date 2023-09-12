package testCases;

import Listner.Reports;
import Test_Pages.LoginPage;
import drivers.BaseTest;
import org.testng.annotations.Test;

public class Login1Test extends BaseTest {
    @Test
    public void LoginOrangeHRM() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.loginOrangeHRM("admin123", "Admin");




    }
}
