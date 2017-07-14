package main.fortressbreaker.htr89.minigame.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

import main.fortressbreaker.htr89.minigame.controller.MiniGamesController;
import main.fortressbreaker.htr89.minigame.view.MiniGamesViewSingleton;

public abstract class MiniGameBuilding {
	private int earnedGold;

	private MiniGame theMinigame;
	private int timeleft;
	private int counterStartEarning = 0;

	protected abstract MiniGame makeGame(int typeOfGame);

	// When called a new game is made. The specific parts
	// are based on the String entered. After the game is made
	// we execute multiple methods in the game Object

	public MiniGame orderTheGame(int typeOfGame) {

		theMinigame = makeGame(typeOfGame);

		theMinigame.makeGame();
		theMinigame.giveGold();
		theMinigame.giveTime();
		setGoldValue(theMinigame.seconds.getTime(), MiniGamesViewSingleton.getInstance().getSecondsLabel());
		earnedGold = theMinigame.goldValue.getGoldValue();
		return theMinigame;

	}

	public int getEarnedGold() {
		return earnedGold;
	}

	public void setGoldValue(int time, JLabel timelabel) {
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(1);

		timeleft = time;

		execService.scheduleAtFixedRate(() -> {
			// The repetitive task, say to update Database
			int minutes = (timeleft % 3600) / 60;
			int seconds = timeleft % 60;

			String timeString = String.format("%02d:%02d", minutes, seconds);

			if (timeleft == 0) {
				timelabel.setText("Finish!");
			}

			else {

				timelabel.setText("TIME LEFT    " + timeString);
			}

			if (counterStartEarning < 10) {
				earnedGold = 0;
				counterStartEarning++;
			}

			earnedGold++;
			timeleft--;
			if (MiniGamesController.isStop || timeleft < 0) {

				timelabel.setText("00:00");
				execService.shutdown();
				execService.shutdownNow();
			}
		}, 0, 1000L, TimeUnit.MILLISECONDS);

	}

}
