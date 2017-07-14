package main.fortressbreaker.htr89.minigame.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiniGamesViewSingleton extends MiniGamesTopView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MiniGamesViewSingleton minigameMainPanel = null;

	private MiniGamesViewSingleton() {
		super();

	}

	public static MiniGamesViewSingleton getInstance() {
		if (minigameMainPanel == null) {
			minigameMainPanel = new MiniGamesViewSingleton();
		}
		return minigameMainPanel;
	}

	public JButton getCloseButton() {
		return closeGame;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public JLabel getSecondsLabel() {
		return timelabel;

	}

	public JButton getPlayButton() {
		return playagame;
	}

	public JButton getGetYourGold() {
		return getYourGold;
	}

}
