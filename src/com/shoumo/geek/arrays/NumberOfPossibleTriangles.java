package com.shoumo.geek.arrays;

public class NumberOfPossibleTriangles {

	public void findTriangles(int[] dataArray) {
		sort(dataArray, 0, dataArray.length - 1);
		int count = 0;
		for (int i = 0; i < dataArray.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < dataArray.length; j++) {

				while (k < dataArray.length
						&& dataArray[i] + dataArray[j] > dataArray[k])
					k++;

				count += k - j - 1;
			}
		}

		System.out.println("Total number of triangles are:" + count);
	}

	public int partition(int[] dataArray, int low, int high) {
		int pivot = dataArray[high];

		int index = low - 1;

		for (int i = low; i < high; i++) {
			if (dataArray[i] <= pivot) {
				index++;

				int temp = dataArray[index];
				dataArray[index] = dataArray[i];
				dataArray[i] = temp;
			}
		}

		int temp = dataArray[high];
		dataArray[high] = dataArray[index + 1];
		dataArray[index + 1] = temp;

		return index + 1;
	}

	public void sort(int[] data, int low, int high) {
		if (low < high) {
			int partition = partition(data, low, high);

			sort(data, low, partition - 1);
			sort(data, partition + 1, high);
		}
	}

	public static void main(String[] args) {
		new NumberOfPossibleTriangles().findTriangles(new int[] { 10, 21, 22,
				100, 101, 200, 300 });
	}
}
