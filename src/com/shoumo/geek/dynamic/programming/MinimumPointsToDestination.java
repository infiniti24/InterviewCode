package com.shoumo.geek.dynamic.programming;

public class MinimumPointsToDestination {

	public int findMinimumInitialCost(int[][] costArray, int rowToReach,
			int columnToReach) {

		int[][] initialCostMatrix = new int[rowToReach][columnToReach];

		initialCostMatrix[rowToReach - 1][columnToReach - 1] = costArray[rowToReach - 1][columnToReach - 1] > 0 ? 1
				: Math.abs(costArray[rowToReach - 1][columnToReach - 1]) + 1;

		for (int i = rowToReach - 2; i >= 0; i--) {
			initialCostMatrix[i][columnToReach - 1] = Math.max(
					initialCostMatrix[i][columnToReach - 1]
							- costArray[i][columnToReach - 1], 1);
		}

		for (int i = columnToReach - 2; i >= 0; i--) {
			initialCostMatrix[rowToReach - 1][i] = Math.max(
					initialCostMatrix[rowToReach - 1][i]
							- costArray[rowToReach - 1][i], 1);
		}

		for (int i = rowToReach - 2; i >= 0; i--) {
			for (int j = columnToReach - 2; j >= 0; j--) {
				int minimumPointsOnExit = Math.min(initialCostMatrix[i + 1][j],
						initialCostMatrix[i][j + 1]);
				initialCostMatrix[i][j] = Math.max(minimumPointsOnExit
						- costArray[i][j], 1);
			}
		}

		return initialCostMatrix[0][0];
	}

	public static void main(String[] args) {
		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int R = 3, C = 3;
		System.out.println("Minimum Initial Points Required: "
				+ new MinimumPointsToDestination().findMinimumInitialCost(
						points, R, C));
	}
}
