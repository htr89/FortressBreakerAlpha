package main.fortressbreaker.htr89.minigame.holdtheline.model;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.holdtheline.controller.HoldtheLineController;
import main.fortressbreaker.htr89.minigame.holdtheline.view.HoldtheLineView;
import main.fortressbreaker.htr89.minigame.model.GoldValue;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;
import main.fortressbreaker.htr89.minigame.model.Seconds;

public class HoldtheLineFactory implements MiniGameFactory {

	@Override
	public GoldValue addGoldValue() {
		// TODO Auto-generated method stub
		return new HoldTheLineGoldValue();
	}

	@Override
	public MiniGameController addController(MiniGameView view) {
		// TODO Auto-generated method stub
		return new HoldtheLineController(view);
	}

	@Override
	public Seconds addTime() {
		// TODO Auto-generated method stub
		return new HTLSeconds();

	}

	@Override
	public MiniGameView addView() {
		// TODO Auto-generated method stub
		return new HoldtheLineView();
	}

}
