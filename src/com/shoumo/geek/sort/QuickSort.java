package com.shoumo.geek.sort;

public class QuickSort {

	public int partition(int data[], int low, int high) {

		int pivot = data[high];
		int index = low - 1;

		for (int j = low; j < high; j++) {
			if (data[j] <= pivot) {

				index++;

				int temp = data[index];
				data[index] = data[j];
				data[j] = temp;
			}
		}

		int temp = data[index + 1];
		data[index + 1] = data[high];
		data[high] = temp;

		return index + 1;

	}

	public void sort(int[] data, int low, int high) {
		if (low < high) {

			int partitionIndex = partition(data, low, high);

			sort(data, low, partitionIndex - 1);
			sort(data, partitionIndex + 1, high);
		}
	}

	public void printArray(int[] dataArray) {
		for (Integer data : dataArray) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] data = { 5, 4, 3, 2, 1 };
		QuickSort qs = new QuickSort();
		qs.printArray(data);
		qs.sort(data, 0, data.length - 1);
		qs.printArray(data);
	}
}
