package com.shoumo.geek.arrays;

public class MaximumCircularSubarraySum {

	public void findMaxCircularSum(int[] dataArray) {
		int maxSubarraySum = 0, maxWrapSum = 0;

		maxSubarraySum = getMaximumSubarraySum(dataArray);

		for (int i = 0; i < dataArray.length; i++) {
			maxWrapSum += dataArray[i];
			dataArray[i] = -dataArray[i];
		}

		maxWrapSum += getMaximumSubarraySum(dataArray);

		System.out.println("Maximum circular sum is:"
				+ Math.max(maxWrapSum, maxSubarraySum));
	}

	public int getMaximumSubarraySum(int[] dataArray) {
		int maximumSoFar = 0, maximumEndingHere = 0;

		for (Integer data : dataArray) {
			maximumEndingHere += data;
			if (maximumEndingHere < 0)
				maximumEndingHere = 0;
			if (maximumEndingHere > maximumSoFar)
				maximumSoFar = maximumEndingHere;
		}

		return maximumSoFar;
	}

	public static void main(String[] args) {
		new MaximumCircularSubarraySum().findMaxCircularSum(new int[] { 11, 10,
				-20, 5, -3, -5, 8, -13, 10 });
	}
}
