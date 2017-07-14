package main.fortressbreaker.htr89.maingame.model;

import java.io.IOException;

import javax.swing.JLabel;

public class RockModel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int damages;

	public RockModel(TypeOfStone typeOfStone) throws IOException {
		// TODO Auto-generated constructor stub
		this.damages = typeOfStone.getDamage();

	}

	public int getDamage() {
		return damages;
	}

	public enum TypeOfStone {
		WEAK(5, 0.1), MEDIUM(10, 0.3), HARD(15, 0.5);

		private int damage;
		private double penetration;

		private TypeOfStone(int integrity, double resistance) {
			this.damage = integrity;
			this.penetration = resistance;

		}

		public int getDamage() {
			return damage;
		}

		public double getPenetration() {
			return penetration;
		}

	}

}
