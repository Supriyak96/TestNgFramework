package testCases;

import java.util.Map;

import org.testng.annotations.Test;


import drivers.BaseTest;
import utils.DataProviderWithExcel;

public class DataProviderTest {
	private DataProviderTest() {
		
	}
	@Test(dataProvider= "getData" , dataProviderClass = DataProviderWithExcel.class)
	public void addUserUsingDataProvider(String username, String middlename , String lastname) {
		System.out.println(username);
		//ReportLogger.pass(username);
		
	}
	
	@Test(dataProvider= "getData1", dataProviderClass = DataProviderWithExcel.class)
	public void addUserUsingDataProvider1(Map <String, String> map) {
		System.out.println(map.get("username"));
		//ReportLogger.pass(username);
		
	}
}
