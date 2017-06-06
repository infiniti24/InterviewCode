package com.shoumo.geek.arrays;

public class MinimumUnsortedArray {

	public void findMinimumUndortedIndices(int[] data) {
		int startingIndex = 0, endingIndex = data.length - 1;

		while (startingIndex < endingIndex) {
			while (data[startingIndex] <= data[startingIndex + 1])
				startingIndex++;

			break;

		}
		startingIndex++;
		while (endingIndex > startingIndex) {
			while (data[endingIndex] >= data[endingIndex - 1])
				endingIndex--;

			break;
		}
		endingIndex--;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int i = startingIndex; i <= endingIndex; i++) {
			if (data[i] > max)
				max = data[i];
			else if (data[i] < min)
				min = data[i];
		}
		boolean foundStart = false, foundEnd = false;
		int newStart = startingIndex, newEnd = endingIndex;
		for (int i = 0, j = data.length - 1; i < startingIndex
				|| j > endingIndex; i++, j--) {
			if (data[i] > min && !foundStart) {
				newStart = i;
				foundStart = true;
			}
			if (data[j] < max && !foundEnd) {
				newEnd = j;
				foundEnd = true;
			}
			if (foundStart && foundEnd) {
				break;
			}
		}

		System.out.println("Sort data between:" + newStart + " and " + newEnd);
	}

	public static void main(String[] args) {
		new MinimumUnsortedArray().findMinimumUndortedIndices(new int[] { 10,
				12, 20, 30, 25, 40, 32, 31, 35, 50, 60 });
	}
}
