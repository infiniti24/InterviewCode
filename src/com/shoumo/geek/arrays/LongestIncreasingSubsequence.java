package com.shoumo.geek.arrays;

public class LongestIncreasingSubsequence {

	public int ceilIndex(int[] dataArray, int left, int right, int key) {
		while (right - left > 1) {

			int mid = left + (right - left) / 2;

			if (dataArray[mid] >= key) {
				right = mid;
			} else {
				left = mid;
			}
		}

		return right;
	}

	public void findLIS(int[] dataArray) {

		int[] tailTable = new int[dataArray.length];
		int len = 0;

		tailTable[len++] = dataArray[0];

		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i] < tailTable[0])
				tailTable[0] = dataArray[i];
			else if (dataArray[i] > tailTable[len - 1])
				tailTable[len++] = dataArray[i];
			else
				tailTable[ceilIndex(tailTable, -1, len - 1, dataArray[i])] = dataArray[i];
		}

		System.out.println("Maximum increasing subsequence length is:" + len);
	}

	public static void main(String[] args) {
		new LongestIncreasingSubsequence().findLIS(new int[] { 2, 5, 3, 7, 11,
				8, 10, 13, 6 });
	}
}
