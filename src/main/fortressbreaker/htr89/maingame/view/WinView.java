package main.fortressbreaker.htr89.maingame.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WinView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel winner;
	private JLabel loser;
	private JButton startAgain;

	public WinView() {
		winner = new JLabel("", SwingConstants.CENTER);
		loser = new JLabel("", SwingConstants.CENTER);
		loser.setFont(new Font("arial", 0, 55));
		winner.setFont(new Font("arial", 0, 55));
		startAgain = new JButton("Restart");
		this.setLayout(new BorderLayout());
		this.add(addCenterPanel(), BorderLayout.CENTER);
		this.add(startAgain, BorderLayout.SOUTH);
	}

	private JPanel addCenterPanel() {
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(2, 2));
		inner.add(winner);
		inner.add(loser);
		inner.add(addwinLabel());
		inner.add(addloseLabel());
		return inner;

	}

	private JLabel addloseLabel() {
		JLabel inner = new JLabel("Loser", SwingConstants.CENTER);
		inner.setFont(new Font("arial", 0, 70));
		return inner;
	}

	private JLabel addwinLabel() {
		JLabel inner = new JLabel("Winner", SwingConstants.CENTER);
		inner.setFont(new Font("arial", 0, 70));
		return inner;
	}

	public JLabel getWinner() {
		return winner;
	}

	public JButton getStartAgain() {
		return startAgain;
	}

	public JLabel getLoser() {
		return loser;
	}

	public void setLoser(JLabel loser) {
		this.loser = loser;
	}

}
