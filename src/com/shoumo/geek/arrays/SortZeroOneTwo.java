package com.shoumo.geek.arrays;

public class SortZeroOneTwo {

	public void sortData(int[] data) {
		printData(data);
		int mid = 0, low = 0, high = data.length - 1;

		while (mid <= high) {
			int temp = -1;
			switch (data[mid]) {
			case 0:
				temp = data[low];
				data[low++] = data[mid];
				data[mid++] = temp;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = data[mid];
				data[mid] = data[high];
				data[high--] = temp;

			}
		}

		printData(data);
	}

	public void printData(int[] data) {
		for (Integer dataElement : data) {
			System.out.print(dataElement + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new SortZeroOneTwo().sortData(new int[] { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0,
				0, 1 });
	}
}
