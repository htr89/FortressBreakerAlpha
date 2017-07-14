package main.fortressbreaker.htr89.minigame.holdtheline;

import main.fortressbreaker.htr89.minigame.model.MiniGame;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;

public class HoldTheLine extends MiniGame {
	private MiniGameFactory gameFactory;

	public HoldTheLine(MiniGameFactory gameFactory) {

		this.gameFactory = gameFactory;
	}

	@Override
	public void makeGame() {

		view = gameFactory.addView();
		controller = gameFactory.addController(gameFactory.addView());
	}

	@Override
	public void giveGold() {

		goldValue = gameFactory.addGoldValue();
	}

	@Override
	public void giveTime() {

		seconds = gameFactory.addTime();

	}

}
