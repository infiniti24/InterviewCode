package com.shoumo.geek.arrays;

public class NumberOddOccurrence {

	public int findNumber(int[] dataArray) {
		int result = 0;
		for (int i = 0; i < dataArray.length; i++) {
			result = result ^ dataArray[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Element occuring odd number of times is:"
				+ new NumberOddOccurrence().findNumber(new int[] { 2, 3, 5, 4,
						5, 2, 4, 3, 5, 2, 4, 4, 2 }));
	}
}
