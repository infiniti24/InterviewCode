package com.shoumo.geek.arrays;

public class MergeTwoSortedArray {

	public void pushElementBehind(int[] dataArray) {
		int j = dataArray.length - 1;
		for (int i = dataArray.length - 1; i >= 0; i--) {
			if (dataArray[i] != -1) {
				dataArray[j] = dataArray[i];
				j--;
			}
		}
	}

	public int[] getMergedArray(int[] largerArray, int[] smallerArray) {
		int totalLength = largerArray.length;

		pushElementBehind(largerArray);

		int k = 0, j = 0, i = smallerArray.length;

		while (k < totalLength) {
			if ((i < totalLength && largerArray[i] < smallerArray[j])
					|| j == smallerArray.length) {
				largerArray[k] = largerArray[i];
				k++;
				i++;
			} else {
				largerArray[k] = smallerArray[j];
				k++;
				j++;
			}
		}

		return largerArray;
	}

	public static void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		printArray(new MergeTwoSortedArray().getMergedArray(new int[] { 2, 8,
				-1, -1, -1, 13, -1, 15, 20 }, new int[] { 5, 7, 9, 25 }));
	}
}
