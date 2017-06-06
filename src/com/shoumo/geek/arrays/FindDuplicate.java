package com.shoumo.geek.arrays;

public class FindDuplicate {

	public void findDuplicateElements(int[] data) {

		for (int i = 0; i < data.length; i++) {
			if (data[Math.abs(data[i])] >= 0) {
				data[Math.abs(data[i])] = -data[Math.abs(data[i])];
			} else {
				System.out.print(Math.abs(data[i]) + " ");
			}
		}
	}

	public static void main(String[] args) {
		new FindDuplicate().findDuplicateElements(new int[] { 4, 2, 4, 5, 2, 3,
				1 });
	}
}
