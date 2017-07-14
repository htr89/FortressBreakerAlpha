package main.fortressbreaker.htr89.minigame.mathrush.model;

public enum MathRushDifficulty {

	EASY(9, 1, new WeightedOperator(Operator.PLUS, 0.4d), new WeightedOperator(Operator.MINUS, 0.4d),
			new WeightedOperator(Operator.MULTIPLY, 0.2d)), MEDIUM(19, 11, new WeightedOperator(Operator.PLUS, 0.5d),
					new WeightedOperator(Operator.MINUS, 0.5d)), HARD(199, 100,
							new WeightedOperator(Operator.PLUS, 0.5d), new WeightedOperator(Operator.MINUS, 0.5d));

	public static enum Operator {
		PLUS(0), MINUS(1), MULTIPLY(2);

		private int value;

		private Operator(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public static class WeightedOperator {
		private Operator operator;
		private double weight;

		public WeightedOperator(Operator operator, double weight) {
			this.operator = operator;
			this.weight = weight;
		}

		public Operator getOperator() {
			return operator;
		}

		public double getWeight() {
			return weight;
		}

	}

	public final int maxRandom;
	public final int minRandom;
	public final WeightedOperator[] allowedOperators;

	private MathRushDifficulty(int max, int min, WeightedOperator... operator) {
		this.maxRandom = max;
		this.minRandom = min;
		this.allowedOperators = operator;
	}

	public int getMaxRandom() {
		return maxRandom;
	}

	public int getMinRandom() {
		return minRandom;
	}

	public WeightedOperator[] getAllowedOperators() {
		return allowedOperators;
	}

}
