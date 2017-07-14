package main.fortressbreaker.htr89.minigame.holdtheline.model;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollBar;

/**
 * HoldthelineLogic has to check at every action if the given integer values, in
 * the same Map with different Keys, are the same and equal to 0. When this will
 * happen, HoldTheLineWinLoseLogic will be called.
 * 
 * @author Htr89
 *
 */

public class HoldTheLineModel {
	private Map<JScrollBar, Integer> holdthelineMap;

	public HoldTheLineModel() {
		holdthelineMap = new HashMap<>();
	}

	/*
	 * That's the mainMethod of this class, the presenter will call it when
	 * needed.
	 * 
	 * 30.04 Should this method be static?
	 */
	public boolean compareValuesinaMap(Map<JScrollBar, Integer> aMap) {
		boolean areallZero = false;

		for (Integer value : aMap.values()) {
			if (value != 0) {
				areallZero = false;
				break;
			} else {
				areallZero = true;
			}

		}

		return areallZero;

	}

	/**
	 * This method will be used to fill the map.
	 * 
	 * @return the holdthelineMap
	 */
	public Map<JScrollBar, Integer> getHoldthelineMap() {
		return holdthelineMap;
	}

}
