package com.shoumo.geek.arrays;

public class MaxIndexDifference {

	public void findMaxIndexDifference(int[] data) {
		int[] leftMin = new int[data.length];
		int[] rightMax = new int[data.length];
		leftMin[0] = data[0];
		for (int i = 1; i < data.length; i++)
			leftMin[i] = Math.min(data[i], leftMin[i - 1]);

		rightMax[0] = data[data.length - 1];
		for (int i = data.length - 2; i >= 0; i--)
			rightMax[i] = Math.max(data[i], rightMax[i + 1]);

		int i = 0, j = 0, maxDiff = -1;

		while (i < data.length && j < data.length) {
			if (leftMin[i] < rightMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}

		System.out.println("Max diff is:" + maxDiff);
	}

	public static void main(String[] args) {
		new MaxIndexDifference().findMaxIndexDifference(new int[] { 9, 2, 3, 4,
				5, 6, 7, 8, 18, 0 });
	}
}
