package com.shoumo.geek.dynamic.programming;

public class EggDropProblem {

	public int getMinimumNumberOfTrials(int numberOfEggs, int numberOfFloors) {
		int[][] minimumTrialArray = new int[numberOfEggs + 1][numberOfFloors + 1];

		for (int i = 1; i <= numberOfEggs; i++) {
			minimumTrialArray[i][1] = 1;
			minimumTrialArray[i][0] = 0;
		}

		for (int i = 1; i <= numberOfFloors; i++) {
			minimumTrialArray[1][i] = i;
		}

		for (int i = 2; i <= numberOfEggs; i++) {
			for (int j = 2; j <= numberOfFloors; j++) {
				minimumTrialArray[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					int maxofFloors = 1 + Math.max(
							minimumTrialArray[i - 1][x - 1],
							minimumTrialArray[i][j - x]);
					if (maxofFloors < minimumTrialArray[i][j]) {
						minimumTrialArray[i][j] = maxofFloors;
					}
				}
			}
		}

		return minimumTrialArray[numberOfEggs][numberOfFloors];
	}

	public static void main(String[] args) {
		System.out.println("Minimum number of trials is:"
				+ new EggDropProblem().getMinimumNumberOfTrials(2, 36));
	}
}
