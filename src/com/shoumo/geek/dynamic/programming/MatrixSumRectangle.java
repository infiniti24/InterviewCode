package com.shoumo.geek.dynamic.programming;

public class MatrixSumRectangle {

	public int[] findMaximumSum(int[] array) {
		/**
		 * 0 = max value <br/>
		 * 1 = starting index <br/>
		 * 2 = ending index <br/>
		 */
		int[] result = new int[] { Integer.MIN_VALUE, 0, -1 };
		int currentSum = 0;
		int localStart = 0;

		for (int i = 0; i < array.length; i++) {
			currentSum += array[i];
			if (currentSum < 0) {
				currentSum = 0;
				localStart = i + 1;
			} else if (currentSum > result[0]) {
				result[0] = currentSum;
				result[1] = localStart;
				result[2] = i;
			}
		}

		if (result[2] == -1) {
			result[0] = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] > result[0]) {
					result[0] = array[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}
		return result;
	}

	public void findMaximumRectangleSum(int[][] dataArray) {
		int columns = dataArray[0].length;
		int rows = dataArray.length;
		int maxSum = Integer.MIN_VALUE;
		int[] currentResult;
		int left = 0, top = 0, right = 0, bottom = 0;

		for (int leftCol = 0; leftCol < columns; leftCol++) {
			int[] tempSum = new int[rows];
			for (int rightCol = leftCol; rightCol < columns; rightCol++) {
				for (int i = 0; i < rows; i++) {
					tempSum[i] += dataArray[i][rightCol];
				}
				currentResult = findMaximumSum(tempSum);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					right = rightCol;
					top = currentResult[1];
					bottom = currentResult[2];
				}
			}
		}

		System.out.println("MaxSum: " + maxSum + ", range: [(" + left + ", "
				+ top + ")(" + right + ", " + bottom + ")]");
	}

	public static void main(String[] args) {
		new MatrixSumRectangle().findMaximumRectangleSum(new int[][] {
				{ 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 },
				{ -4, -1, 1, 7, -6 } });
	}
}
