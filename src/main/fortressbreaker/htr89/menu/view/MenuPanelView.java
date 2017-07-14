package main.fortressbreaker.htr89.menu.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanelView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton butStart;
	private JButton butInfo;
	private JButton butExit;
	private JButton butPvsAI;
	private JButton butHS;
	private JButton butback;

	public MenuPanelView() throws IOException {

		final int bordersX = 250;
		final int bordersY = 450;
		this.setLayout(new GridLayout(3, 1, 50, 50));
		this.setBorder(BorderFactory.createEmptyBorder(bordersX, bordersY, bordersX, bordersY));
		this.setOpaque(false);

	}

	/**
	 * Use this method to call the first set of Buttons. Start, Rules and Exit.
	 */
	public void addFirstSetListeningButtons(ActionListener actionListener) {
		this.removeAll();
		butStart = new JButton("Start");
		butInfo = new JButton("Rules");
		butExit = new JButton("Exit");
		butExit.addActionListener(actionListener);
		butStart.addActionListener(actionListener);
		butInfo.addActionListener(actionListener);
		this.add(butStart);
		this.add(butInfo);
		this.add(butExit);
		this.doLayout();
	}

	/**
	 * Use this method to call the second set of Buttons. PvsAi, AivsAi and
	 * Back.
	 */

	public void addSecondSetListeningButtons(ActionListener actionListener) {
		this.removeAll();
		butPvsAI = new JButton("Player vs Ai");
		butHS = new JButton("Highscore");
		butback = new JButton("Back");
		butback.addActionListener(actionListener);
		butHS.addActionListener(actionListener);
		butPvsAI.addActionListener(actionListener);
		this.add(butPvsAI);
		this.add(butHS);
		this.add(butback);
		this.doLayout();
	}

}
