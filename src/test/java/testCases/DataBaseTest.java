package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class DataBaseTest {
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	@BeforeClass
	public void setUp() {
		String databaseURL = "jdbc:mysql://localhost:3306/supriya";
		String user = "root";
		String password = "root";
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the Database...");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void getEmployeesFromDataBase() {
		try {
			String query = "select * from StudentDetails";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				int RollNo = rs.getInt("RollNo");
				String Name = rs.getString("name");
//	                String EmpAddress=rs.getString(3);
//	                String EmpDept=rs.getString("EmpDept");
//	                Double EmpSal= rs.getDouble(5);
				System.out.println(RollNo + "\t" + Name + "\t");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
