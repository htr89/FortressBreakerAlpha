package main.fortressbreaker.htr89.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrameSingleton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrameSingleton mainFrame = null;
	private URL url;
	{
		url = getClass().getClassLoader().getResource("gif/bg.jpg");

	}

	private MainFrameSingleton() {
		try {
			this.setContentPane(createPanelwithImgScaled());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);

	}

	public static MainFrameSingleton getInstance() {
		if (mainFrame == null) {
			mainFrame = new MainFrameSingleton();
		}
		return mainFrame;
	}

	/**
	 * This JPanel is used as background image and called in the method
	 * setContenentPane(), therefore it overrides the paintCompont method with
	 * the given image.
	 * 
	 * @return the JPanel
	 * @throws IOException
	 */
	private JPanel createPanelwithImgScaled() throws IOException {
		BufferedImage image = ImageIO.read(url);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		JPanel test = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, width, height, this);
			}

		};
		test.setOpaque(false);
		return test;
	}

}
