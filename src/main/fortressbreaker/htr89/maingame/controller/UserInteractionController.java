package main.fortressbreaker.htr89.maingame.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.fortressbreaker.htr89.maingame.model.AiModel;
import main.fortressbreaker.htr89.maingame.model.DamageLogic;
import main.fortressbreaker.htr89.maingame.model.ItemsLogic;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.maingame.view.UserInteractionsPanel;

public class UserInteractionController implements ActionListener {
	private final ActionListener setUPListener = new SetUPListener();
	private FBGameController fbGameController;
	private UserInteractionsPanel interactionsPanel;
	private ItemsLogic itemsLogic;
	private PlayerModel playerModel;
	private AiModel aiModel;

	public UserInteractionController(FBGameController fbGameController, PlayerModel playerModel, AiModel aiModel) {
		// TODO Auto-generated constructor stub
		this.playerModel = playerModel;
		this.aiModel = aiModel;
		itemsLogic = new ItemsLogic();
		this.fbGameController = fbGameController;
		interactionsPanel = new UserInteractionsPanel();
		interactionsPanel.addButtonAttRocks(interactionsPanel.attackButtonsMap(), this);
		interactionsPanel.addButtonRebuilt(interactionsPanel.defenceButtonsMap(), this);
		interactionsPanel.getSet().addActionListener(UserInteractionController.this.setUPListener);
		fbGameController.addUserInformationsPanel(interactionsPanel, this);
		disableAttButtons();
		disableReBButtons();
	}

	private void disableReBButtons() {
		for (Component iterable_element : interactionsPanel.getRebuildPanel().getComponents()) {
			JButton button = (JButton) iterable_element;
			button.setEnabled(false);
		}
	}

	private void disableAttButtons() {
		for (Component iterable_element : interactionsPanel.getAttackRocksPanel().getComponents()) {
			JButton button = (JButton) iterable_element;
			button.setEnabled(false);

		}
	}

	private void enableReBButtons(int maxHammer) {
		// TODO Auto-generated method stub
		for (int i = 0; i < maxHammer; i++) {
			JButton button = (JButton) interactionsPanel.getRebuildPanel().getComponents()[i];
			button.setEnabled(true);
		}

	}

	private void enableAttButtons(int maxShot) {
		for (int i = 0; i < maxShot; i++) {
			JButton button = (JButton) interactionsPanel.getAttackRocksPanel().getComponents()[i];
			button.setEnabled(true);
		}
	}

	public void disableOneShotButton() {
		int counter = 0;
		for (Component iterable_element : interactionsPanel.getAttackRocksPanel().getComponents()) {
			if (iterable_element instanceof JButton) {
				JButton button = (JButton) iterable_element;
				if (button.isEnabled()) {
					counter++;
				}
			}

		}
		JButton button = (JButton) interactionsPanel.getAttackRocksPanel().getComponents()[counter - 1];
		button.setEnabled(false);
		interactionsPanel.getAttackRocksPanel().revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public ItemsLogic getItemsLogic() {
		return itemsLogic;
	}

	private class SetUPListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			itemsLogic.setNumberOfShots(playerModel.getNumberOfShots());
			itemsLogic.setNumberOfRebuilt(playerModel.getNumberOfHammers());
			enableAttButtons(itemsLogic.getNumberOfShots());
			enableReBButtons(itemsLogic.getNumberOfRebuilt());
			new DamageLogic(playerModel, aiModel).aiDamagesPlayer();
			if (playerModel.getTypeOfWall().getHitPoints() <= 0.0) {
				fbGameController.theWinnerIs(aiModel.getName(), playerModel.getName());
			}
		}

	}

}
