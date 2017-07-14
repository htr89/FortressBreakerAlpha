package main.fortressbreaker.htr89.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FBDAO {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/highscore";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";
	private String userId;
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;

	public FBDAO(String user_ID2) {
		this.userId = user_ID2;
		dbConnection = getDBConnection();

	}

	public void updateRecordWins(String columnsName, int winCounter) throws SQLException {

		String updateTableSQL = "UPDATE Users SET " + columnsName + " = ?" + " WHERE UserID = ?";

		Statement st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st
				.executeQuery("SELECT " + columnsName + " FROM Users WHERE UserID = " + "'" + this.userId + "'");
		if (rs.next()) {
			winCounter += rs.getInt(1);
		}
		st.close();
		rs.close();

		preparedStatement = dbConnection.prepareStatement(updateTableSQL);

		preparedStatement.setInt(1, winCounter);
		preparedStatement.setString(2, this.userId);

		// execute update SQL stetement
		preparedStatement.executeUpdate();

		System.out.println("Record is updated to Users table!");

	}

	public void updateRecordTypeOfWall(String columnsName, String typeOfWall) throws SQLException {
		String updateTableSQL = "UPDATE Users SET " + columnsName + " = ?" + " WHERE UserID = ?";
		preparedStatement = dbConnection.prepareStatement(updateTableSQL);

		preparedStatement.setString(1, typeOfWall);
		preparedStatement.setString(2, this.userId);

		// execute update SQL stetement
		preparedStatement.executeUpdate();

		System.out.println("Record is updated to Users table!");
	}

	public void updateRecordGold(String columnsName, int gold) throws SQLException {
		this.updateRecordWins(columnsName, gold);
	}

	public void updateRecordPlayedGames(String columnsName, int playedGames) throws SQLException {
		this.updateRecordWins(columnsName, playedGames);
	}

	public void closeStatement() {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void closeConnection() {
		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}