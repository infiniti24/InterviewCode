package com.shoumo.geek.arrays;

public class ElementInSortedRotatedArray {

	public int findElement(int[] dataArray, int left, int right, int key) {
		if (left > right)
			return -1;

		int mid = (left + right) / 2;
		if (dataArray[mid] == key)
			return mid;

		if (dataArray[left] <= dataArray[mid]) {
			if (key >= dataArray[left] && key < dataArray[mid]) {
				return findElement(dataArray, left, mid - 1, key);
			}
			return findElement(dataArray, mid + 1, right, key);
		}

		if (key > dataArray[mid] && key <= dataArray[right]) {
			return findElement(dataArray, mid + 1, right, key);
		}

		return findElement(dataArray, left, mid - 1, key);
	}

	public static void main(String[] args) {
		int[] dataArray = new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		System.out.println("Element is at index:"
				+ new ElementInSortedRotatedArray().findElement(dataArray, 0,
						dataArray.length - 1, 6));
	}
}
