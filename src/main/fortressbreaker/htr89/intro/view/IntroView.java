package main.fortressbreaker.htr89.intro.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton wood;
	private JButton fight;
	private JButton stone;
	private JButton marble;

	public IntroView() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());

	}

	public void addComponentswithActionListener(ActionListener actionListener) {
		final JPanel inner = new JPanel(new GridLayout(1, 3));
		wood = new JButton("Wood");
		stone = new JButton("Stone");
		marble = new JButton("Marble");
		fight = new JButton("Fight!");
		wood.addActionListener(actionListener);
		stone.addActionListener(actionListener);
		marble.addActionListener(actionListener);
		fight.addActionListener(actionListener);
		this.add(fight, BorderLayout.SOUTH);
		inner.add(wood);
		inner.add(stone);
		inner.add(marble);
		this.add(inner, BorderLayout.CENTER);
		this.doLayout();

	}

	public JButton getStone() {
		return stone;
	}

	public JButton getMarble() {
		return marble;
	}

	public JButton getWood() {
		return wood;
	}

	public JButton getFight() {
		return fight;
	}

}
