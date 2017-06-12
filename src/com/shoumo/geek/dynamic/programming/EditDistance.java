package com.shoumo.geek.dynamic.programming;

public class EditDistance {

	public int getMinimum(int x, int y, int z) {
		if (x < y && x < z) {
			return x;
		} else if (y < x && y < z) {
			return y;
		} else {
			return z;
		}
	}

	public int editDistance(String strOne, String strTwo) {
		int[][] editDistanceArray = new int[strOne.length() + 1][strTwo
				.length() + 1];

		for (int i = 0; i <= strOne.length(); i++) {
			for (int j = 0; j <= strTwo.length(); j++) {
				if (i == 0) {
					editDistanceArray[i][j] = j;
				} else if (j == 0) {
					editDistanceArray[i][j] = i;
				} else if (strOne.charAt(i - 1) == strTwo.charAt(j - 1)) {
					editDistanceArray[i][j] = editDistanceArray[i - 1][j - 1];
				} else {
					editDistanceArray[i][j] = 1 + getMinimum(
							editDistanceArray[i][j - 1],
							editDistanceArray[i - 1][j],
							editDistanceArray[i - 1][j - 1]);
				}

			}
		}

		return editDistanceArray[strOne.length()][strTwo.length()];
	}

	public static void main(String[] args) {
		System.out.println("Min cost to edit is:"
				+ new EditDistance().editDistance("aaaaa", "za"));
	}
}
