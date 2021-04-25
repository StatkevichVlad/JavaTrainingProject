package mySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAthletes {
	
	// id , name , age , weigth , heigth , calories, max_pushup , max_situp, max_airsquat

	private static final String SELECT = "SELECT  * FROM user_athletes WHERE name = ";
	private static final String INSERT = "INSERT INTO users_athletes (name , age , weigth , heigth , calories, max_pushup , max_situp, max_airsquat)  VALUES ('%s' , %d,%d,%d,%d,%d,%d,%d) ";

	private DBworker dbworker;

	public DBAthletes(DBworker bworker) {
		this.dbworker = bworker;
	}

	public void getAthletesByName(String name) {
		Connection conn = dbworker.connection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = SELECT + name;
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("Id :" + rs.getInt("id") + " ,Name :" + rs.getString("name") + ", Age :"
						+ rs.getInt("age") + ", Weigth :" + rs.getInt("weigth") + ", Heigth :" + rs.getInt("heigth")
						+ ", Calories :" + rs.getInt("calories") + ", Max pushup :" + rs.getInt("max_pushup")
						+ ", Max situp :" + rs.getInt("max_situp") + ", Max Airsquat :" + rs.getInt("max_airsquat"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}

		}
	}

	public void createAthlete(String name, int age, int weigth, int heigth, int calories, int maxPushUp, int maxSitUps,
			int maxAirSquat) {
		Connection conn = dbworker.connection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = String.format(INSERT, name, age, weigth, heigth, calories, maxPushUp, maxSitUps, maxAirSquat);
			stmt.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}

		}

	}

}
