package com.shoumo.geek.arrays;

public class SubarraySum {

	public void findSum(int[] dataArray, int sum) {

		int currentSum = dataArray[0], start = 0, end = 0;
		boolean sumFound = false;

		for (int i = 1; i <= dataArray.length; i++) {
			while (currentSum > sum && start < i - 1) {
				currentSum -= dataArray[start];
				start++;
			}

			if (currentSum == sum) {
				end = i - 1;
				sumFound = true;
				break;
			}

			currentSum += dataArray[i];
		}

		if (sumFound) {
			System.out.println("Sum found between indices " + start + " and "
					+ end);
		} else {
			System.out.println("Sum not found");
		}
	}

	public static void main(String[] args) {
		new SubarraySum().findSum(new int[] { 15, 2, 4, 8, 9, 5, 10, 23 }, 23);
	}
}
