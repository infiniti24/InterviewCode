package com.shoumo.geek.arrays;

public class MinimumDistanceBetweenTwoElements {

	public void findDistance(int[] data, int firstElement, int secondElement) {
		int prevElement = -1, prevIndex = -1, minDistance = -1;

		for (int i = 0; i < data.length; i++) {
			if (data[i] == firstElement || data[i] == secondElement) {
				if ((prevElement == firstElement && data[i] == secondElement)
						|| (prevElement == secondElement && data[i] == firstElement)) {
					minDistance = i - prevIndex;
					break;
				} else {
					prevIndex = i;
				}
				prevElement = data[i];
			}
		}

		System.out.println("Minimum distance is:" + minDistance);
	}

	public static void main(String[] args) {
		new MinimumDistanceBetweenTwoElements().findDistance(new int[] { 3, 5,
				4, 2, 6, 5, 6, 6, 5, 4, 8, 3 }, 3, 6);
	}
}
