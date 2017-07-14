package main.fortressbreaker.htr89.maingame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class WallsAndCatapultView extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints bagConstrains;
	private JPanel centralPanel;
	private JLabel player2Label;
	private JLabel player1Label;
	private JButton btnCat1;
	private JButton btnCat2;

	public WallsAndCatapultView() {
		// TODO Auto-generated constructor stub
		btnCat1 = new JButton();
		btnCat2 = new JButton();
		centralPanel = new JPanel(new GridBagLayout());
		this.setLayout(new OverlayLayout(this));

		bagConstrains = new GridBagConstraints();
		this.setOpaque(false);
		setCentralPanel();
		this.add(centralPanel);
	}

	private void setCentralPanel() {
		centralPanel.setOpaque(false);
		setCatPlayer();
		setP1Wall();
		setP2Wall();
		setCatAi();
	}

	private void setCatPlayer() {
		// bagConstrains.gridx = 2;
		// bagConstrains.gridy = 12;
		bagConstrains.weightx = 1.0;
		bagConstrains.weighty = 1.0;
		bagConstrains.anchor = GridBagConstraints.SOUTHWEST;
		try {
			Image img = ImageIO.read(getClass().getClassLoader().getResource("gif/cat.png"));
			btnCat1.setIcon(new ImageIcon(img));
		} catch (Exception ex) {

		}
		btnCat1.setBorderPainted(false);
		btnCat1.setContentAreaFilled(false);
		btnCat1.setFocusPainted(false);
		btnCat1.setOpaque(false);

		centralPanel.add(btnCat1, bagConstrains);
	}

	private void setP1Wall() {

		player1Label = new JLabel();
		//
		// bagConstrains.gridx = 6;
		// bagConstrains.gridy = 12;
		player1Label.setOpaque(false);
		player1Label.setLayout(new GridLayout(0, 1));
		centralPanel.add(player1Label, bagConstrains);

	}

	private void setP2Wall() {

		player2Label = new JLabel();

		bagConstrains.anchor = GridBagConstraints.SOUTHEAST;
		player2Label.setOpaque(false);
		player2Label.setLayout(new GridLayout(0, 1));
		centralPanel.add(player2Label, bagConstrains);

	}

	private void setCatAi() {
		// bagConstrains.gridx = 11;
		// bagConstrains.gridy = 12;

		try {
			Image img = ImageIO.read(getClass().getClassLoader().getResource("gif/cat2.png"));
			btnCat2.setIcon(new ImageIcon(img));
		} catch (Exception ex) {

		}
		btnCat2.setBorderPainted(false);
		btnCat2.setContentAreaFilled(false);
		btnCat2.setFocusPainted(false);
		btnCat2.setOpaque(false);

		centralPanel.add(btnCat2, bagConstrains);
	}

	public JLabel getPlayer2Panel() {
		return player2Label;
	}

	public JLabel getPlayer1Panel() {
		return player1Label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBtnCat1() {
		return btnCat1;
	}

	public JButton getBtnCat2() {
		return btnCat2;
	}

	public GridBagConstraints getBagConstrains() {
		return bagConstrains;
	}

}