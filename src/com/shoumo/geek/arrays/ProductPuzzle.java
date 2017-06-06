package com.shoumo.geek.arrays;

public class ProductPuzzle {

	public void constructProductArray(int[] data) {

		int[] product = new int[data.length];
		int temp = 1;

		for (int i = 0; i < data.length; i++) {
			product[i] = 1;
		}

		for (int i = 0; i < data.length; i++) {
			product[i] = temp;
			temp *= data[i];
		}

		temp = 1;

		for (int j = data.length - 1; j >= 0; j--) {
			product[j] *= temp;
			temp *= data[j];
		}

		for (Integer dataElement : product) {
			System.out.print(dataElement + " ");
		}
	}

	public static void main(String[] args) {
		new ProductPuzzle().constructProductArray(new int[] { 10, 3, 5, 6, 2 });
	}
}
