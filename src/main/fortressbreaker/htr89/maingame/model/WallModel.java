package main.fortressbreaker.htr89.maingame.model;

import java.io.IOException;

public class WallModel {

	private TypeOfWall typeOfWall;

	private double hitpoints;

	public WallModel(TypeOfWall typeOfWall) throws IOException {
		this.typeOfWall = typeOfWall;
		this.hitpoints = this.typeOfWall.getIntegrity();

	}

	public String getName() {
		return typeOfWall.toString();
	}

	public double getHitPoints() {
		return hitpoints;
	}

	public void setHitPoints(double variation) {
		this.hitpoints = this.hitpoints - variation;

	}

	public double getResistance() {
		return typeOfWall.getResistance();
	}

	public enum TypeOfWall {
		WOOD(50.0, 0.1), STONE(70.0, 0.2), MARBLE(100.0, 0.3);

		private double integrity;
		private double resistance;

		private TypeOfWall(double integrity, double resistance) {
			this.integrity = integrity;
			this.resistance = resistance;

		}

		public double getIntegrity() {
			return integrity;
		}

		public double getResistance() {
			return resistance;
		}

		public void setIntegrity(double integrity) {
			this.integrity = integrity;
		}

		public void setResistance(double resistance) {
			this.resistance = resistance;
		}

	}

}
