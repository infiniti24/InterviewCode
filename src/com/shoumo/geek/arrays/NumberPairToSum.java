package com.shoumo.geek.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberPairToSum {

	private Map<Integer, Integer> dataMap = new HashMap<>();

	public void findPairs(int[] dataArray, int sum) {
		for (int i = 0; i < dataArray.length; i++) {
			int leftover = sum - dataArray[i];
			if (dataMap.get(dataArray[i]) != null) {
				System.out.println("Found pair with sum:("
						+ dataMap.get(dataArray[i]) + "," + dataArray[i] + ")");
				dataMap.remove(dataArray[i]);
			} else {
				dataMap.put(leftover, dataArray[i]);
			}
		}
	}

	public static void main(String[] args) {
		new NumberPairToSum().findPairs(new int[] { 1, 4, 45, 6, 10, -8 }, 16);
	}
}
