package com.shoumo.geek.dynamic.programming;

public class MinimumCostPath {

	public int getMinimum(int x, int y, int z) {
		if (x < y && x < z)
			return x;
		if (y < x && y < z)
			return y;
		return z;
	}

	public int findMinimumCostPath(int[][] costArray, int finalRow,
			int finalCoulmn) {
		int[][] totalCost = new int[finalRow + 1][finalCoulmn + 1];
		totalCost[0][0] = costArray[0][0];
		for (int i = 1; i <= finalRow; i++) {
			totalCost[i][0] = totalCost[i - 1][0] + costArray[i][0];
		}

		for (int j = 1; j <= finalCoulmn; j++) {
			totalCost[0][j] = totalCost[0][j - 1] + costArray[0][j];
		}

		for (int i = 1; i <= finalRow; i++) {
			for (int j = 1; j <= finalCoulmn; j++) {
				totalCost[i][j] = getMinimum(totalCost[i - 1][j - 1],
						totalCost[i - 1][j], totalCost[i][j - 1])
						+ costArray[i][j];
			}
		}

		return totalCost[finalRow][finalCoulmn];
	}

	public static void main(String[] args) {
		int[][] costArray = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		System.out.println("Min cost path is:"
				+ new MinimumCostPath().findMinimumCostPath(costArray, 2, 2));
	}
}
