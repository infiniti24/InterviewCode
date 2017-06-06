package com.shoumo.geek.tree;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectSameLevel {

	Queue<SameLevelNode> dataQueue = new LinkedBlockingQueue<>();
	SameLevelNode levelDelim = new SameLevelNode(Integer.MAX_VALUE);

	public void connectSameLevel(SameLevelNode root) {
		dataQueue.add(root);
		dataQueue.add(levelDelim);
		while (!dataQueue.isEmpty()) {
			boolean wasLevelAdded = false;
			while (dataQueue.peek().data != Integer.MAX_VALUE) {
				SameLevelNode node = dataQueue.poll();
				if (Objects.nonNull(node.left)) {
					dataQueue.add(node.left);
				}
				if (Objects.nonNull(node.right)) {
					dataQueue.add(node.right);
				}
				if (dataQueue.peek().data != Integer.MAX_VALUE) {
					node.nextRight = dataQueue.peek();
				}
				wasLevelAdded = true;
			}
			dataQueue.poll();
			if (wasLevelAdded) {
				dataQueue.add(levelDelim);
			}
		}
	}

	public void printInorder(SameLevelNode node) {
		if (Objects.isNull(node))
			return;

		printInorder(node.left);
		System.out.println("Node:"
				+ node.data
				+ " rightNode:"
				+ (Objects.nonNull(node.nextRight) ? node.nextRight.data
						: node.nextRight));
		printInorder(node.right);
	}

	public static void main(String[] args) {
		SameLevelNode root = BinaryTree.getSameLevelTree();
		ConnectSameLevel csl = new ConnectSameLevel();
		csl.connectSameLevel(root);
		csl.printInorder(root);
	}
}
