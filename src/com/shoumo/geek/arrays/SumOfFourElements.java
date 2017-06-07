package com.shoumo.geek.arrays;

public class SumOfFourElements {

	public void findFourElementSum(int[] data, int sum) {

		int auxilaryArraySize = (data.length * (data.length - 1)) / 2;

		PairSum[] auxilaryArray = new PairSum[auxilaryArraySize];

		int k = 0;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length - 1; j++) {
				auxilaryArray[k++] = new PairSum(data[i], data[j]);
			}
		}

		sort(auxilaryArray, 0, k - 1);

		int i = 0, j = k - 1;
		while (i < k && j >= 0) {
			if (auxilaryArray[i].sum + auxilaryArray[j].sum == sum
					&& auxilaryArray[i].isNonCommon(auxilaryArray[j])) {
				System.out.println("Elements are:"
						+ auxilaryArray[i].firstElement + ","
						+ auxilaryArray[i].secondElement + ","
						+ auxilaryArray[j].firstElement + ","
						+ auxilaryArray[j].secondElement);
				break;
			} else if (auxilaryArray[i].sum + auxilaryArray[j].sum < sum)
				i++;
			else
				j++;
		}
	}

	public int partition(PairSum[] data, int low, int high) {
		PairSum pivot = data[high];

		int index = low - 1;

		for (int j = low; j < high; j++) {
			if (data[j].sum <= pivot.sum) {

				index++;

				PairSum temp = data[index];
				data[index] = data[j];
				data[j] = temp;
			}
		}

		PairSum temp = data[index + 1];
		data[index + 1] = data[high];
		data[high] = temp;

		return index + 1;

	}

	public void sort(PairSum[] data, int low, int high) {
		if (low < high) {

			int partitionIndex = partition(data, low, high);

			sort(data, low, partitionIndex - 1);
			sort(data, partitionIndex + 1, high);
		}
	}

	public static class PairSum implements Comparable<PairSum> {
		int firstElement;
		int secondElement;
		int sum;

		public PairSum(int firstElement, int secondElement) {
			this.firstElement = firstElement;
			this.secondElement = secondElement;
			this.sum = firstElement + secondElement;
		}

		@Override
		public int compareTo(PairSum o) {
			return this.sum - o.sum;
		}

		public boolean isNonCommon(PairSum secondPair) {
			if (this.firstElement == secondPair.firstElement
					|| this.firstElement == secondPair.secondElement
					|| this.secondElement == secondPair.firstElement
					|| this.secondElement == secondPair.secondElement)
				return false;

			return true;
		}

		@Override
		public String toString() {
			return this.firstElement + "," + this.secondElement;
		}

	}

	public static void main(String[] args) {
		new SumOfFourElements().findFourElementSum(new int[] { 10, 20, 30, 40,
				1, 2 }, 91);
	}
}
