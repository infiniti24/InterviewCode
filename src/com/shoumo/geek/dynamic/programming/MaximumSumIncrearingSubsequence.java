package com.shoumo.geek.dynamic.programming;

public class MaximumSumIncrearingSubsequence {

	public int findMaximumSumIncreasingSubsequence(int[] dataArray) {
		int length = dataArray.length;
		int[] msis = new int[length];

		for (int i = 0; i < length; i++) {
			msis[i] = dataArray[i];
		}

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (dataArray[i] > dataArray[j]
						&& msis[i] < msis[j] + dataArray[i]) {
					msis[i] = msis[j] + dataArray[i];
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (Integer data : msis) {
			if (data > max) {
				max = data;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println("The sum of maximum increasing subsequence is:"
				+ new MaximumSumIncrearingSubsequence()
						.findMaximumSumIncreasingSubsequence(new int[] { 1,
								101, 2, 3, 100, 4, 5 }));
	}
}
