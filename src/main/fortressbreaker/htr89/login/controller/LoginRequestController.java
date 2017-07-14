package main.fortressbreaker.htr89.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import main.fortressbreaker.htr89.data.DataBaseCreator;
import main.fortressbreaker.htr89.intro.controller.IntroController;
import main.fortressbreaker.htr89.login.view.LoginRequestPanelView;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class LoginRequestController implements ActionListener {

	private LoginRequestPanelView loginPanelView;
	

	public LoginRequestController() throws IOException {
		// TODO Auto-generated constructor stub
		loginPanelView = new LoginRequestPanelView();
		MainFrameSingleton.getInstance().add(loginPanelView);

		loginPanelView.addComponentswithActionListener(LoginRequestController.this);
		MainFrameSingleton.getInstance().revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		MainFrameSingleton.getInstance().remove(loginPanelView);
		MainFrameSingleton.getInstance().repaint();

		PlayerModel playerModel = new PlayerModel();
		switch (button.getText()) {

		case "Yes":
			try {
				new DataBaseCreator().ensureDataBase();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new LoginFormController(playerModel);

			break;
		case "No":
			new IntroController(playerModel);
			break;

		default:
			break;
		}

	}

}
