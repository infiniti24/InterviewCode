package com.shoumo.mycode.list;

import java.util.Objects;

public class MergeSortedLinkedList {

	public void mergeList(Node list1, Node list2) {
		Node mergedList = null;
		if (Objects.nonNull(list1) && Objects.nonNull(list2)) {
			if (list1.data < list2.data) {
				mergedList = mergeListWithSmallerData(list1, list2);
			} else {
				mergedList = mergeListWithSmallerData(list2, list1);
			}
		}
		while (mergedList != null) {
			System.out.print(mergedList.data + " ");
			mergedList = mergedList.nextNode;
		}
	}

	public Node mergeListWithSmallerData(Node list1, Node list2) {
		Node mainPointer = list1;
		while (list1.nextNode != null && list2 != null) {
			if (list1.nextNode.data > list2.data) {
				Node nextBiggerNode = list2;
				list2 = list2.nextNode;
				nextBiggerNode.nextNode = list1.nextNode;
				list1.nextNode = nextBiggerNode;
			}
			list1 = list1.nextNode;
		}
		if (list2 != null) {
			list1.nextNode = list2;
		}
		return mainPointer;
	}

	public static void main(String[] args) {
		Node list1 = new Node(1);
		list1.nextNode = new Node(2);
		Node list2 = new Node(3);
		new MergeSortedLinkedList().mergeList(list1, list2);
	}

	private static class Node {
		private int data;
		private Node nextNode = null;

		public Node(int data) {
			this.data = data;
		}
	}

}
