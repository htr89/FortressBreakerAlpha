package main.fortressbreaker.htr89.utility.model;

import java.util.HashMap;

public class DistributedRandomOperatorGenerator {

	private HashMap<Integer, Double> distribution;
	private double distSum;

	public DistributedRandomOperatorGenerator() {
		distribution = new HashMap<>();

	}

	public void addNumber(Integer operator, double distribution) {
		if (this.distribution.get(operator) != null) {
			distSum -= this.distribution.get(operator);
		}
		this.distribution.put(operator, distribution);
		distSum += distribution;
	}

	public int getDistributedRandomNumber() {
		double rand = Math.random();
		double ratio = 1.0f / distSum;
		double tempDist = 0;
		for (Integer i : distribution.keySet()) {
			tempDist += distribution.get(i);
			if (rand / ratio <= tempDist) {
				return i;
			}
		}
		return 0;
	}

	public HashMap<Integer, Double> getDistribution() {
		return distribution;
	}

	public double getDistSum() {
		return distSum;
	}

}
