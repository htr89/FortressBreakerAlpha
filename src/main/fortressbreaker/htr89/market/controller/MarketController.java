package main.fortressbreaker.htr89.market.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;

import main.fortressbreaker.htr89.maingame.controller.MainGameController;
import main.fortressbreaker.htr89.maingame.model.PlayerModel;
import main.fortressbreaker.htr89.market.model.MarketLogic;
import main.fortressbreaker.htr89.market.model.MarketLogic.Market;
import main.fortressbreaker.htr89.market.view.MarketView;

public class MarketController implements ActionListener, ItemListener {

	private MainGameController gamecontroller;
	private MarketView marketView;
	private PlayerModel playerModel;
	private MarketLogic refMarketLogic;
	private boolean isBuying = false;
	private int tempShots;
	private int tempHammer;

	public MarketController(MainGameController controller, PlayerModel playerModel) {
		// TODO Auto-generated constructor stub
		this.playerModel = playerModel;
		this.gamecontroller = controller;
		marketView = new MarketView();
		gamecontroller.addMarketPanelControls(marketView, this);
		this.addWares();
		refMarketLogic = new MarketLogic();
		refMarketLogic.setGoldcoins(playerModel.getGold());
		marketView.getGoldAmount().addMouseListener(new MyMouseListener());
		marketView.getGoldAmount().setText("Gold :" + playerModel.getGold());
		marketView.getBuy().addActionListener(this);

	}

	private void addWares() {
		marketView.marketIstance(Market.MORESECONDS.getRobeName(), this);
		marketView.marketIstance(Market.ROCKS.getRobeName(), this);
		marketView.marketIstance(Market.HAMMERS.getRobeName(), this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		refMarketLogic.setGoldcoins(playerModel.getGold());
		if (refMarketLogic.getGoldcoins() >= 15) {
			JCheckBox checkedBox = (JCheckBox) e.getItem();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				switch (checkedBox.getText()) {
				case "+5 Weapons":
					refMarketLogic.payGold(Market.ROCKS);
					tempShots = 5;
					break;
				case "+3 Shields":
					refMarketLogic.payGold(Market.HAMMERS);
					tempHammer = 3;
					break;

				default:
					break;
				}

			} else {// checkbox has been deselected
				if (isBuying == false) {
					switch (checkedBox.getText()) {
					case "+5 Weapons":
						refMarketLogic.refundGold(Market.ROCKS);
						tempShots -= 5;
						break;
					case "+3 Shields":
						refMarketLogic.refundGold(Market.HAMMERS);
						tempHammer -= 3;
						break;

					default:
						break;
					}
				}

			}
			playerModel.setGold(refMarketLogic.getGoldcoins());
			marketView.getGoldAmount().setText("Gold :" + playerModel.getGold());

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		isBuying = true;
		for (Component iterable_element : marketView.getMainMarketPanel().getComponents()) {
			if (iterable_element instanceof JCheckBox) {
				JCheckBox checkbox = (JCheckBox) iterable_element;
				checkbox.setSelected(false);
			}

		}
		isBuying = false;
		if (playerModel.getNumberOfShots() >= 4) {
			playerModel.setNumberOfShots(8);
		} else {
			playerModel.setNumberOfShots(playerModel.getNumberOfShots() + tempShots);
		}
		if (playerModel.getNumberOfHammers() >= 1) {
			playerModel.setNumberOfHammers(3);
		} else {
			playerModel.setNumberOfHammers(playerModel.getNumberOfHammers() + tempHammer);
		}

	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			marketView.getGoldAmount().setText("Gold :" + playerModel.getGold());
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			marketView.getGoldAmount().setText("Gold :" + playerModel.getGold());
		}
	}

}
