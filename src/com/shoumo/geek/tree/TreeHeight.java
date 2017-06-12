package com.shoumo.geek.tree;

import java.util.Objects;

public class TreeHeight {

	public int getHeight(SimpleNode node) {
		if (Objects.isNull(node)) {
			return 0;
		} else {
			int leftHeight = getHeight(node.left);
			int rightHeight = getHeight(node.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}

	}

	public static void main(String[] args) {
		System.out.println(new TreeHeight().getHeight(BinaryTree.getTree()));
	}
}
