package main.fortressbreaker.htr89.minigame.memory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 06.04 This class creates all the methods needed to the logic of the game,
 * Memory. It gives back to the presenter a HashMap with two lists of Integer
 * inside and an Array with a random position of those. The logic in itself does
 * that: generates a random sequence of number between a given board, those
 * numbers are splitted in two lists in an increasing order.
 * 
 * @author Htr89
 */
public class MemoryModel {

	/**
	 * This int has to be a multiple of 2. 1.The presenter will avoid any other
	 * imput. 2.This class will only accept it if -> and the presenter will
	 * print an error.
	 */
	private int arrayMaxN;
	private Random rand;
	private List<Integer> myList;
	private int[] specularMemoryArray;
	private Map<Integer, List<Integer>> matchingListsMap;

	private int[][] memoryArray;

	public MemoryModel() {
		int cols = 4;
		int rows = 4;
		arrayMaxN = rows * cols;
		memoryArray = new int[rows][cols];
		rand = new Random();
		myList = new ArrayList<>();
		specularMemoryArray = myList.stream().mapToInt(i -> i).toArray();
		assignValuesToMemory();
		matchingListsMap = memoryListSplitter2(myList);
	}

	/**
	 * This method fills the memoryArray slots with the random integers.
	 */

	public final void assignValuesToMemory() {
		for (int[] iterator : memoryArray) {
			for (int j = 0; j < iterator.length; j++) {
				iterator[j] = getRandomWithExclusion(1, arrayMaxN, specularMemoryArray);

			}

		}

	}

	public Map<Integer, List<Integer>> memoryListSplitter2(List<Integer> listToBeSplitted) {
		matchingListsMap = new HashMap<>();
		final List<Integer> sub1 = listToBeSplitted.subList(0, arrayMaxN / 2);
		final List<Integer> sub2 = listToBeSplitted.subList(arrayMaxN / 2, arrayMaxN);
		matchingListsMap.put(1, sub1);
		matchingListsMap.put(2, sub2);
		return matchingListsMap;

	}

	public int getRandomWithExclusion(final int start, final int end, final int... exclude) {
		int random = start + rand.nextInt(end - start + 1 - exclude.length);
		for (final int ex : exclude) {
			if (random < ex) {
				break;
			}
			random++;
		}

		myList.add(random);
		Collections.sort(myList);
		specularMemoryArray = myList.stream().mapToInt(i -> i).toArray();

		return random;
	}

	public int[][] getMemoryArray() {
		return memoryArray;
	}

	public Map<Integer, List<Integer>> getMatchingListsMap() {
		return matchingListsMap;
	}

}
