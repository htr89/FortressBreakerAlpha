package main.fortressbreaker.htr89.minigame.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.util.Random;

import javax.swing.JButton;

import main.fortressbreaker.htr89.maingame.controller.MainGameController;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.minigame.model.MiniGameBuilding;
import main.fortressbreaker.htr89.minigame.model.MiniGamesBuilder;
import main.fortressbreaker.htr89.minigame.view.MiniGamesViewSingleton;

public class MiniGamesController implements ActionListener {

	public static boolean isStop = false;

	public static int winGold = 0;

	private MainGameController gamecontroller;

	private JButton tempJButton;

	private MiniGameBuilding makeMinigame;

	private PlayerModel playerModel;

	public MiniGamesController(MainGameController controller, PlayerModel playerModel) {
		this.playerModel = playerModel;
		this.gamecontroller = controller;

		gamecontroller.addMiniGamesPanelControls(MiniGamesViewSingleton.getInstance(), this);
		MiniGamesViewSingleton.getInstance().getPlayButton().addActionListener(this);
		MiniGamesViewSingleton.getInstance().getCloseButton()
				.addActionListener(e -> MiniGamesViewSingleton.getInstance().remove(2));

		MiniGamesViewSingleton.getInstance().getGamePanel().addHierarchyListener(new HierarchyListener() {

			@Override
			public void hierarchyChanged(HierarchyEvent e) {

				if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
					if (e.getComponent().isDisplayable()) {

					} else {
						tempJButton.setEnabled(true);
						isStop = true;
						MiniGamesViewSingleton.getInstance().getSecondsLabel().setText("00:00");
						MiniGamesViewSingleton.getInstance().getGamePanel().removeAll();
						if (winGold != 0) {
							MiniGamesController.this.playerModel.setGold(playerModel.getGold() + winGold);
							winGold = 0;
						} else {
							MiniGamesController.this.playerModel
									.setGold(playerModel.getGold() + makeMinigame.getEarnedGold());
						}

					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MiniGamesController.isStop = false;
		if (e.getSource() instanceof JButton) {
			tempJButton = (JButton) e.getSource();
			tempJButton.setEnabled(false);

		}
		MiniGamesViewSingleton.getInstance().add(MiniGamesViewSingleton.getInstance().getGamePanel(),
				BorderLayout.CENTER);
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;

		makeMinigame = new MiniGamesBuilder();
		makeMinigame.orderTheGame(randomNum);

	}

}
