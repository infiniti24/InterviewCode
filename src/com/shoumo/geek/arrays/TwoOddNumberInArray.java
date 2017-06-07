package com.shoumo.geek.arrays;

public class TwoOddNumberInArray {

	public void findTwoOddNumber(int[] dataArray) {
		int xor = dataArray[0];

		int setBitNumber, x = 0, y = 0;

		for (int i = 1; i < dataArray.length; i++) {
			xor ^= dataArray[i];
		}

		setBitNumber = xor & ~(xor - 1);

		for (int i = 0; i < dataArray.length; i++) {
			if ((dataArray[i] & setBitNumber) > 0) {
				x ^= dataArray[i];
			} else {
				y ^= dataArray[i];
			}
		}

		System.out.println("Two odd elements are:" + x + " and " + y);
	}

	public static void main(String[] args) {
		new TwoOddNumberInArray().findTwoOddNumber(new int[] { 4, 2, 4, 5, 2,
				3, 3, 1 });
	}
}
