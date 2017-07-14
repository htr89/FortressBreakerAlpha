package main.fortressbreaker.htr89.minigame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MiniGamesTopView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel timelabel = new JLabel("00:00", SwingConstants.LEFT);
	protected JPanel gamePanel = new JPanel(new BorderLayout());
	protected JButton playagame;
	protected JButton getYourGold;
	protected JButton closeGame;

	public MiniGamesTopView() {
		playagame = new JButton("Play a Game!");
		getYourGold = new JButton("Get your Gold!");
		closeGame = new JButton();
		this.setLayout(new BorderLayout());
		this.add(addNorthPanel(), BorderLayout.NORTH);

		this.add(playagame, BorderLayout.SOUTH);
		this.enanJLabel(timelabel);

	}

	private JPanel addNorthPanel() {
		addIconToCloseGame();
		JPanel inner = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 0.9;
		constraints.ipadx = 300;
		constraints.anchor = GridBagConstraints.WEST;
		inner.add(timelabel, constraints);
		constraints.ipadx = 20;
		constraints.weightx = 0.1;
		constraints.anchor = GridBagConstraints.EAST;
		inner.add(closeGame, constraints);
		return inner;
	}

	private void addIconToCloseGame() {
		try {
			Image img = ImageIO.read(getClass().getClassLoader().getResource("gif/x.png"));
			closeGame.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	private final JLabel enanJLabel(JLabel aLabel) {

		aLabel.setPreferredSize(new Dimension(50, 50));
		aLabel.setFont(new Font("Serif", Font.BOLD, 30));
		return aLabel;
	}

}
