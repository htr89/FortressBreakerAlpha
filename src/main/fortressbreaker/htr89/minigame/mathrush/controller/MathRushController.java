package main.fortressbreaker.htr89.minigame.mathrush.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;
import javax.swing.JButton;

import main.fortressbreaker.htr89.minigame.controller.MiniGameController;
import main.fortressbreaker.htr89.minigame.controller.MiniGamesController;
import main.fortressbreaker.htr89.minigame.mathrush.model.MathRushDifficulty;
import main.fortressbreaker.htr89.minigame.mathrush.model.MathRushModel;
import main.fortressbreaker.htr89.minigame.mathrush.view.MathRushView;
import main.fortressbreaker.htr89.minigame.model.MiniGameFactory;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;
import main.fortressbreaker.htr89.minigame.view.MiniGamesViewSingleton;

public class MathRushController implements ActionListener, MiniGameController {
	Map<String, JButton> operationPanelMap;

	private MathRushModel refMRModel = new MathRushModel();
	MiniGameFactory gameFactory;
	private MathRushView view;

	/*
	 * 12.04 The Constructor has to be redefined
	 */
	public MathRushController(MiniGameView view) {
		this.view = (MathRushView) view;

		operationPanelMap = new HashMap<>();

		this.view.getMainPanel()
				.add(this.view.createJButAndTxtField("I", refMRModel.createOperation(MathRushDifficulty.EASY), this));

		this.view.repaint();
		this.view.revalidate();
		MiniGamesViewSingleton.getInstance().getGamePanel().add(MathRushController.this.view, BorderLayout.CENTER);
		MiniGamesViewSingleton.getInstance().getGamePanel().revalidate();
		MiniGamesViewSingleton.getInstance().getGamePanel().doLayout();
		MiniGamesViewSingleton.getInstance().getGamePanel().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tempbutton = (JButton) e.getSource();

		try {
			String tempresult = refMRModel.stringResult(tempbutton.getText());

			if (tempbutton.getText().matches("\\d{1}\\s{1}\\W{1}\\s{1}\\d{1}\\s{1}\\W{1}\\s{1}\\d{1}")) {
				if (tempresult.equals(this.view.getResultTxte().getText())) {
					if (operationPanelMap.containsKey("II")) {
						tempbutton.setText(refMRModel.createOperation(MathRushDifficulty.EASY));
					} else {
						this.view.getMainPanel().add(this.view.createJButAndTxtField("II",
								refMRModel.createOperation(MathRushDifficulty.MEDIUM), this));
						tempbutton.setText(refMRModel.createOperation(MathRushDifficulty.EASY));
					}
					MiniGamesController.winGold += 1;
				} else {
					MathRushModel.possiblemistakes--;
				}
			} else if (tempbutton.getText().matches("\\d{2}\\s{1}\\W{1}\\s{1}\\d{2}\\s{1}\\W{1}\\s{1}\\d{2}")) {
				if (tempresult.equals(this.view.getResultTxtm().getText())) {
					if (operationPanelMap.containsKey("III")) {
						tempbutton.setText(refMRModel.createOperation(MathRushDifficulty.MEDIUM));
					} else {
						this.view.getMainPanel().add(this.view.createJButAndTxtField("III",
								refMRModel.createOperation(MathRushDifficulty.HARD), this));
						tempbutton.setText(refMRModel.createOperation(MathRushDifficulty.MEDIUM));

					}
					MiniGamesController.winGold += 5;
				} else {
					MathRushModel.possiblemistakes--;
				}
			} else if (tempbutton.getText().matches("\\d{3}\\s{1}\\W{1}\\s{1}\\d{3}\\s{1}\\W{1}\\s{1}\\d{3}")) {
				if (tempresult.equals(this.view.getResultTxth().getText())) {
					tempbutton.setText(refMRModel.createOperation(MathRushDifficulty.HARD));
					MiniGamesController.winGold += 15;
				} else {
					MathRushModel.possiblemistakes--;
				}
			}
		} catch (ScriptException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// the next lines have to be called everytime, right?

		this.view.getPointCollected().setText("Your points:" + MiniGamesController.winGold);
		this.view.getMistakes().setText("Possible Mistakes:" + MathRushModel.possiblemistakes);

	}

	public Map<String, JButton> getResultMap() {
		return operationPanelMap;
	}

	@Override
	public EventListener addController() {

		return null;
	}

}
