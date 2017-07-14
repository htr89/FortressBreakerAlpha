package main.fortressbreaker.htr89.market.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarketView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel waresDeskPanel;
	private JLabel goldAmount;
	private JButton buy;

	private GridBagConstraints constraints;

	public MarketView() {
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		goldAmount = new JLabel("Gold:");
		addNorthLabel();
		addTheWaresDesk();
		addPanelSouth();

	}

	/**
	 * Generates a Label with the Market´s Header in the constrained position.
	 * 
	 */
	private void addNorthLabel() {
		JLabel marketLabel = new JLabel("MARKET");
		marketLabel.setFont(new Font("Arial", Font.ITALIC, 50));
		constraints.ipadx = 20;
		constraints.ipady = 20;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.5;
		constraints.weighty = 0.2;
		constraints.anchor = GridBagConstraints.WEST;
		this.add(marketLabel, constraints);

	}

	/**
	 * Generates the JPanel that will host all the wares.
	 */
	private void addTheWaresDesk() {
		waresDeskPanel = new JPanel(new GridLayout(1, 0));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.anchor = GridBagConstraints.EAST;
		this.add(waresDeskPanel, constraints);

	}

	private void addPanelSouth() {
		JPanel inner = new JPanel(new GridLayout(1, 2));
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weightx = 1;
		constraints.weighty = 0.2;
		constraints.fill = GridBagConstraints.BOTH;

		buy = new JButton("Buy");

		inner.add(goldAmount);
		inner.add(buy);
		this.add(inner, constraints);

	}

	private JPanel createGoldPanel() {
		JPanel goldPanel = new JPanel(new GridLayout(1, 2));
		goldPanel.add(goldAmount);
		JLabel gold = new JLabel("Gold"); // remove if not needed 03.05
		goldPanel.add(gold);
		this.revalidate();
		this.repaint();
		return goldPanel;

	}

	/**
	 * This method will create a JCheckBox and add it to the MainPanel.
	 * 
	 * @param robeName
	 *            text of the JCheckBox
	 * @param aListener
	 *            add an ItemListener to the Jcheckbox
	 * @return aCheckBox
	 */
	public JCheckBox marketIstance(String robeName, ItemListener aListener) {
		JCheckBox aCheckBox = new JCheckBox(robeName);
		aCheckBox.setToolTipText("click to pay");
		aCheckBox.addItemListener(aListener);
		waresDeskPanel.add(aCheckBox);
		return aCheckBox;

	}

	public JButton getBuy() {
		return buy;
	}

	public JPanel getMainMarketPanel() {
		return waresDeskPanel;
	}

	public JLabel getGoldAmount() {
		return goldAmount;
	}

}
