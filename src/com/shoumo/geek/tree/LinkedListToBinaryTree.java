package com.shoumo.geek.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LinkedListToBinaryTree {

	public SimpleNode convertListToTree(Queue<Integer> dataList) {

		Queue<SimpleNode> dataQueue = new LinkedList<SimpleNode>();

		if (Objects.isNull(dataList)) {
			return null;
		}

		SimpleNode node = new SimpleNode(dataList.peek());
		dataQueue.add(node);

		dataList.poll();

		while (!dataList.isEmpty()) {
			SimpleNode parent = dataQueue.poll();

			SimpleNode leftNode = new SimpleNode(dataList.poll());
			parent.left = leftNode;
			dataQueue.add(leftNode);
			if (!dataList.isEmpty()) {
				SimpleNode rightNode = new SimpleNode(dataList.poll());
				parent.right = rightNode;
				dataQueue.add(rightNode);
			}
		}

		return node;
	}

	public void printInoder(SimpleNode node) {
		if (Objects.isNull(node))
			return;
		printInoder(node.left);
		System.out.print(node.data + " ");
		printInoder(node.right);
	}

	public static void main(String[] args) {
		LinkedListToBinaryTree llbt = new LinkedListToBinaryTree();
		Queue<Integer> dataList = new LinkedList<Integer>();
		dataList.add(36);
		dataList.add(30);
		dataList.add(25);
		dataList.add(15);
		dataList.add(12);
		dataList.add(10);
		llbt.printInoder(llbt.convertListToTree(dataList));

	}
}
