package com.shoumo.geek.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LevelOrderTraversal {

	public SimpleNode root;

	public LevelOrderTraversal(SimpleNode node) {
		this.root = node;
	}

	public void levelOrderTraversal() {
		if (Objects.isNull(this.root)) {
			return;
		}
		Queue<SimpleNode> queue = new LinkedList<SimpleNode>();
		queue.add(this.root);
		while (true) {
			int nodeCount = queue.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0) {
				SimpleNode node = queue.poll();
				System.out.print(node.data + " ");
				if (Objects.nonNull(node.left))
					queue.add(node.left);
				if (Objects.nonNull(node.right))
					queue.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new LevelOrderTraversal(BinaryTree.getTree()).levelOrderTraversal();
	}
}
