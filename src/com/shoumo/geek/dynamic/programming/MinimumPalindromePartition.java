package com.shoumo.geek.dynamic.programming;

public class MinimumPalindromePartition {

	public int findMinimumPalindromePartition(char[] dataArray) {
		int length = dataArray.length;
		int[] minimumPalindromeArray = new int[length];
		boolean[][] palindromeCheckArray = new boolean[length][length];

		for (int i = 0; i < length; i++) {
			palindromeCheckArray[i][i] = true;
		}

		for (int l = 2; l <= length; l++) {
			for (int i = 0; i < length - l + 1; i++) {
				int j = i + l - 1;

				if (l == 2) {
					palindromeCheckArray[i][j] = dataArray[i] == dataArray[j];
				} else {
					palindromeCheckArray[i][j] = dataArray[i] == dataArray[j]
							&& palindromeCheckArray[i + 1][j - 1];
				}

			}
		}

		for (int i = 0; i < length; i++) {
			if (palindromeCheckArray[0][i]) {
				minimumPalindromeArray[i] = 0;
			} else {
				minimumPalindromeArray[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (palindromeCheckArray[j + 1][i]
							&& minimumPalindromeArray[i] > minimumPalindromeArray[j] + 1) {
						minimumPalindromeArray[i] = minimumPalindromeArray[j] + 1;
					}
				}
			}
		}
		return minimumPalindromeArray[length - 1];
	}

	public static void main(String[] args) {
		System.out.println("Minimum cuts needed for plaindromic string is:"
				+ new MinimumPalindromePartition()
						.findMinimumPalindromePartition("ababbbabbababa"
								.toCharArray()));
	}
}
