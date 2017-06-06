package com.shoumo.geek.tree;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CompleteBinaryTree {

	public boolean isCompleteBT(SimpleNode root) {
		Queue<SimpleNode> dataQueue = new LinkedBlockingQueue<SimpleNode>();

		dataQueue.add(root);
		boolean flag = false;
		while (!dataQueue.isEmpty()) {
			SimpleNode node = dataQueue.poll();
			if (Objects.nonNull(node.left)) {
				if (flag)
					return false;
				dataQueue.add(node.left);
			} else {
				flag = true;
			}
			if (Objects.nonNull(node.right)) {
				if (flag)
					return false;
				dataQueue.add(node.right);
			} else {
				flag = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out
				.println("Is Complete binary tree:"
						+ (new CompleteBinaryTree().isCompleteBT(BinaryTree
								.getTree())));
	}
}
