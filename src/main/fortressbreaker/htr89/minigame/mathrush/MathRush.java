package main.fortressbreaker.htr89.minigame.mathrush;

import main.fortressbreaker.htr89.minigame.model.MiniGame;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;

public class MathRush extends MiniGame {
	MiniGameFactory gameFactory;

	// The enemy ship required parts list is sent to
	// this method. They state that the enemy ship
	// must have a weapon and engine assigned. That
	// object also states the specific parts needed
	// to make a regular UFO versus a Boss UFO

	public MathRush(MiniGameFactory gameFactory) {

		this.gameFactory = gameFactory;

	}

	@Override
	public void makeGame() {
		// TODO Auto-generated method stub
		view = gameFactory.addView();
		controller = gameFactory.addController(gameFactory.addView());

	}

	@Override
	public void giveGold() {
		// TODO Auto-generated method stub
		goldValue = gameFactory.addGoldValue();
	}

	@Override
	public void giveTime() {
		// TODO Auto-generated method stub
		seconds = gameFactory.addTime();
	}

}
