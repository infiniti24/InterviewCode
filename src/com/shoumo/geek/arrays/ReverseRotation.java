package com.shoumo.geek.arrays;

public class ReverseRotation {

	public void leftRotate(int[] dataArray, int rotation) {
		reverse(dataArray, 0, rotation - 1);
		reverse(dataArray, rotation, dataArray.length - 1);
		reverse(dataArray, 0, dataArray.length - 1);
	}

	public void reverse(int[] dataArray, int start, int end) {
		int temp;
		while (start < end) {
			temp = dataArray[start];
			dataArray[start] = dataArray[end];
			dataArray[end] = temp;
			start++;
			end--;
		}

	}

	public void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseRotation reverseRotation = new ReverseRotation();
		int[] dataArray = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		reverseRotation.printArray(dataArray);
		reverseRotation.leftRotate(dataArray, 2);
		reverseRotation.printArray(dataArray);
	}
}
