package main.fortressbreaker.htr89.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is meant to save in a text file all the end-results of the game.
 * It will be used only if the game reachs the last step. The Text file is
 * created with a string builder.
 */

public class DataInText {
	private Connection connect = null;
	

	public DataInText() {
		// TODO Auto-generated constructor stub
		try {
			this.addTabletoDataBase();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addTabletoDataBase() throws Exception {
		Statement statement = null;
		// This will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/highscore?user=root&password=password");
		} catch (Exception e) {
			// TODO: handle exception
			connect = DriverManager.getConnection("jdbc:mysql://localhost/highscore?user=root");
		} // or
			// user=root

		// Statements allow to issue SQL queries to the database
		statement = connect.createStatement();
		// Result set get the result of the SQL query
		statement.execute(createTable());

		connect.close();

	}

	private String createTable() throws SQLException {
		String sqlCreate = "CREATE TABLE IF NOT EXISTS Users" + "   (UserID VARCHAR(50) NOT NULL,"
				+ "   player_name VARCHAR(50)," + "   typeOfWall VARCHAR(50),"
				+ "   player_Gold INT NOT NULL DEFAULT 0," + "   playedGames INT NOT NULL DEFAULT 0,"
				+ "   wins INT NOT NULL DEFAULT 0," + "   PRIMARY KEY (UserID))";
		return sqlCreate;

	}
}