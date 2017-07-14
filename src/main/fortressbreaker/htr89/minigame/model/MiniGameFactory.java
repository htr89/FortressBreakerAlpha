package main.fortressbreaker.htr89.minigame.model;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;

public interface MiniGameFactory {
	public GoldValue addGoldValue();

	public MiniGameController addController(MiniGameView view);

	public Seconds addTime();

	public MiniGameView addView();

}
