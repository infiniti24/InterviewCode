package com.shoumo.geek.arrays;

public class MinimumPairSumArray {

	public void printMinimumSumPairs(int[] data) {
		int minSum = Integer.MAX_VALUE;

		int left = 0, right = data.length - 1, minLeft = 0, minRight = data.length - 1;

		if (data.length < 2) {
			System.out.println("Invalid input");
			return;
		}

		sort(data, left, right);

		while (left < right) {
			int sum = data[left] + data[right];
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = left;
				minRight = right;
			}
			if (sum < 0)
				left++;
			else
				right--;
		}

		System.out.println("The elements of min sum is:" + data[minLeft]
				+ " and " + data[minRight]);
	}

	public int partition(int[] data, int low, int high) {
		int pivot = data[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (data[j] <= pivot) {
				i++;

				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}

		int temp = data[i + 1];
		data[i + 1] = data[high];
		data[high] = temp;

		return i + 1;
	}

	public void sort(int[] data, int low, int high) {

		if (low < high) {
			int partition = partition(data, low, high);

			sort(data, low, partition - 1);
			sort(data, partition + 1, high);
		}
	}

	public static void main(String[] args) {
		new MinimumPairSumArray().printMinimumSumPairs(new int[] { 1, 60, -10,
				70, -80, 85 });
	}
}
