package com.shoumo.geek.sort;

public class MergeSort {

	public void merge(int[] data, int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; ++i) {
			leftArray[i] = data[left + i];
		}

		for (int j = 0; j < n2; ++j) {
			rightArray[j] = data[middle + 1 + j];
		}

		int i = 0, j = 0;

		int k = left;

		while (i < n1 && j < n2) {
			if (leftArray[i] < rightArray[j]) {
				data[k] = leftArray[i];
				i++;
			} else {
				data[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			data[k++] = leftArray[i++];
		}

		while (j < n2) {
			data[k++] = rightArray[j++];
		}
	}

	public void sort(int[] data, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			sort(data, left, mid);
			printArray(data);
			sort(data, mid + 1, right);
			printArray(data);

			merge(data, left, mid, right);
			printArray(data);
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
		MergeSort m = new MergeSort();
		m.sort(data, 0, data.length - 1);
		m.printArray(data);

	}
}
