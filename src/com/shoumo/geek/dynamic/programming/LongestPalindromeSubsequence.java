package com.shoumo.geek.dynamic.programming;

public class LongestPalindromeSubsequence {

	public int findLongestPalindromSubsequence(String sequence) {

		int stringLength = sequence.length();
		int[][] lpsArr = new int[stringLength][stringLength];

		for (int i = 0; i < stringLength; i++) {
			lpsArr[i][i] = 1;
		}

		for (int i = 2; i <= stringLength; i++) {
			for (int j = 0; j < stringLength - i + 1; j++) {
				int k = i + j - 1;
				if (sequence.charAt(j) == sequence.charAt(k) && i == 2) {
					lpsArr[j][k] = 2;
				} else if (sequence.charAt(j) == sequence.charAt(k)) {
					lpsArr[j][k] = lpsArr[j + 1][k - 1] + 2;
				} else {
					lpsArr[j][k] = Math.max(lpsArr[j + 1][k], lpsArr[j][k - 1]);
				}
			}
		}

		return lpsArr[0][stringLength - 1];

	}

	public static void main(String[] args) {
		System.out.println("Maximum length of lps is:"
				+ new LongestPalindromeSubsequence()
						.findLongestPalindromSubsequence("BBABCBCAB"));
	}
}
