package com.shoumo.geek.dynamic.programming;

public class LongestCommonSubsequence {

	public void findLCS(char[] firstStringArray, char[] secondStringArray) {
		int[][] lcsArray = new int[firstStringArray.length + 1][secondStringArray.length + 1];

		for (int i = 0; i <= firstStringArray.length; i++) {
			for (int j = 0; j <= secondStringArray.length; j++) {
				if (i == 0 || j == 0) {
					lcsArray[i][j] = 0;
				} else if (firstStringArray[i - 1] == secondStringArray[j - 1]) {
					lcsArray[i][j] = lcsArray[i - 1][j - 1] + 1;
				} else {
					lcsArray[i][j] = Math.max(lcsArray[i - 1][j],
							lcsArray[i][j - 1]);
				}
			}
		}
		int index = lcsArray[firstStringArray.length][secondStringArray.length];
		char[] lcsSubSequence = new char[index];

		int i = firstStringArray.length, j = secondStringArray.length;
		while (i > 0 && j > 0) {
			if (firstStringArray[i - 1] == secondStringArray[j - 1]) {
				lcsSubSequence[index - 1] = firstStringArray[i - 1];
				index--;
				i--;
				j--;
			} else if (lcsArray[i - 1][j] > lcsArray[i][j - 1]) {
				i--;
			} else {
				j--;
			}

		}

		for (char c : lcsSubSequence) {
			System.out.print(String.valueOf(c));
		}
	}

	public static void main(String[] args) {
		new LongestCommonSubsequence().findLCS("AGGTAB".toCharArray(),
				"GXTXAYB".toCharArray());
	}
}
