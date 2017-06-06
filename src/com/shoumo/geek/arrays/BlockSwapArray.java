package com.shoumo.geek.arrays;

public class BlockSwapArray {

	public void leftRotate(int[] dataArray, int rotation) {
		if (rotation == 0 || rotation == dataArray.length)
			return;

		int i = rotation;
		int j = dataArray.length - rotation;

		while (i != j) {
			if (i < j) {
				swap(dataArray, rotation - i, rotation + j - i, i);
				j -= i;
			} else {
				swap(dataArray, rotation - i, rotation, j);
				i -= j;
			}
		}
		swap(dataArray, rotation - i, rotation, i);
	}

	public void swap(int[] dataArray, int firstIndex, int secondIndex, int dest) {
		for (int i = 0; i < dest; i++) {
			int temp = dataArray[firstIndex + i];
			dataArray[firstIndex + i] = dataArray[secondIndex + i];
			dataArray[secondIndex + i] = temp;
		}
	}

	public void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] dataArray = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		BlockSwapArray bsa = new BlockSwapArray();
		bsa.printArray(dataArray);
		bsa.leftRotate(dataArray, 2);
		bsa.printArray(dataArray);
	}
}
