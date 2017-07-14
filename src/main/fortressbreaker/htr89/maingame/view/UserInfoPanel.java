package main.fortressbreaker.htr89.maingame.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserInfoPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel playerOneLabel;
	private JLabel playerTwoLabel;
	private JLabel roundlabel;
	private JLabel todecideLabel1;

	public UserInfoPanel() {
		playerOneLabel = new JLabel("Player 1");
		playerTwoLabel = new JLabel("Nikolas Starkarm");
		roundlabel = new JLabel("Start");
		todecideLabel1 = new JLabel("ehi");
	}

	public JLabel getPlayerTwoLabel() {

		return playerTwoLabel;
	}

	public JLabel getPlayerOneLabel() {

		return playerOneLabel;
	}

	public JLabel getRoundlabel() {

		roundlabel.setHorizontalAlignment(SwingConstants.CENTER);
		return roundlabel;
	}

	// public JLabel getTodecideLabel2() {
	// todecideLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	// return todecideLabel2;
	// }

	public JLabel getTodecideLabel1() {
		todecideLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		return todecideLabel1;
	}

}
