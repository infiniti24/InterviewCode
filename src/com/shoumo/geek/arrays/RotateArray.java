package com.shoumo.geek.arrays;

public class RotateArray {

	public void rotateArray(int[] dataArray, int rotation) {
		int k = 0;

		for (int i = 0; i < getGcd(rotation, dataArray.length); i++) {
			int temp = dataArray[i];
			int j = i;
			while (true) {
				k = j + rotation;
				if (k >= dataArray.length) {
					k = k - dataArray.length;
				}
				if (k == i) {
					break;
				}
				dataArray[j] = dataArray[k];
				j = k;
			}
			dataArray[j] = temp;
		}
	}

	public int getGcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return getGcd(b, a % b);
	}

	public void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] dataArray = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray ra = new RotateArray();
		ra.printArray(dataArray);
		ra.rotateArray(dataArray, 2);
		ra.printArray(dataArray);
	}
}
