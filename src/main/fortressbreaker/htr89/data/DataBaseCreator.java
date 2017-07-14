package main.fortressbreaker.htr89.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseCreator {

	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	private static String dbName = "HIGHSCORE;";

	public void ensureDataBase() throws Exception {
		Class.forName(jdbcDriver);
		Connection conn = null;
		System.out.println("Creating DATABASE");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=password");
		} catch (Exception e) {
			// TODO: handle exception
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root");
		}
		Statement s = conn.createStatement();
		s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);

		conn.close();
		new DataInText();
		System.out.println("DONE");
	}

}
