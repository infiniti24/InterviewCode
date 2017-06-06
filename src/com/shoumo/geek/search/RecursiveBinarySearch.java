package com.shoumo.geek.search;

import java.util.ArrayList;
import java.util.List;

public class RecursiveBinarySearch {

	public int binarySearch(List<Integer> dataList, int left, int right,
			int number) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (dataList.get(mid) == number) {
				return mid;
			}
			if (dataList.get(mid) > number) {
				return binarySearch(dataList, left, mid - 1, number);
			}
			return binarySearch(dataList, mid + 1, right, number);
		}
		return -1;
	}

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(1);
		dataList.add(2);
		dataList.add(3);
		dataList.add(4);
		dataList.add(5);
		int index = new RecursiveBinarySearch().binarySearch(dataList, 0,
				dataList.size(), 5);
		System.out.println("Index is:" + index);
	}
}
