package main.fortressbreaker.htr89.login.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginRequestPanelView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel questionLabel;
	private JButton yes;
	private JButton no;

	public LoginRequestPanelView() {
		// TODO Auto-generated constructor stub
		final int bordersX = 250;
		final int bordersY = 450;
		this.setLayout(new GridLayout(3, 1, 50, 50));
		this.setBorder(BorderFactory.createEmptyBorder(bordersX, bordersY, bordersX, bordersY));
		this.setOpaque(false);

	}

	public void addComponentswithActionListener(ActionListener actionListener) {
		questionLabel = new JLabel("Would you like to log?");
		this.enancheQuestionLabel();
		yes = new JButton("Yes");
		no = new JButton("No");
		yes.addActionListener(actionListener);
		no.addActionListener(actionListener);
		this.add(questionLabel);
		this.add(yes);
		this.add(no);
		this.doLayout();

	}

	private void enancheQuestionLabel() {
		questionLabel.setForeground(Color.ORANGE);
		questionLabel.setFont(new Font("Courier New", Font.BOLD, 45));
	}

}
