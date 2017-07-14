package main.fortressbreaker.htr89.maingame.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class deals with the user interactions, the viewing components that can
 * actually been used by the players. A GridConstraints keeps all the components
 * in position, even if in the game frame the Rounds buttons are added in the
 * centralPanel.
 * 
 * @author Htr89
 * 
 */
public class UserInteractionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GridBagConstraints bagConstrains;

	private JPanel attackRocksPanel;

	private JPanel rebuildPanel;


	private JLabel labelatk;

	private JLabel labeldef;
	private JButton set;

	public UserInteractionsPanel() {
		this.setLayout(new GridBagLayout());
		bagConstrains = new GridBagConstraints();
		addSetButton();
		addLabelAtk();
		addLabelDefence();
		addAttackRocksPanel();
		addRebuiltPanel();

	}

	private void addSetButton() {
		set = new JButton("SetUp");
		bagConstrains.gridx = 0;
		bagConstrains.gridy = 0;
		this.add(set, bagConstrains);
	}

	// private void addhitpointsLabel() {
	// // TODO Auto-generated method stub
	// playerhitpointsLabel = new JLabel("100");
	// bagConstrains.gridx = 1;
	// bagConstrains.gridy = 0;
	// this.add(playerhitpointsLabel, bagConstrains);
	// }
	//
	// private void addaiHitPointsLabel() {
	// // TODO Auto-generated method stub
	// aiHitPointsLabel = new JLabel("100");
	// bagConstrains.gridx = 2;
	// bagConstrains.gridy = 0;
	// this.add(aiHitPointsLabel, bagConstrains);
	// }

	private void addLabelAtk() {
		// TODO Auto-generated method stub
		labelatk = new JLabel("Atk:");
		bagConstrains.gridx = 1;
		bagConstrains.gridy = 1;
		this.add(labelatk, bagConstrains);
	}

	private void addLabelDefence() {
		// TODO Auto-generated method stub
		labeldef = new JLabel("Def:");
		bagConstrains.gridx = 2;
		bagConstrains.gridy = 1;
		this.add(labeldef, bagConstrains);

	}

	private void addAttackRocksPanel() {
		// TODO Auto-generated method stub
		attackRocksPanel = new JPanel(new GridLayout(1, 0));
		bagConstrains.gridx = 1;
		bagConstrains.gridy = 2;
		bagConstrains.weightx = 1.0;
		this.add(attackRocksPanel, bagConstrains);
	}

	public void addButtonAttRocks(Map<Integer, JButton> aMap, ActionListener listener) {
		aMap.entrySet().stream().forEach((button) -> {
			enancheJButton(button.getValue(), "att");
			// button.getValue().addActionListener(listener);
			attackRocksPanel.add(button.getValue());
		});
		attackRocksPanel.revalidate();

	}

	private void addRebuiltPanel() {
		// TODO Auto-generated method stub
		rebuildPanel = new JPanel(new GridLayout(1, 0));
		bagConstrains.gridx = 2;
		bagConstrains.gridy = 2;
		this.add(rebuildPanel, bagConstrains);
	}

	public void addButtonRebuilt(Map<Integer, JButton> aMap, ActionListener listener) {
		aMap.entrySet().stream().forEach((button) -> {
			enancheJButton(button.getValue(), "def");
			// button.getValue().addActionListener(listener);
			rebuildPanel.add(button.getValue());
		});
		rebuildPanel.revalidate();

	}

	private void enancheJButton(JButton button, String type) {
		Image rockbullet = null;
		try {
			switch (type) {
			case "att":
				rockbullet = ImageIO.read(getClass().getClassLoader().getResource("gif/rockbullet.png"));
				break;
			case "def":
				rockbullet = ImageIO.read(getClass().getClassLoader().getResource("gif/rebuilt.png"));
				break;

			default:
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			button.setIcon(new ImageIcon(rockbullet));
		}

	}

	public Map<Integer, JButton> attackButtonsMap() {
		Map<Integer, JButton> map = new HashMap<>();
		for (int i = 0; i < 8; i++) {
			JButton name = new JButton();
			map.put(i, name);

		}
		return map;

	}

	public Map<Integer, JButton> defenceButtonsMap() {
		Map<Integer, JButton> map = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			JButton name = new JButton();
			map.put(i, name);

		}
		return map;

	}

	public JPanel getAttackRocksPanel() {
		return attackRocksPanel;
	}

	public JPanel getRebuildPanel() {
		return rebuildPanel;
	}

	public JButton getSet() {
		return set;
	}

}
