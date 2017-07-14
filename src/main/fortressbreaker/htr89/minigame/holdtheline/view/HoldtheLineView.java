package main.fortressbreaker.htr89.minigame.holdtheline.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import main.fortressbreaker.htr89.minigame.model.MiniGameView;

public class HoldtheLineView extends JPanel implements MiniGameView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel holdtheLineMainPanel;

	public HoldtheLineView() {
		super();
		this.setLayout(new GridLayout());
		this.add(addHtLMPanel(), BorderLayout.CENTER);

	}

	private JPanel addHtLMPanel() {
		holdtheLineMainPanel = new JPanel(new GridLayout(1, 0));
		createJScrollBars(holdtheLineMainPanel, 6);

		return holdtheLineMainPanel;

	}

	public void createJScrollBars(JPanel aPanel, int dummInt) {
		for (int i = 0; i < dummInt; i++) {
			aPanel.add(new JScrollBar(1, 0, 1, -5, 6));

		}

	}

	public JPanel getHoldtheLineMainPanel() {
		return holdtheLineMainPanel;
	}

	@Override
	public JPanel gameView() {
		// TODO Auto-generated method stub
		return null;
	}

}
