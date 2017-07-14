package main.fortressbreaker.htr89.maingame.animation.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RockAnimationView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage rockbullet;
	private AffineTransformOp op;
	private double rotationRequired = Math.toRadians(45);
	private AffineTransform transform;
	private Graphics2D g2;
	private int startPositionX = 30;
	private int startPositionY = 400;

	public RockAnimationView() {
		this.setOpaque(false);
		transform = new AffineTransform();
		try {
			rockbullet = ImageIO.read(getClass().getClassLoader().getResource("gif/rockbullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void render(Graphics2D g2) {
		double locationX = rockbullet.getWidth() / 2;
		double locationY = rockbullet.getHeight() / 2;

		transform.rotate(rotationRequired, locationX, locationY);
		op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage tempbuff = op.filter(rockbullet, null);
		g2.drawImage(tempbuff, startPositionX, startPositionY, this);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		render(g2);
	}

	public void setStartPositionX(int startPositionX) {
		this.startPositionX = startPositionX;
	}

	public void setStartPositionY(int startPositionY) {
		this.startPositionY = startPositionY;
	}

}
