package com.shoumo.mycode.list;

import java.util.ArrayList;
import java.util.List;

public class MissingTermInGeometricProgression {

	public int findMissingRecursively(List<Integer> dataList, int low,
			int high, int ratio) {
		if (low >= high)
			return -1;

		int mid = low + (high - low) / 2;

		if (dataList.get(mid + 1) / dataList.get(mid) != ratio)
			return dataList.get(mid) * ratio;

		if (mid > 0 && dataList.get(mid) / dataList.get(mid - 1) != ratio)
			return dataList.get(mid - 1) * ratio;

		int firstRatio = (dataList.get(0) == 1) ? dataList.get(1) : dataList
				.get(0);
		if (firstRatio * Math.pow(ratio, mid) == dataList.get(mid))
			return findMissingRecursively(dataList, mid + 1, high, firstRatio);

		return findMissingRecursively(dataList, low, mid - 1, firstRatio);

	}

	public int findMissing(List<Integer> dataList) {
		int firstRatio = (dataList.get(0) == 1) ? dataList.get(1) : dataList
				.get(0);
		int ratio = (int) Math.pow(dataList.get(dataList.size() - 1)
				/ firstRatio, (float) 1 / dataList.size());
		return findMissingRecursively(dataList, 0, dataList.size(), ratio);
	}

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add((int) Math.pow(2, 1));
		dataList.add((int) Math.pow(2, 2));
		dataList.add((int) Math.pow(2, 3));
		dataList.add((int) Math.pow(2, 5));
		System.out.println(new MissingTermInGeometricProgression()
				.findMissing(dataList));
	}
}
