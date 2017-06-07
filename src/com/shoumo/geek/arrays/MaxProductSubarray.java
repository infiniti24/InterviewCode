package com.shoumo.geek.arrays;

public class MaxProductSubarray {

	public void findMaxProductSubarray(int[] dataArray) {
		int minEndingHere = 1;
		int maxEndingHere = 1;
		int maxSoFar = 1;

		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] > 0) {
				maxEndingHere = maxEndingHere * dataArray[i];
				minEndingHere = Math.min(minEndingHere * dataArray[i], 1);
			}

			else if (dataArray[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			}

			else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * dataArray[i], 1);
				minEndingHere = temp * dataArray[i];
			}

			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}

		System.out.println("Max product subarray is:" + maxSoFar);
	}

	public static void main(String[] args) {
		new MaxProductSubarray().findMaxProductSubarray(new int[] { 1, -2, -3,
				0, 7, -8, -2 });
	}
}
