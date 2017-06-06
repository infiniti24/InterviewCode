package com.shoumo.geek.dynamic.programming;

public class MaximumSumSubarray {

	public void findMaxSum(int[] dataArray) {
		int maxSum = Integer.MIN_VALUE, maxSoFar = 0, start = 0, end = 0, tempStart = 0;

		for (int i = 0; i < dataArray.length; i++) {
			maxSoFar += dataArray[i];

			if (maxSoFar < 0) {
				maxSoFar = 0;
				tempStart = i + 1;
			} else if (maxSoFar > maxSum) {
				maxSum = maxSoFar;
				start = tempStart;
				end = i;
			}
		}

		System.out.println("Maximum subarray sum is:" + maxSum);
		System.out.println("Elements are:");
		for (int i = start; i <= end; i++) {
			System.out.print(dataArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		new MaximumSumSubarray().findMaxSum(new int[] { -2, -3, 4, -1, -2, 1,
				5, -3 });
	}
}
