package com.shoumo.geek.dynamic.programming;

import java.util.Arrays;

public class CoinChange {

	public long countWays(int[] coinArray, int totalNumberOfCoins,
			int finalDenomination) {

		long[] numberOfWaysArray = new long[finalDenomination + 1];
		Arrays.fill(numberOfWaysArray, 0);
		numberOfWaysArray[0] = 1;

		for (int i = 0; i < totalNumberOfCoins; i++) {
			for (int j = coinArray[i]; j <= finalDenomination; j++) {
				numberOfWaysArray[j] += numberOfWaysArray[j - coinArray[i]];
			}
		}
		return numberOfWaysArray[finalDenomination];

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println("Number of ways are:"
				+ new CoinChange().countWays(arr, arr.length, 5));
	}
}
