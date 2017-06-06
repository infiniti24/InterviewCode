package com.shoumo.geek.arrays;

public class SegregateOddEven {

	public void segregateOddEven(int[] data) {

		printArray(data);

		int left = 0, right = data.length - 1;

		while (left < right) {
			while (data[left] % 2 == 0 && left < right)
				left++;

			while (data[right] % 2 != 0 && left < right)
				right--;

			if (left < right) {
				int temp = data[left];
				data[left++] = data[right];
				data[right--] = temp;
			}
		}

		printArray(data);
	}

	public void printArray(int[] data) {
		for (Integer dataElement : data) {
			System.out.print(dataElement + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new SegregateOddEven().segregateOddEven(new int[] { 12, 34, 45, 9, 8,
				90, 3 });
	}
}
