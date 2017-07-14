package main.fortressbreaker.htr89.minigame.model;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;

public abstract class MiniGame {
	private String name;

	// Newly defined objects that represent weapon & engine
	// These can be changed easily by assigning new parts
	// in UFOEnemyShipFactory or UFOBossEnemyShipFactory
	protected Seconds seconds;
	protected GoldValue goldValue;
	protected MiniGameController controller;
	protected MiniGameView view;

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public abstract void makeGame();

	public abstract void giveGold();

	public abstract void giveTime();

}
