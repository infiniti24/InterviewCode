package com.shoumo.geek.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public void bubbleSort(List<Integer> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			for (int j = 0; j < dataList.size() - i - 1; j++) {
				if (dataList.get(j) > dataList.get(j + 1)) {
					int temp = dataList.get(j + 1);
					dataList.set(j + 1, dataList.get(j));
					dataList.set(j, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(5);
		dataList.add(4);
		dataList.add(3);
		dataList.add(2);
		dataList.add(1);
		System.out.println("Unsorted List:" + dataList.toString());
		new BubbleSort().bubbleSort(dataList);
		System.out.println("Sorted List:" + dataList.toString());
	}
}
