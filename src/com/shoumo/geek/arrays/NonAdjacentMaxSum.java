package com.shoumo.geek.arrays;

public class NonAdjacentMaxSum {

	public int findMaxSum(int[] dataArray) {
		int incl = dataArray[0];
		int excl = 0;

		for (int i = 1; i < dataArray.length; i++) {
			int exclNew = Math.max(incl, excl);
			incl = excl + dataArray[i];
			excl = exclNew;
		}

		return Math.max(incl, excl);
	}

	public static void main(String[] args) {
		System.out.println("Maximum sum of non adjacent elements is:"
				+ new NonAdjacentMaxSum().findMaxSum(new int[] { 5, 5, 10, 100,
						10, 5 }));
	}
}
