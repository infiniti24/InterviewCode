package com.shoumo.geek.arrays;

public class EquilibriumPoint {

	public void findEquilibriumPoint(int[] data) {
		int sum = 0, leftSum = 0;

		for (Integer dataElement : data) {
			sum += dataElement;
		}

		for (int i = 0; i < data.length; i++) {
			sum -= data[i];

			if (leftSum == sum)
				System.out.print(i + " ");

			leftSum += data[i];
		}
	}

	public static void main(String[] args) {
		new EquilibriumPoint().findEquilibriumPoint(new int[] { -7, 1, 5, 2,
				-4, 3, 0 });
	}
}
