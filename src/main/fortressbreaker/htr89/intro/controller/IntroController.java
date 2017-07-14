package main.fortressbreaker.htr89.intro.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import main.fortressbreaker.htr89.intro.view.IntroView;
import main.fortressbreaker.htr89.maingame.controller.MainGameController;
import main.fortressbreaker.htr89.maingame.model.AiModel;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.maingame.model.RockModel;
import main.fortressbreaker.htr89.maingame.model.RockModel.TypeOfStone;
import main.fortressbreaker.htr89.maingame.model.WallModel;
import main.fortressbreaker.htr89.maingame.model.WallModel.TypeOfWall;
import main.fortressbreaker.htr89.view.MainFrameSingleton;

public class IntroController implements ActionListener {

	private IntroView introView;
	private WallModel typeOfWall;
	private PlayerModel playerModel;
	private AiModel aiModel;

	public IntroController(PlayerModel playerModel) {

		aiModel = new AiModel();
		// TODO Auto-generated constructor stub
		this.playerModel = playerModel;

		introView = new IntroView();
		MainFrameSingleton.getInstance().add(introView);
		introView.addComponentswithActionListener(this);
		introView.getFight().setEnabled(false);
		MainFrameSingleton.getInstance().revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == introView.getFight()) {
			MainFrameSingleton.getInstance().remove(introView);
			MainFrameSingleton.getInstance().repaint();
			initAiWall();
			initPlayerBaseStone();
			initAIBaseStone();
			new MainGameController(playerModel, aiModel);

		} else if (e.getSource() == introView.getWood()) {
			isWood();
		} else if (e.getSource() == introView.getStone()) {
			isStone();
		} else if (e.getSource() == introView.getMarble()) {
			isMarble();
		}

	}

	private void isMarble() {
		introView.getFight().setEnabled(true);
		try {
			typeOfWall = new WallModel(TypeOfWall.MARBLE);
			playerModel.setTypeOfWall(typeOfWall);
			playerModel.setGold(25); // this will set the Gold to a specific
										// amount. It's not a subtraction to
										// keep resets possible.
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		introView.getMarble().setEnabled(false);
	}

	private void isStone() {
		introView.getFight().setEnabled(true);
		try {
			typeOfWall = new WallModel(TypeOfWall.STONE);
			playerModel.setTypeOfWall(typeOfWall);
			playerModel.setGold(35); // this will set the Gold to a specific
										// amount. It's not a subtraction to
										// keep resets possible.
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		introView.getStone().setEnabled(false);
	}

	private void initPlayerBaseStone() {
		try {
			RockModel playerRock = new RockModel(TypeOfStone.WEAK);
			playerModel.setTypeOfRock(playerRock);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void initAIBaseStone() {
		try {
			RockModel playerRock = new RockModel(TypeOfStone.WEAK);
			aiModel.setTypeOfRock(playerRock);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void initAiWall() {
		try {
			WallModel aiTypeOfWall = new WallModel(TypeOfWall.STONE);
			aiModel.setTypeOfWall(aiTypeOfWall);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void isWood() {
		introView.getFight().setEnabled(true);
		try {
			typeOfWall = new WallModel(TypeOfWall.WOOD);
			playerModel.setTypeOfWall(typeOfWall);
			playerModel.setGold(45); // this will set the Gold to a specific
										// amount. It's not a subtraction to
										// keep resets possible.
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		introView.getWood().setEnabled(false);
	}

}
