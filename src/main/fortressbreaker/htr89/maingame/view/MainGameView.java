package main.fortressbreaker.htr89.maingame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainGameView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainGamePanel;
	private JPanel marketPanel;
	private JPanel miniGamesPanel;
	private GridBagConstraints constraints;

	public MainGameView() {
		// TODO Auto-generated constructor stub

		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
	}

	public void addComponents() {

		constraints = new GridBagConstraints();

		// mainGamePanel
		mainGamePanel = new JPanel(new BorderLayout());
		constraints.weightx = constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 2;
		constraints.gridwidth = 2;

		this.add(mainGamePanel, constraints);

		// rightPanels
		constraints.weightx = constraints.weighty = 0.5;

		// marketPanel
		marketPanel = new JPanel(new BorderLayout());
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;

		this.add(marketPanel, constraints);

		// minigamePanel
		miniGamesPanel = new JPanel(new BorderLayout());
		constraints.gridx = 2;
		constraints.gridy = 1;

		this.add(miniGamesPanel, constraints);

	}

	public JPanel getMainGamePanel() {
		return mainGamePanel;
	}

	public JPanel getMarketPanel() {
		return marketPanel;
	}

	public JPanel getMiniGamesPanel() {
		return miniGamesPanel;
	}

}
