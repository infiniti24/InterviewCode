package com.shoumo.geek.dynamic.programming;

public class RodCuttingProblem {

	public int findMaxValue(int price[], int rodLength) {

		int[] maxValueArr = new int[rodLength + 1];

		maxValueArr[0] = 0;

		for (int i = 1; i <= rodLength; i++) {
			int maxValue = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				maxValue = Math
						.max(maxValue, price[j] + maxValueArr[i - j - 1]);
			}
			maxValueArr[i] = maxValue;
		}

		return maxValueArr[rodLength];
	}

	public static void main(String[] args) {
		System.out.println("Maximum value that can be obtained is:"
				+ new RodCuttingProblem().findMaxValue(new int[] { 1, 5, 8, 9,
						10, 17, 17, 20 }, 8));
	}
}
