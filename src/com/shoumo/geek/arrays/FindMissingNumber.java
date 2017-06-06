package com.shoumo.geek.arrays;

public class FindMissingNumber {

	public int findNumber(int[] dataArray) {
		int resultOne = 0;
		int resultTwo = 0;

		for (int i = 0; i < dataArray.length; i++) {
			resultOne ^= dataArray[i];
			resultTwo ^= i + 1;
		}

		return resultOne ^ resultTwo;
	}

	public static void main(String[] args) {
		System.out.println("Missing element is:"
				+ new FindMissingNumber()
						.findNumber(new int[] { 1, 2, 4, 5, 6 }));
	}
}
