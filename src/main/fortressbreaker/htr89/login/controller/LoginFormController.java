package main.fortressbreaker.htr89.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.fortressbreaker.htr89.intro.controller.IntroController;
import main.fortressbreaker.htr89.login.view.LoginFormView;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class LoginFormController implements ActionListener {

	private LoginFormView loginFormView;
	private Connection connect = null;
	private PreparedStatement preparedStmt = null;
	private PlayerModel playerModel;

	public LoginFormController(PlayerModel playerModel) {
		this.playerModel = playerModel;
		loginFormView = new LoginFormView();
		MainFrameSingleton.getInstance().add(loginFormView);
		loginFormView.addComponentsWithListener(this);
		MainFrameSingleton.getInstance().revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		insertInDATA();
		playerModel.setName(loginFormView.getInsertName().getText());
		playerModel.setUser_ID(loginFormView.getInsertUserIDTextF().getText());
		MainFrameSingleton.getInstance().remove(loginFormView);
		MainFrameSingleton.getInstance().repaint();
		new IntroController(playerModel);
	}

	private String insertDatainUsers() throws SQLException {
		// the mysql insert statement
		String query = " insert into Users (player_name, UserID)" + " values (?, ?)";
		return query;
	}

	private void insertInDATA() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/highscore?" + "user=root&password=password");
			if (isUserIDFree()) {

				preparedStmt = connect.prepareStatement(insertDatainUsers());
				preparedStmt.setString(1, loginFormView.getInsertName().getText());
				preparedStmt.setString(2, loginFormView.getInsertUserIDTextF().getText());
				preparedStmt.execute();

			} else {

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				connect.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private boolean isUserIDFree() throws SQLException {
		Statement stmt = connect.createStatement();
		String query = "select UserID from Users ;";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			int numColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= numColumns; i++) {
				// Column numbers start at 1.
				// Also there are many methods on the result set to return
				// the column as a particular type. Refer to the Sun
				// documentation
				// for the list of valid conversions.
				if (rs.getObject(i).equals(loginFormView.getInsertUserIDTextF().getText())) {
					return false;
				}
			}

		}
		return true;
	}

}
