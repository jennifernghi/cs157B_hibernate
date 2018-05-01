package cs157B_hibernate;

import java.sql.*;
/**
 * Logs in and makes connection
 */
public class MakeConnection {

	// Change the userName and Password According to your database
	private static final String USERNAME = "root";
	private static final String PASSWORD= "123";
	private static final String Conn_String= "jdbc:mysql://localhost:3306/cs157b_hibernate?autoReconnect=true&useSSL=false";

	/**
	 * Connects to the database, and returns said connection
	 * @return conn, the connection to the database
	 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			System.out.println("Creating Database..");
			conn = DriverManager.getConnection(Conn_String, USERNAME, PASSWORD);
			System.out.println("MYSQL connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}