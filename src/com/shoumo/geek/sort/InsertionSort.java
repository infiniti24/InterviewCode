package com.shoumo.geek.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

	public void sort(List<Integer> dataList) {
		for (int i = 1; i < dataList.size(); i++) {
			int key = dataList.get(i);
			int j = i - 1;

			while (j >= 0 && dataList.get(j) > key) {
				dataList.set(j + 1, dataList.get(j));
				j--;
			}
			dataList.set(j + 1, key);
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
		new InsertionSort().sort(dataList);
		System.out.println("Sorted List:" + dataList.toString());
	}
}
