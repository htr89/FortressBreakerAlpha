package main.fortressbreaker.htr89.maingame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import main.fortressbreaker.htr89.utility.view.JHostPanel;

/**
 * 
 * This class deals with the main GUI of the game session, a BorderLayout panel
 * contains 3 different panels that pursue all that it's needed during the game.
 * 
 * Eache panel has is own method, but remember: the components of each panel,
 * exept for the images(08.03.17) are initialized in their own classes.
 * 
 * 
 * @author Htr89
 *
 */
public class FortressBreakerView extends JPanel {

	private static final long serialVersionUID = 1L;
	/*
	 * Has mentioned in the DOC, the components of each panel are initialized in
	 * their own classes, here are the 3 Objekt, one for panel.
	 */
	private JHostPanel wallsAndCatapultsHostPanel;
	private JHostPanel userInteractionsHostPanel;

	private UserInfoPanel refInfoPanel = new UserInfoPanel();

	/**
	 * This constructor is called in the class LoginController. It sets the
	 * layout of the In-GameGui by adding all panels that achieve that.
	 */
	public FortressBreakerView(String... strings) throws IOException {
		wallsAndCatapultsHostPanel = new JHostPanel();
		userInteractionsHostPanel = new JHostPanel();
		this.setLayout(new GridLayout());
		this.add(completePanel());
		if (strings.length > 0) {
			refInfoPanel.getPlayerOneLabel().setText(strings[0]);
		}
	}

	public JHostPanel getUserInteractionsPanel() {
		return userInteractionsHostPanel;
	}

	public JHostPanel getWallsAndCatapultsHostPanel() {
		return wallsAndCatapultsHostPanel;
	}

	private final JPanel completePanel() throws IOException {
		final JPanel completePanel = new JPanel(new BorderLayout());
		completePanel.add(getInfoPanel(), BorderLayout.NORTH);
		completePanel.add(getCentralPanel(), BorderLayout.CENTER);
		completePanel.add(userInteractionsHostPanel, BorderLayout.SOUTH);
		return completePanel;
	}

	private JPanel getCentralPanel() throws IOException {
		JPanel overlay = new JPanel();
		Image backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("gif/Background.jpg"));
		ImagePanelA imagePanel = new ImagePanelA(backgroundImage);
		overlay.setLayout(new OverlayLayout(overlay));
		overlay.add(wallsAndCatapultsHostPanel); // add transparent

		// panel first
		overlay.add(imagePanel, BorderLayout.CENTER);
		return overlay;
	}

	private JComponent getInfoPanel() {

		JPanel inner = new JPanel();
		inner.setLayout(new BorderLayout());
		refInfoPanel.getPlayerOneLabel().setFont(new Font("Courier New", Font.ITALIC, 40));
		refInfoPanel.getPlayerTwoLabel().setFont(new Font("Courier New", Font.ITALIC, 40));
		refInfoPanel.getRoundlabel().setFont(new Font("Courier New", Font.ITALIC, 60));
		refInfoPanel.getTodecideLabel1().setFont(new Font("Courier New", Font.ITALIC, 40));
		inner.add(refInfoPanel.getPlayerOneLabel(), BorderLayout.WEST);
		inner.add(refInfoPanel.getPlayerTwoLabel(), BorderLayout.EAST);
		inner.add(refInfoPanel.getRoundlabel(), BorderLayout.CENTER);
		inner.add(refInfoPanel.getTodecideLabel1(), BorderLayout.NORTH);
		inner.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		inner.setOpaque(false);
		this.setVisible(true);

		return inner;
	}

}

class ImagePanelA extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Image image;

	public ImagePanelA(Image image) {
		this.image = image;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}
	}
}
