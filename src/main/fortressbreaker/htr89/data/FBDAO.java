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

	/**
	 * This method will update a numeric value in the Database, all the actual
	 * numeric values are integer. It will get the current value before summing
	 * it to the new one.
	 * 
	 * @param columnsName
	 *            the current Actual Parameters can be: "player_Gold",
	 *            "playedGames" and "wins"
	 * @param numericValue
	 */
	public void updateNumericRecord(String columnsName, int numericValue) {
		int recordedNumber;
		try {
			recordedNumber = this.getCurrentValue(columnsName);
			this.updateRecordNumericValue(columnsName, recordedNumber + numericValue);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private int getCurrentValue(String columnsName) throws SQLException {
		Statement st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st
				.executeQuery("SELECT " + columnsName + " FROM Users WHERE UserID = " + "'" + this.userId + "'");
		int recordedNumber = 0;
		if (rs.next()) {
			recordedNumber += rs.getInt(1);
		}
		st.close();
		rs.close();
		return recordedNumber;
	}

	private void updateRecordNumericValue(String columnsName, int numericValue) throws SQLException {

		String updateTableSQL = "UPDATE Users SET " + columnsName + " = ?" + " WHERE UserID = ?";

		preparedStatement = dbConnection.prepareStatement(updateTableSQL);

		preparedStatement.setInt(1, numericValue);
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