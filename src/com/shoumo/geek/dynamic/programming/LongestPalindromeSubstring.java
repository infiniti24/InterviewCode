package com.shoumo.geek.dynamic.programming;

import java.util.Objects;

public class LongestPalindromeSubstring {

	public void findLongestPalindromeSubstring(char[] dataArray) {

		if (Objects.isNull(dataArray) || dataArray.length == 0) {
			System.out.println("There are no elements in the array");
			return;
		}

		boolean[][] palindromeCheckData = new boolean[dataArray.length][dataArray.length];
		int maxLength = Integer.MIN_VALUE, start = 0;

		for (int i = 0; i < dataArray.length; i++) {
			palindromeCheckData[i][i] = true;
		}

		for (int i = 0; i < dataArray.length - 1; i++) {
			if (dataArray[i] == dataArray[i + 1]) {
				palindromeCheckData[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= dataArray.length; k++) {
			for (int i = 0; i < dataArray.length - k + 1; i++) {
				int j = k + i - 1;

				if (palindromeCheckData[i + 1][j - 1]
						&& dataArray[i] == dataArray[j]) {
					palindromeCheckData[i][j] = true;
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}

			}
		}

		System.out.println("Maximum plaindrome string is");
		for (int i = start; i < start + maxLength; i++) {
			System.out.print(dataArray[i]);
		}
	}

	public static void main(String[] args) {
		new LongestPalindromeSubstring()
				.findLongestPalindromeSubstring("forgeeksskeegfor"
						.toCharArray());
	}
}
