package main.fortressbreaker.htr89.minigame.mathrush.model;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.mathrush.controller.MathRushController;
import main.fortressbreaker.htr89.minigame.mathrush.view.MathRushView;
import main.fortressbreaker.htr89.minigame.model.GoldValue;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;
import main.fortressbreaker.htr89.minigame.model.Seconds;

public class MathRushFactory implements MiniGameFactory {

	@Override
	public GoldValue addGoldValue() {
		// TODO Auto-generated method stub
		return new MathRushGoldValue();
	}

	@Override
	public MiniGameController addController(MiniGameView view) {
		// TODO Auto-generated method stub
		return new MathRushController(view);
	}

	@Override
	public Seconds addTime() {
		// TODO Auto-generated method stub
		return new MathRushSeconds();
	}

	@Override
	public MiniGameView addView() {
		// TODO Auto-generated method stub
		return new MathRushView();
	}

}
