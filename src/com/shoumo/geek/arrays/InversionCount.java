package com.shoumo.geek.arrays;

public class InversionCount {

	public int mergeDataAndGetInversion(int[] data, int[] temp, int left,
			int right) {
		int mid, inversionCount = 0;
		if (right > left) {
			mid = (right + left) / 2;

			inversionCount = mergeDataAndGetInversion(data, temp, left, mid);
			inversionCount += mergeDataAndGetInversion(data, temp, mid + 1,
					right);

			inversionCount += mergeData(data, temp, left, mid + 1, right);
		}
		return inversionCount;
	}

	public int mergeData(int[] data, int[] temp, int left, int mid, int right) {
		int inversionCount = 0;

		int i = left, j = mid, k = left;

		while (i <= mid - 1 && j <= right) {

			if (data[i] <= data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];

				inversionCount += mid - i;
			}
		}

		while (i < mid - 1) {
			temp[k++] = data[i++];
		}

		while (j <= right) {
			temp[k++] = data[j++];
		}

		for (i = left; i <= right; i++) {
			data[i] = temp[i];
		}

		return inversionCount;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 1, 20, 6, 4, 5 };
		System.out.println("Inversion count for given data is:"
				+ new InversionCount().mergeDataAndGetInversion(data,
						new int[data.length], 0, data.length - 1));
	}
}
