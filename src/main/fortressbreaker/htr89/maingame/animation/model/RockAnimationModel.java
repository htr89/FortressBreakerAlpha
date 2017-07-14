package main.fortressbreaker.htr89.maingame.animation.model;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class RockAnimationModel extends Timer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068217715919014969L;
	private int startPositionX = 30;
	private int startPositionY = 400;
	private boolean controllBool = true;

	public RockAnimationModel(int delay, ActionListener listener) {
		super(delay, listener);

		this.setInitialDelay(190);
		this.start();
	}

	public void testMovement() {

		if (startPositionY >= 80 && controllBool == true) {
			startPositionX += 10;
			startPositionY -= 10;
		} else {
			controllBool = false;
			startPositionX += 10;
			startPositionY += 10;
		}
	}

	public int getStartPositionX() {
		return startPositionX;
	}

	public int getStartPositionY() {
		return startPositionY;
	}

}
