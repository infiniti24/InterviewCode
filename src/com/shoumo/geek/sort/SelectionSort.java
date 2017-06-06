package com.shoumo.geek.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

	public void selectionSort(List<Integer> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			int minIndex = -1;
			for (int j = i + 1; j < dataList.size(); j++) {
				if (dataList.get(i) > dataList.get(j))
					minIndex = j;
			}
			if (minIndex > 0) {
				swapElements(dataList, i, minIndex);
			}
		}
	}

	public void swapElements(List<Integer> dataList, int firstIndex,
			int secondIndex) {
		int temp = dataList.get(secondIndex);
		dataList.set(secondIndex, dataList.get(firstIndex));
		dataList.set(firstIndex, temp);

	}

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(5);
		dataList.add(4);
		dataList.add(3);
		dataList.add(2);
		dataList.add(1);
		System.out.println("Unsorted List:" + dataList.toString());
		new SelectionSort().selectionSort(dataList);
		System.out.println("Sorted List:" + dataList.toString());
	}
}
