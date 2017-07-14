package main.fortressbreaker.htr89.maingame.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPanel;

import main.fortressbreaker.htr89.data.FBDAO;
import main.fortressbreaker.htr89.maingame.model.AiModel;
import main.fortressbreaker.htr89.maingame.model.ItemsLogic;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.maingame.view.MainGameView;
import main.fortressbreaker.htr89.market.controller.MarketController;
import main.fortressbreaker.htr89.minigame.controller.MiniGamesController;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class MainGameController {

	private MainGameView mainGameView;
	private PlayerModel playerModel;
	private FBGameController fbGameController;
	private AiModel aiModel;

	public MainGameController(PlayerModel playerModel, AiModel aiModel) {
		this.aiModel = aiModel;
		// TODO Auto-generated constructor stub
		this.playerModel = playerModel;
		mainGameView = new MainGameView();
		MainFrameSingleton.getInstance().add(mainGameView);
		mainGameView.addComponents();
		MainFrameSingleton.getInstance().revalidate();
		this.initOtherControllers();
	}

	private void initOtherControllers() {
		new MiniGamesController(this, playerModel);
		new MarketController(this, playerModel);
		try {
			fbGameController = new FBGameController(this, playerModel, aiModel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ItemsLogic getInstance() {
		return fbGameController.getItemsLogicIstance();

	}

	public void addMarketPanelControls(JPanel panel, ActionListener listener) {
		mainGameView.getMarketPanel().add(panel, BorderLayout.CENTER);
		mainGameView.getMarketPanel().revalidate();

	}

	public void addMainGamePanelControls(JPanel panel, ActionListener listener) {
		mainGameView.getMainGamePanel().add(panel, BorderLayout.CENTER);
		mainGameView.getMainGamePanel().revalidate();

	}

	public void addMiniGamesPanelControls(JPanel panel, ActionListener listener) {
		mainGameView.getMiniGamesPanel().add(panel, BorderLayout.CENTER);
		mainGameView.getMiniGamesPanel().revalidate();

	}

	public void theWinnerIs(String winner, String loser) {
		MainFrameSingleton.getInstance().remove(mainGameView);
		FBDAO fbdao = new FBDAO(playerModel.getUser_ID());
		try {
			fbdao.updateRecordGold("player_Gold", playerModel.getGold());
			fbdao.updateRecordTypeOfWall("typeOfWall", playerModel.getTypeOfWall().getName());
			if (winner == playerModel.getName()) {
				fbdao.updateRecordWins("wins", 1);
			}
			fbdao.updateRecordPlayedGames("playedGames", 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fbdao.closeStatement();
			fbdao.closeConnection();
		}
		new WinController(winner, loser);
		MainFrameSingleton.getInstance().repaint();

	}

}
