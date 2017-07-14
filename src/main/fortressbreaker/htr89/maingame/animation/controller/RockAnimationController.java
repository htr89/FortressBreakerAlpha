package main.fortressbreaker.htr89.maingame.animation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.fortressbreaker.htr89.maingame.animation.model.RockAnimationModel;
import main.fortressbreaker.htr89.maingame.animation.view.RockAnimationView;

public class RockAnimationController implements ActionListener {
	private RockAnimationModel refRockAnimModel;
	private RockAnimationView refRockAnimView;

	public RockAnimationController() {

		// TODO Auto-generated constructor stub
		refRockAnimModel = new RockAnimationModel(100, this);
		refRockAnimView = new RockAnimationView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		refRockAnimModel.testMovement();
		refRockAnimView.setStartPositionX(refRockAnimModel.getStartPositionX());
		refRockAnimView.setStartPositionY(refRockAnimModel.getStartPositionY());
		refRockAnimView.repaint();

	}

	public RockAnimationView getRefRockAnimView() {
		return refRockAnimView;
	}
}
