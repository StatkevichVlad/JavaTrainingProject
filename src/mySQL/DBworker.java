package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBworker {
	
	public Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {

		}

		Connection conn = null;

		try {

			System.out.println("Obtaining conn");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/users?" + "user=root&password=");

			System.out.println("Success");

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	
	
}
