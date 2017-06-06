package com.shoumo.geek.dynamic.programming;

public class PartitionProblem {

	public boolean doesPartitionExists(int[] dataArray) {
		int sum = 0;
		int length = dataArray.length;
		for (int i = 0; i < length; i++) {
			sum += dataArray[i];
		}

		if (sum % 2 != 0)
			return false;

		boolean[][] partitionArray = new boolean[sum / 2 + 1][length + 1];

		for (int i = 0; i <= length; i++) {
			partitionArray[0][i] = true;
		}

		for (int i = 1; i <= sum / 2; i++) {
			partitionArray[i][0] = false;
		}

		for (int i = 1; i <= sum / 2; i++) {
			for (int j = 1; j <= length; j++) {
				partitionArray[i][j] = partitionArray[i][j - 1];
				if (i >= dataArray[j - 1]) {
					partitionArray[i][j] |= partitionArray[i - dataArray[j - 1]][j - 1];
				}
			}
		}

		for (int i = 0; i <= sum / 2; i++) {
			for (int j = 0; j <= length; j++) {
				System.out.print(partitionArray[i][j] + " ");
			}
			System.out.println();
		}
		return partitionArray[sum / 2][length];
	}

	public static void main(String[] args) {
		System.out.println("Is partition possible"
				+ new PartitionProblem().doesPartitionExists(new int[] { 3, 1,
						1, 2, 2, 1 }));
	}
}
