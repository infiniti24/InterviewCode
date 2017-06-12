package com.shoumo.geek.dynamic.programming;


public class SumOfDigitsToSum {

	private int lookup[][] = new int[101][50001];

	public int findSumRecursively(int n, int sum) {

		if (n == 0)
			return sum == 0 ? 1 : 0;

		if (lookup[n][sum] != -1)
			return lookup[n][sum];
		int finalSum = 0;

		for (int i = 0; i <= 9; i++) {
			if (sum - i >= 0)
				finalSum += findSumRecursively(n - 1, sum - i);
		}

		return lookup[n][sum] = finalSum;
	}

	public int findSum(int n, int sum) {

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 50000; j++) {
				lookup[i][j] = -1;
			}
		}

		int finalNumbers = 0;

		for (int i = 1; i <= 9; i++) {
			if (sum - i >= 0)
				finalNumbers += findSumRecursively(n - 1, sum - i);
		}
		return finalNumbers;
	}

	public static void main(String[] args) {
		System.out.println("Final count for numbers is:"
				+ new SumOfDigitsToSum().findSum(2, 5));
	}
}
