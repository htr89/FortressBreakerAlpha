package main.fortressbreaker.htr89.minigame.memory.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.controller.MiniGamesController;
import main.fortressbreaker.htr89.minigame.memory.model.MemoryModel;
import main.fortressbreaker.htr89.minigame.memory.view.MemoryView;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;
import main.fortressbreaker.htr89.minigame.view.MiniGamesViewSingleton;

public class MemoryGameController implements ActionListener, MiniGameController {
	private static boolean staticBoolean = false;
	private static String formerButton;
	private MemoryModel refMemLog;
	private List<String> stringTitlesArrList;
	private boolean instanceBoolean;
	int temp1;
	int temp2;
	public int counterToVictory;
	private MemoryView view;

	public MemoryGameController(MiniGameView view) {
		this.view = (MemoryView) view.gameView();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				refMemLog = new MemoryModel();
				stringTitlesArrList = new ArrayList<>();

				MemoryGameController.this.morphArrayToString();

				MiniGamesViewSingleton.getInstance().getGamePanel().add(MemoryGameController.this.view,
						BorderLayout.CENTER);
				MiniGamesViewSingleton.getInstance().getGamePanel().revalidate();
				MiniGamesViewSingleton.getInstance().getGamePanel().doLayout();
				MiniGamesViewSingleton.getInstance().getGamePanel().repaint();
				MemoryGameController.this.fillCardPanel();

			}

		});

	}

	private void fillCardPanel() {
		// TODO Auto-generated method stub
		view.getCardPanel().setLayout(new GridLayout(4, 4));

		this.getStringTitlesArrList().stream().forEach((iterableelement) -> {
			JButton cardButton = new JButton();
			cardButton.setActionCommand(iterableelement);
			cardButton.setPreferredSize(new Dimension(40, 40));
			view.getGraphicButtonsMap().put(iterableelement, cardButton);
			// name.setPreferredSize(buttonsDimension);
			cardButton.addActionListener(this);

			view.getCardPanel().add(cardButton);

		});
		view.paintCards(view.getGraphicButtonsMap());

		view.add(view.getCardPanel(), BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String currentButton = e.getActionCommand();
		staticBoolean = !staticBoolean;
		instanceBoolean = staticBoolean;

		if (instanceBoolean) {
			formerButton = e.getActionCommand();
			view.depaintaCard(e.getActionCommand());
			if (Integer.parseInt(currentButton) > refMemLog.getMatchingListsMap().get(1).size()) {
				temp1 = refMemLog.getMatchingListsMap().get(2).indexOf(Integer.parseInt(currentButton));

			} else if (Integer.parseInt(currentButton) <= refMemLog.getMatchingListsMap().get(1).size()) {
				temp2 = refMemLog.getMatchingListsMap().get(1).indexOf(Integer.parseInt(currentButton));

			}
		} else {
			Thread thread = new Thread(() -> {
				view.depaintaCard(e.getActionCommand());
				for (Component jbutton : view.getCardPanel().getComponents()) {
					if (jbutton instanceof JButton) {
						((JButton) jbutton).removeActionListener(this);
					}
				}

				try {
					if (Integer.parseInt(currentButton) == refMemLog.getMatchingListsMap().get(1).get(temp1)
							|| Integer.parseInt(currentButton) == refMemLog.getMatchingListsMap().get(2).get(temp2)) {
						view.getGraphicButtonsMap().remove(e.getActionCommand());
						counterToVictory++;

						if (counterToVictory == 8) {

							MiniGamesViewSingleton.getInstance().getGamePanel().remove(view);
							MiniGamesViewSingleton.getInstance().remove(2);
							MiniGamesController.winGold = 340;
						}
						readdactionListener();

					} else {
						Thread.sleep(800);
						readdactionListener();

						view.paintaCard(e.getActionCommand());
						view.paintaCard(formerButton);
					}

				} catch (InterruptedException e1) {

				}
			});
			thread.start();

		}
		// System.out.println(instanceBoolean);
		// System.out.println(staticBoolean);
		// System.out.println(e.getActionCommand());
		// System.out.println();

	}

	private void readdactionListener() {
		for (Component jbutton : view.getCardPanel().getComponents()) {
			if (jbutton instanceof JButton) {
				((JButton) jbutton).addActionListener(this);
			}

		}
	}

	public final List<String> morphArrayToString() {
		int[][] tempArray = refMemLog.getMemoryArray();
		for (int[] iterator : tempArray) {
			for (int j = 0; j < tempArray[0].length; j++) {

				stringTitlesArrList.add(Integer.toString(iterator[j]));

			}
		}

		return stringTitlesArrList;
	}

	public List<String> getStringTitlesArrList() {
		return stringTitlesArrList;
	}

	public int getCounterToVictory() {
		return counterToVictory;
	}

	@Override
	public EventListener addController() {
		System.out.println();
		return null;
	}

}
