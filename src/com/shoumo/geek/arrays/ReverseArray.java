package com.shoumo.geek.arrays;

public class ReverseArray {

	public void reverse(int[] dataArray, int start, int end) {
		if (start >= end)
			return;

		int temp = dataArray[start];
		dataArray[start] = dataArray[end];
		dataArray[end] = temp;

		reverse(dataArray, start + 1, end - 1);
	}

	public void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] dataArray = new int[] { 1, 2, 3, 4, 5 };
		ReverseArray ra = new ReverseArray();
		ra.printArray(dataArray);
		System.out.println();
		ra.reverse(dataArray, 0, dataArray.length - 1);
		ra.printArray(dataArray);
	}

}
