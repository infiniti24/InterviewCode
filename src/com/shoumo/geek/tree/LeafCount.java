package com.shoumo.geek.tree;

import java.util.Objects;

public class LeafCount {

	public int getLeafCount(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;

		if (Objects.isNull(node.right) && Objects.isNull(node.left))
			return 1;

		return getLeafCount(node.left) + getLeafCount(node.right);
	}

	public static void main(String[] args) {
		System.out.println("Number of leaf node is:"
				+ (new LeafCount().getLeafCount(BinaryTree.getTree())));
	}
}
