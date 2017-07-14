package main.fortressbreaker.htr89.maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;

import main.fortressbreaker.htr89.maingame.animation.controller.RockAnimationController;
import main.fortressbreaker.htr89.maingame.model.AiModel;
import main.fortressbreaker.htr89.maingame.model.DamageLogic;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.maingame.view.WallsAndCatapultView;

public class WallsAndCatapultController implements ActionListener {

	private FBGameController fbGameController;
	private WallsAndCatapultView wallsAndCatapultView;
	private URL url;
	private PlayerModel playerModel;
	private AiModel aiModel;

	public WallsAndCatapultController(FBGameController fbGameController, PlayerModel playerModel, AiModel aiModel) {
		this.aiModel = aiModel;
		this.playerModel = playerModel;
		// TODO Auto-generated constructor stub
		this.fbGameController = fbGameController;
		wallsAndCatapultView = new WallsAndCatapultView();
		shapeWalls();
		this.fbGameController.addWallsAndCatapultPanel(wallsAndCatapultView);
		wallsAndCatapultView.getBtnCat1().addActionListener(this);
	}

	private void shapeWalls() {
		if ("WOOD".equals(playerModel.getTypeOfWall().getName())) {
			isWood();
		} else if ("STONE".equals(playerModel.getTypeOfWall().getName())) {
			isStone();
		} else if ("MARBLE".equals(playerModel.getTypeOfWall().getName())) {
			isMarble();
		}
		if ("STONE".equals(aiModel.getTypeOfWall().getName())) {
			isStoneAi();
		}

	}

	private void isStoneAi() {
		url = getClass().getClassLoader().getResource("gif/sw.png");
		ImageIcon imgThisImg = new ImageIcon(url);
		wallsAndCatapultView.getPlayer2Panel().setIcon(imgThisImg);
		wallsAndCatapultView.getPlayer2Panel().revalidate();
	}

	private void isWood() {
		url = getClass().getClassLoader().getResource("gif/ww.png");
		ImageIcon imgThisImg = new ImageIcon(url);
		wallsAndCatapultView.getPlayer1Panel().setIcon(imgThisImg);
		wallsAndCatapultView.getPlayer1Panel().revalidate();

	}

	private void isMarble() {
		url = getClass().getClassLoader().getResource("gif/mw.png");
		ImageIcon imgThisImg = new ImageIcon(url);
		wallsAndCatapultView.getPlayer1Panel().setIcon(imgThisImg);
		wallsAndCatapultView.getPlayer1Panel().revalidate();

	}

	private void isStone() {
		url = getClass().getClassLoader().getResource("gif/sw.png");
		ImageIcon imgThisImg = new ImageIcon(url);
		wallsAndCatapultView.getPlayer1Panel().setIcon(imgThisImg);
		wallsAndCatapultView.getPlayer1Panel().revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == wallsAndCatapultView.getBtnCat1()) {
			if (fbGameController.getItemsLogicIstance().getNumberOfShots() > 0) {
				fbGameController.removeOneRocksButton();
				RockAnimationController animationController = new RockAnimationController();

				wallsAndCatapultView.add(animationController.getRefRockAnimView(),
						wallsAndCatapultView.getBagConstrains());
				wallsAndCatapultView.repaint();
				wallsAndCatapultView.doLayout();
				wallsAndCatapultView.revalidate();
				playerModel.setNumberOfShots(playerModel.getNumberOfShots() - 1);
				fbGameController.getItemsLogicIstance()
						.setNumberOfShots(fbGameController.getItemsLogicIstance().getNumberOfShots() - 1);
				new DamageLogic(playerModel, aiModel).playerDamagesAI();
			}

		}
		if (aiModel.getTypeOfWall().getHitPoints() <= 0.0) {
			fbGameController.theWinnerIs(playerModel.getName(), aiModel.getName());
		}
	}

}
