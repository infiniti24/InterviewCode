package com.shoumo.geek.arrays;

public class MinMaxTournamentSort {

	public MinMaxData getMinMax(int[] data, int low, int high) {
		MinMaxData minMaxData = new MinMaxData();
		if (low == high) {
			minMaxData.min = data[low];
			minMaxData.max = data[high];
			return minMaxData;
		}

		if (high == low + 1) {
			minMaxData.min = Math.min(data[low], data[high]);
			minMaxData.max = Math.max(data[low], data[high]);
			return minMaxData;
		}

		MinMaxData leftMinMaxData = new MinMaxData();
		MinMaxData rightMinMaxData = new MinMaxData();

		int mid = (low + high) / 2;
		leftMinMaxData = getMinMax(data, low, mid);
		rightMinMaxData = getMinMax(data, mid + 1, high);

		minMaxData.min = Math.min(leftMinMaxData.min, rightMinMaxData.min);
		minMaxData.max = Math.max(leftMinMaxData.max, rightMinMaxData.max);

		return minMaxData;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 1000, 11, 445, 1, 330, 3000 };
		MinMaxData minMaxData = new MinMaxTournamentSort().getMinMax(data, 0,
				data.length - 1);
		System.out.println("Min is:" + minMaxData.min + " max is:"
				+ minMaxData.max);
	}

	public static class MinMaxData {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	}
}
