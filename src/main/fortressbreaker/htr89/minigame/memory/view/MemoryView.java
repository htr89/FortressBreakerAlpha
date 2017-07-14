package main.fortressbreaker.htr89.minigame.memory.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.fortressbreaker.htr89.minigame.model.MiniGameView;

public class MemoryView extends JPanel implements MiniGameView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, JButton> graphicButtonsMap;

	private JPanel cardPanel;

	public MemoryView() {
		this.setLayout(new BorderLayout());
		cardPanel = new JPanel();

		graphicButtonsMap = new HashMap<>();

	}

	public void paintCards(Map<String, JButton> aMap) {

		Image img;
		try {
			img = ImageIO.read(getClass().getClassLoader().getResource("gif/rear.png"));
			Image imgDisabled19 = ImageIO.read(getClass().getClassLoader().getResource("gif/card19.png"));
			Image imgDisabled210 = ImageIO.read(getClass().getClassLoader().getResource("gif/card210.png"));
			Image imgDisabled311 = ImageIO.read(getClass().getClassLoader().getResource("gif/card311.png"));
			Image imgDisabled412 = ImageIO.read(getClass().getClassLoader().getResource("gif/card412.png"));
			Image imgDisabled513 = ImageIO.read(getClass().getClassLoader().getResource("gif/card513.png"));
			Image imgDisabled614 = ImageIO.read(getClass().getClassLoader().getResource("gif/card614.png"));
			Image imgDisabled715 = ImageIO.read(getClass().getClassLoader().getResource("gif/card715.png"));
			Image imgDisabled816 = ImageIO.read(getClass().getClassLoader().getResource("gif/card816.png"));
			aMap.entrySet().stream().forEach((entry) -> {
				entry.getValue().setBorderPainted(false);
				entry.getValue().setContentAreaFilled(false);
				entry.getValue().setFocusPainted(false);
				entry.getValue().setOpaque(false);
				entry.getValue().setBorder(null);
				entry.getValue().setIcon(new ImageIcon(img));
				if ("1".equals(entry.getValue().getActionCommand())
						|| "9".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled19));
				} else if ("2".equals(entry.getValue().getActionCommand())
						|| "10".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled210));
				} else if ("3".equals(entry.getValue().getActionCommand())
						|| "11".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled311));
				} else if ("4".equals(entry.getValue().getActionCommand())
						|| "12".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled412));
				} else if ("5".equals(entry.getValue().getActionCommand())
						|| "13".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled513));
				} else if ("6".equals(entry.getValue().getActionCommand())
						|| "14".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled614));
				} else if ("7".equals(entry.getValue().getActionCommand())
						|| "15".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled715));
				} else if ("8".equals(entry.getValue().getActionCommand())
						|| "16".equals(entry.getValue().getActionCommand())) {
					entry.getValue().setDisabledIcon(new ImageIcon(imgDisabled816));
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public void depaintaCard(String aString) {

		JButton a = graphicButtonsMap.get(aString);
		a.setEnabled(false);

	}

	public void paintaCard(String aString) {

		JButton a = graphicButtonsMap.get(aString);
		a.setEnabled(true);

	}

	public Map<String, JButton> getGraphicButtonsMap() {
		return graphicButtonsMap;
	}

	@Override
	public JPanel gameView() {
		// TODO Auto-generated method stub
		return new MemoryView();
	}

}
