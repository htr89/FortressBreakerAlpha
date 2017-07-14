package main.fortressbreaker.htr89.minigame.model;

import main.fortressbreaker.htr89.minigame.holdtheline.HoldTheLine;
import main.fortressbreaker.htr89.minigame.holdtheline.model.HoldtheLineFactory;
import main.fortressbreaker.htr89.minigame.mathrush.MathRush;
import main.fortressbreaker.htr89.minigame.mathrush.model.MathRushFactory;
import main.fortressbreaker.htr89.minigame.memory.Memory;
import main.fortressbreaker.htr89.minigame.memory.model.MemoryFactory;

public class MiniGamesBuilder extends MiniGameBuilding {
	private MiniGame theMiniGame = null;

	@Override
	protected MiniGame makeGame(int typeOfGame) {

		switch (typeOfGame) {
		case 1:
			MiniGameFactory minigamePartsFactory = new MemoryFactory();
			theMiniGame = new Memory(minigamePartsFactory);
			theMiniGame.setName("Memory");

			break;
		case 2:
			MiniGameFactory minigamePartsFactory1 = new MathRushFactory();
			theMiniGame = new MathRush(minigamePartsFactory1);
			theMiniGame.setName("MathRush");

			break;
		case 3:
			MiniGameFactory minigamePartsFactory11 = new HoldtheLineFactory();
			theMiniGame = new HoldTheLine(minigamePartsFactory11);
			theMiniGame.setName("HoldtheLine");

			break;

		default:
			break;
		}

		return theMiniGame;
	}

}
