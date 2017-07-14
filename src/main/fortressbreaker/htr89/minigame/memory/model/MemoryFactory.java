package main.fortressbreaker.htr89.minigame.memory.model;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.memory.controller.MemoryGameController;
import main.fortressbreaker.htr89.minigame.memory.view.MemoryView;
import main.fortressbreaker.htr89.minigame.model.GoldValue;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;

public class MemoryFactory implements MiniGameFactory {

	@Override
	public GoldValue addGoldValue() {

		return new MemoryGoldValue();
	}

	@Override
	public MiniGameController addController(MiniGameView view) {

		return new MemoryGameController(view);
	}

	@Override
	public MemorySeconds addTime() {

		return new MemorySeconds();
	}

	@Override
	public MiniGameView addView() {

		return new MemoryView();
	}

	// public static class Builder {
	//
	// private GoldValue goldValue = new MemoryGoldValue(); // default
	// private Seconds seconds = new MemorySeconds(); // default
	// private MiniGameController miniGameController; // no default
	// private MiniGameView miniGameView; // no default
	//
	// private Builder() {}
	//
	// public static Builder getBuilder(){
	// return new Builder();
	// }
	//
	// public Builder setGoldValue(GoldValue goldValue) {
	// this.goldValue = goldValue;
	// return this;
	// }
	//
	// public Builder setSeconds(Seconds seconds) {
	// this.seconds = seconds;
	// return this;
	// }
	//
	// public Builder setMiniGameController(MiniGameController
	// miniGameController) {
	// this.miniGameController = miniGameController;
	// return this;
	// }
	//
	// public Builder setMiniGameView(MiniGameView miniGameView) {
	// this.miniGameView = miniGameView;
	// return this;
	// }
	//
	// public MemoryFactory build() {
	// return new MemoryFactory();
	// }
	// }
}
