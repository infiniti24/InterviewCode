package com.shoumo.geek.arrays;

public class TwoSortedArrayMedian {

	public int findMedian(int[] arrayOne, int[] arrayTwo, int n) {
		if (n <= 0)
			return -1;

		if (n == 1)
			return (arrayOne[0] + arrayTwo[0]) / 2;

		if (n == 2)
			return (Math.max(arrayOne[0], arrayTwo[0]) + Math.min(arrayOne[1],
					arrayTwo[1])) / 2;

		int medianOne = median(arrayOne, n);
		int medianTwo = median(arrayTwo, n);

		if (medianOne == medianTwo)
			return medianOne;

		if (medianOne < medianTwo) {
			if (n % 2 == 0)
				return findMedian(shortenArray(arrayOne, n / 2 + 1, n),
						arrayTwo, n - n / 2 + 1);

			return findMedian(shortenArray(arrayOne, n / 2, n), arrayTwo, n - n
					/ 2);
		}

		if (n % 2 == 0)
			return findMedian(shortenArray(arrayTwo, n / 2 + 1, n), arrayOne, n
					- n / 2 + 1);

		return findMedian(shortenArray(arrayTwo, n / 2, n), arrayOne, n - n / 2);

	}

	public int[] shortenArray(int[] dataArray, int startingIndex,
			int endingIndex) {
		int[] tempArray = new int[endingIndex - startingIndex];
		for (int i = startingIndex, k = 0; i < endingIndex; i++, k++) {
			tempArray[k] = dataArray[i];
		}
		return tempArray;
	}

	public int median(int[] dataArray, int n) {
		if (dataArray.length == 1)
			return dataArray[0];
		if (n % 2 == 0) {
			return (dataArray[n / 2] + dataArray[n / 2 - 1]) / 2;
		} else {
			return dataArray[n / 2];
		}
	}

	public static void main(String[] args) {
		System.out.println("Median is:"
				+ new TwoSortedArrayMedian().findMedian(new int[] { 1, 12, 15,
						26, 38 }, new int[] { 2, 13, 17, 30, 45 }, 5));
	}
}
