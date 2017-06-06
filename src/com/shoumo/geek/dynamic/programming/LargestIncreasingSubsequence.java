package com.shoumo.geek.dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author shoumo
 * 
 *
 */
public class LargestIncreasingSubsequence {

	public Set<Integer> findLIS(List<Integer> dataList) {

		List<Integer> lisMaxList = new ArrayList<Integer>(dataList.size());

		for (int i = 0; i < dataList.size(); i++) {
			lisMaxList.add(1);
		}
		Map<Integer, Set<Integer>> maxListMap = new HashMap<Integer, Set<Integer>>();
		int currentMax = -1;
		int maxIndex = -1;
		for (int i = 1; i < dataList.size(); i++) {
			Set<Integer> tempMaxSet = new TreeSet<Integer>();
			int prevMaxIndex = -1;
			for (int j = 0; j < i; j++) {
				if (dataList.get(i) > dataList.get(j)
						&& lisMaxList.get(i) < lisMaxList.get(j) + 1) {
					tempMaxSet.add(dataList.get(j));
					tempMaxSet.add(dataList.get(i));
					lisMaxList.set(i, lisMaxList.get(j) + 1);
					prevMaxIndex = j;
				}
			}
			if (lisMaxList.get(i) >= currentMax) {
				maxIndex = i;
				currentMax = lisMaxList.get(i);
				if (Objects.nonNull(maxListMap.get(prevMaxIndex))) {
					Set<Integer> newSet = new TreeSet<Integer>(
							maxListMap.get(prevMaxIndex));
					newSet.add(dataList.get(i));
					maxListMap.put(i, newSet);
				} else {
					maxListMap.put(i, tempMaxSet);
				}
			}
		}
		System.out.println("Lis max set:" + lisMaxList.toString());
		return maxListMap.get(maxIndex);
	}

	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<Integer>();
		dataList.add(70);
		dataList.add(80);
		dataList.add(90);
		dataList.add(9);
		dataList.add(33);
		dataList.add(40);
		dataList.add(41);
		dataList.add(60);

		System.out.println(new LargestIncreasingSubsequence().findLIS(dataList)
				.toString());

	}
}
