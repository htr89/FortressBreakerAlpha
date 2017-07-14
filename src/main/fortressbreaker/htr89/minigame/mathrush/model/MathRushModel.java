package main.fortressbreaker.htr89.minigame.mathrush.model;

import java.util.HashMap;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import main.fortressbreaker.htr89.utility.model.DistributedRandomOperatorGenerator;

public class MathRushModel {
	private final static String ALLOWED_OPERATORS = "+-*";
	public static final int MAX_MISTS = 5;
	public static final int MIN_MISTS = 0;
	public static int actallwdMists;
	public static int possiblemistakes = 5;
	private StringBuilder operationString;
	private Random rand;
	private DistributedRandomOperatorGenerator generator;

	public MathRushModel() {
		rand = new Random();
		generator = new DistributedRandomOperatorGenerator();
	}

	public String createOperation(MathRushDifficulty myDifficulty) {
		this.addOprtDistr(myDifficulty);
		operationString = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			int random = rand.nextInt((myDifficulty.getMaxRandom() - myDifficulty.getMinRandom()) + 1)
					+ myDifficulty.getMinRandom();
			operationString.append(String.valueOf(random));
			int randomOprt = generator.getDistributedRandomNumber();
			operationString.append(" " + ALLOWED_OPERATORS.charAt(randomOprt) + " ");
		}
		int random = rand.nextInt((myDifficulty.getMaxRandom() - myDifficulty.getMinRandom()) + 1)
				+ myDifficulty.getMinRandom();
		operationString.append(String.valueOf(random));
		this.clearDistrMap();

		return operationString.toString();
	}

	public void addOprtDistr(MathRushDifficulty myDifficulty) {
		for (int i = 0; i < myDifficulty.getAllowedOperators().length; i++) {
			generator.addNumber(myDifficulty.getAllowedOperators()[i].getOperator().getValue(),
					myDifficulty.getAllowedOperators()[i].getWeight());
		}
	}

	public void clearDistrMap() {
		HashMap<Integer, Double> tobeclearedMap = generator.getDistribution();
		tobeclearedMap.clear();
	}

	public String stringResult(String operation) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String resultOperation = String.valueOf(engine.eval(operation));
		return resultOperation;
	}

}
