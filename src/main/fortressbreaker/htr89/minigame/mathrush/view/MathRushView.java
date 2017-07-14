package main.fortressbreaker.htr89.minigame.mathrush.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.fortressbreaker.htr89.minigame.mathrush.controller.MathRushController;
import main.fortressbreaker.htr89.minigame.model.MiniGameView;

public class MathRushView extends JPanel implements MiniGameView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4165525471800552362L;
	private JPanel mainPanel;
	private JPanel operationsPanel;
	private JButton operationButton;
	private JTextField resultTxte;
	private JTextField resultTxtm;
	private JTextField resultTxth;

	private JButton pointCollected;
	private JButton mistakes;
	private JPanel northPanel;

	public MathRushView() {
		this.setLayout(new GridLayout());
		mainPanel = new JPanel(new GridLayout(3, 1));

		this.add(centerPanel(), BorderLayout.CENTER);

	}

	private JPanel centerPanel() {
		JPanel inner = new JPanel(new BorderLayout());
		inner.add(northPanel(), BorderLayout.NORTH);
		inner.add(mainPanel, BorderLayout.CENTER);
		inner.add(southPanel(), BorderLayout.SOUTH);
		return inner;

	}

	private JPanel northPanel() {
		northPanel = new JPanel(new BorderLayout());
		northPanel.setMaximumSize(new Dimension(200, 75));
		// northPanel.add(createJButAndTxtField("Diff", "Solve then Push"));
		return northPanel;
	}

	private JButton operationButton(String diff, MathRushController controller) {
		operationButton = new JButton(diff);
		operationButton.setFont(new Font("Verdana", Font.BOLD, 20));

		operationButton.addActionListener(controller);
		return operationButton;
	}

	public JPanel createJButAndTxtField(String difficulty, String difftype, MathRushController controller) {
		operationsPanel = new JPanel(new BorderLayout());

		switch (difficulty) {
		case "I":
			resultTxte = new JTextField(5);
			operationsPanel.add(resultTxte, BorderLayout.EAST);
			break;
		case "II":
			resultTxtm = new JTextField(5);
			operationsPanel.add(resultTxtm, BorderLayout.EAST);
			break;
		case "III":
			resultTxth = new JTextField(5);
			operationsPanel.add(resultTxth, BorderLayout.EAST);
			break;

		default:
			JLabel infotxtLab = new JLabel("Result");
			operationsPanel.add(infotxtLab, BorderLayout.EAST);
			break;
		}
		JButton diff = new JButton(difficulty);
		operationsPanel.add(diff, BorderLayout.WEST);

		operationsPanel.add(operationButton(difftype, controller), BorderLayout.CENTER);
		controller.getResultMap().put(difficulty, operationButton(difftype, controller));
		return operationsPanel;
	}

	private JPanel southPanel() {
		JPanel inner = new JPanel(new GridLayout(1, 2));
		inner.setMinimumSize(new Dimension(200, 75));
		pointCollected = new JButton("Your points: 0");
		mistakes = new JButton("Max mistakes: 5");
		inner.add(pointCollected, BorderLayout.WEST);
		inner.add(mistakes, BorderLayout.EAST);

		return inner;
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public JTextField getResultTxte() {
		return resultTxte;
	}

	public JTextField getResultTxtm() {
		return resultTxtm;
	}

	public JTextField getResultTxth() {
		return resultTxth;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JPanel getOperationsPanel() {
		return operationsPanel;
	}

	public JButton getPointCollected() {
		return pointCollected;
	}

	public JButton getMistakes() {
		return mistakes;
	}

	@Override
	public JPanel gameView() {
		// TODO Auto-generated method stub
		return new MathRushView();
	}

}
