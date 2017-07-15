package main.fortressbreaker.htr89.login.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFormView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField insertNameTextfield;
	private JTextField insertUserIDTextF;
	private JButton logButton;

	public LoginFormView() {
		

		final int bordersX = 250;
		final int bordersY = 450;
		this.setLayout(new GridLayout(5, 1, 50, 50));
		this.setBorder(BorderFactory.createEmptyBorder(bordersX, bordersY, bordersX, bordersY));
		this.setOpaque(false);

	}

	/*
	 * here stands the components's initialization and eventually listeners.
	 */
	public final void addComponentsWithListener(ActionListener actionListener) {
		JLabel requestLabel = new JLabel("Enter your Name");
		JLabel secondrequestLabel = new JLabel("Enter your UserID");
		this.enanchLabels(requestLabel, secondrequestLabel);
		insertNameTextfield = new JTextField();
		insertUserIDTextF = new JTextField();
		logButton = new JButton("Log");
		logButton.addActionListener(actionListener);
		this.add(requestLabel);
		this.add(insertNameTextfield);
		this.add(secondrequestLabel);
		this.add(insertUserIDTextF);
		this.add(logButton);
	}

	private void enanchLabels(JLabel... jLabels) {
		for (JLabel jLabel : jLabels) {
			jLabel.setFont(new Font("Courier New", Font.BOLD, 25));
			jLabel.setForeground(Color.red);
		}
	}

	public JTextField getInsertName() {
		return insertNameTextfield;
	}

	public JButton getLogButton() {
		return logButton;
	}

	public JTextField getInsertUserIDTextF() {
		return insertUserIDTextF;
	}

}
