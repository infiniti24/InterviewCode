package com.shoumo.geek.dynamic.programming;

public class SubsetSumProblem {

	public boolean isSubsetSum(int[] set, int sum) {
		int length = set.length;
		if (sum == 0) {
			return true;
		}
		if (set.length == 0) {
			return false;
		}

		boolean[][] subsetSum = new boolean[sum + 1][length + 1];

		for (int i = 0; i <= length; i++) {
			subsetSum[0][i] = true;
		}

		for (int i = 0; i <= sum; i++) {
			subsetSum[i][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= length; j++) {
				subsetSum[i][j] = subsetSum[i][j - 1];
				if (i >= set[j - 1]) {
					subsetSum[i][j] |= subsetSum[i - set[j - 1]][j - 1];
				}
			}
		}

		return subsetSum[sum][length];
	}

	public static void main(String[] args) {
		System.out.println("Does sum exist:"
				+ new SubsetSumProblem().isSubsetSum(new int[] { 3, 34, 4, 12,
						5, 2 }, 9));
	}
}
