package com.shoumo.geek.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SortElementByFrequency {

	public void sortByFrequency(int[] dataArray) {
		BSTNode root = null;
		for (int i = 0; i < dataArray.length; i++) {
			root = insertIntoBST(root, dataArray[i], i);
		}

		List<BSTNode> inorderList = new ArrayList<>();

		storeDataInorder(root, inorderList);

		sort(inorderList, 0, inorderList.size() - 1);
		int j = 0;
		for (int i = 0; i < inorderList.size(); i++) {
			BSTNode node = inorderList.get(i);
			for (int k = 0; k < node.frequency; k++) {
				dataArray[j] = node.data;
				j++;
			}
		}

	}

	public int partition(List<BSTNode> dataList, int low, int high) {

		BSTNode pivot = dataList.get(high);
		int index = low - 1;

		for (int j = low; j < high; j++) {
			if (dataList.get(j).frequency > pivot.frequency
					|| (dataList.get(j).frequency == pivot.frequency && dataList
							.get(j).firstIndex < pivot.firstIndex)) {

				index++;

				BSTNode temp = dataList.get(index);
				dataList.set(index, dataList.get(j));
				dataList.set(j, temp);
			}
		}
		BSTNode temp = dataList.get(index + 1);
		dataList.set(index + 1, dataList.get(high));
		dataList.set(high, temp);

		return index + 1;

	}

	public void sort(List<BSTNode> dataList, int low, int high) {
		if (low < high) {

			int partitionIndex = partition(dataList, low, high);

			sort(dataList, low, partitionIndex - 1);
			sort(dataList, partitionIndex + 1, high);
		}
	}

	public void storeDataInorder(BSTNode node, List<BSTNode> dataList) {
		if (Objects.isNull(node))
			return;

		storeDataInorder(node.left, dataList);
		dataList.add(node);
		storeDataInorder(node.right, dataList);
	}

	public BSTNode insertIntoBST(BSTNode root, int data, int index) {
		if (Objects.isNull(root))
			return new BSTNode(data, index);

		if (root.data == data)
			root.frequency++;
		else if (root.data > data)
			root.left = insertIntoBST(root.left, data, index);
		else
			root.right = insertIntoBST(root.right, data, index);

		return root;
	}

	public static class BSTNode {
		int data;
		int firstIndex = -1;
		int frequency = 1;
		BSTNode left = null;
		BSTNode right = null;

		public BSTNode(int data, int firstIndex) {
			this.data = data;
			this.firstIndex = firstIndex;
		}
	}

	public void printArray(int[] dataArray) {
		for (int i = 0; i < dataArray.length; i++) {
			System.out.print(dataArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortElementByFrequency slbf = new SortElementByFrequency();
		int[] dataArray = new int[] { 2, 3, 2, 4, 5, 12, 2, 3, 3, 12 };

		slbf.printArray(dataArray);
		slbf.sortByFrequency(dataArray);
		slbf.printArray(dataArray);
	}

}
