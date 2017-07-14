package main.fortressbreaker.htr89.maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import main.fortressbreaker.htr89.maingame.model.AiModel;
import main.fortressbreaker.htr89.maingame.model.ItemsLogic;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.maingame.view.FortressBreakerView;
import main.fortressbreaker.htr89.maingame.view.UserInteractionsPanel;
import main.fortressbreaker.htr89.maingame.view.WallsAndCatapultView;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class FBGameController implements ActionListener {

	private FortressBreakerView gameFrame;
	private UserInteractionController interactionController;
	private MainGameController gamecontroller;
	private PlayerModel playerModel;
	private AiModel aiModel;

	public FBGameController(MainGameController gamecontroller, PlayerModel playerModel, AiModel aiModel)
			throws IOException {
		this.aiModel = aiModel;
		this.playerModel = playerModel;
		this.gamecontroller = gamecontroller;
		gameFrame = new FortressBreakerView(playerModel.getName());
		gamecontroller.addMainGamePanelControls(gameFrame, this);
		initOtherControllers();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public ItemsLogic getItemsLogicIstance() {
		return interactionController.getItemsLogic();
	}

	private void initOtherControllers() {
		interactionController = new UserInteractionController(this, playerModel, aiModel);
		new WallsAndCatapultController(this, playerModel, aiModel);
	}

	public void addWallsAndCatapultPanel(WallsAndCatapultView wallsAndCatapultView) {
		gameFrame.getWallsAndCatapultsHostPanel().add(wallsAndCatapultView);
	}

	public void addUserInformationsPanel(UserInteractionsPanel interactionsPanel, ActionListener listener) {
		gameFrame.getUserInteractionsPanel().add(interactionsPanel);
	}

	public void theWinnerIs(String winner, String loser) {
		MainFrameSingleton.getInstance().remove(gameFrame);
		gamecontroller.theWinnerIs(winner, loser);

	}

	public void removeOneRocksButton() {
		interactionController.disableOneShotButton();
	}
}
