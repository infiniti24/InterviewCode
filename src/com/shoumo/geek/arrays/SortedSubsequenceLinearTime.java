package com.shoumo.geek.arrays;

public class SortedSubsequenceLinearTime {

	public void findSubsequence(int dataArray[]) {
		int[] smallerArray = new int[dataArray.length];
		int[] greaterArray = new int[dataArray.length];

		int min = 0, max = dataArray.length - 1;

		smallerArray[min] = -1;
		greaterArray[max] = -1;

		for (int i = 1; i < dataArray.length; i++) {
			if (dataArray[i] <= dataArray[min]) {
				min = i;
				smallerArray[i] = -1;
			} else {
				smallerArray[i] = min;
			}
		}

		for (int i = dataArray.length - 2; i >= 0; i--) {
			if (dataArray[i] >= dataArray[max]) {
				max = i;
				greaterArray[i] = -1;
			} else {
				greaterArray[i] = max;
			}
		}

		for (int i = 0; i < dataArray.length; i++) {
			if (smallerArray[i] != -1 && greaterArray[i] != -1) {
				System.out
						.println("Triplet is:" + dataArray[smallerArray[i]]
								+ "," + dataArray[i] + ","
								+ dataArray[greaterArray[i]]);
				return;
			}
		}

		System.out.println("No such triplet found");
	}

	public static void main(String[] args) {
		new SortedSubsequenceLinearTime().findSubsequence(new int[] { 12, 11,
				10, 5, 6, 2, 30 });
	}
}
