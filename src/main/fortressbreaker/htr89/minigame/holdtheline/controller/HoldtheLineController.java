package main.fortressbreaker.htr89.minigame.holdtheline.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollBar;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.controller.MiniGamesController;
import main.fortressbreaker.htr89.minigame.holdtheline.model.HoldTheLineModel;
import main.fortressbreaker.htr89.minigame.holdtheline.view.HoldtheLineView;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;
import main.fortressbreaker.htr89.minigame.view.MiniGamesViewSingleton;

public class HoldtheLineController implements MiniGameController {
	public static boolean complete;
	/**
	 * 
	 */
	private HoldtheLineView view;
	/**
	 * 
	 */
	List<JScrollBar> jScrBrList;
	List<JScrollBar> controller;
	List<JScrollBar> dumb;
	private HoldTheLineModel refHoldtheLineLogic;

	public HoldtheLineController(MiniGameView view) {
		this.view = (HoldtheLineView) view;

		refHoldtheLineLogic = new HoldTheLineModel();
		jScrBrList = new ArrayList<>();
		jScrBrtoList();
		controller.stream().forEach((jScrollBar) -> jScrollBar.addAdjustmentListener(new MyAdjustmentListener()));
		setRandomPositionforDumb();
		MiniGamesViewSingleton.getInstance().getGamePanel().add(this.view, BorderLayout.CENTER);
		MiniGamesViewSingleton.getInstance().getGamePanel().revalidate();
		MiniGamesViewSingleton.getInstance().getGamePanel().doLayout();
		MiniGamesViewSingleton.getInstance().getGamePanel().repaint();

	}

	private final void jScrBrtoList() {
		for (Component jScrollBar : view.getHoldtheLineMainPanel().getComponents()) {
			if (jScrollBar instanceof JScrollBar) {
				jScrBrList.add((JScrollBar) jScrollBar);
			}

		}
		this.splittheJScrollBars(jScrBrList);

	}

	private final void setRandomPositionforDumb() {
		Random random = new Random();

		dumb.get(0).setValue(random.nextInt(5 - -5 + 1) + -5);
		dumb.get(1).setValue(random.nextInt(5 - -5 + 1) + -5);
		dumb.get(2).setValue(random.nextInt(5 - -5 + 1) + -5);
	}

	private void splittheJScrollBars(List<JScrollBar> aList) {
		int tobehalved = aList.size() / 2;

		controller = aList.subList(0, tobehalved);
		dumb = aList.subList(tobehalved, aList.size());

	}

	public List<JScrollBar> getjScrBrList() {
		return jScrBrList;
	}

	public List<JScrollBar> getController() {
		return controller;
	}

	public List<JScrollBar> getDumb() {
		return dumb;
	}

	@Override
	public EventListener addController() {

		return null;
	}

	class MyAdjustmentListener implements AdjustmentListener {
		int currentValue = 0;

		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			JScrollBar tempScr = (JScrollBar) e.getSource();
			int tempValue = tempScr.getValue();

			int effe = tempValue - currentValue;
			if (tempScr == controller.get(0)) {
				dumb.get(1).setValue(dumb.get(1).getValue() + effe);
				dumb.get(2).setValue(dumb.get(2).getValue() + effe);
			} else if (tempScr == controller.get(1)) {
				dumb.get(0).setValue(dumb.get(0).getValue() + effe);
				dumb.get(2).setValue(dumb.get(2).getValue() + effe);
			} else if (tempScr == controller.get(2)) {
				dumb.get(0).setValue(dumb.get(0).getValue() + effe);
				dumb.get(1).setValue(dumb.get(1).getValue() + effe);
			}
			refHoldtheLineLogic.getHoldthelineMap().put(dumb.get(1), dumb.get(1).getValue());
			refHoldtheLineLogic.getHoldthelineMap().put(dumb.get(0), dumb.get(0).getValue());
			refHoldtheLineLogic.getHoldthelineMap().put(dumb.get(2), dumb.get(2).getValue());
			complete = refHoldtheLineLogic.compareValuesinaMap(refHoldtheLineLogic.getHoldthelineMap());
			if (complete) {
				MiniGamesController.winGold = 340;
				complete = false;
				MiniGamesViewSingleton.getInstance().getGamePanel().remove(view);
				MiniGamesViewSingleton.getInstance().remove(2);

			}
			currentValue = tempValue;

		}

	}

}
