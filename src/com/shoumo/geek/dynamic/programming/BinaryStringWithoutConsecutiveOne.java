package com.shoumo.geek.dynamic.programming;

public class BinaryStringWithoutConsecutiveOne {

	public int findStrings(int stringlength) {
		int[] a = new int[stringlength];
		int[] b = new int[stringlength];

		a[0] = b[0] = 1;

		for (int i = 1; i < stringlength; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}

		return a[stringlength - 1] + b[stringlength - 1];
	}

	public static void main(String[] args) {
		System.out
				.println("Number of binary string without consecutive 1's are:"
						+ new BinaryStringWithoutConsecutiveOne()
								.findStrings(5));
	}
}
