package com.shoumo.geek.sort;

public class HeapSort {

	public void sort(int data[]) {
		int size = data.length;
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(data, size, i);
			printArray(data);
		}

		for (int i = size - 1; i > 0; i--) {
			data[0] = data[0] + data[i];
			data[i] = data[0] - data[i];
			data[0] = data[0] - data[i];
			heapify(data, i, 0);
			printArray(data);
		}
	}

	public void heapify(int[] data, int heapSize, int root) {
		int largest = root;
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;

		if (leftChild < heapSize && data[leftChild] > data[largest])
			largest = leftChild;

		if (rightChild < heapSize && data[rightChild] > data[largest])
			largest = rightChild;

		if (largest != root) {
			data[root] = data[root] + data[largest];
			data[largest] = data[root] - data[largest];
			data[root] = data[root] - data[largest];

			heapify(data, heapSize, largest);
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
		HeapSort hs = new HeapSort();
		hs.sort(data);
		hs.printArray(data);
	}
}
