package com.shoumo.geek.tree;

import java.util.Objects;

public class MaximumWidth {

	public int getMaxWidth(SimpleNode node) {
		int maxWidth = 0, width = 0, height = getHeight(node);

		for (int i = 1; i <= height; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}
		return maxWidth;

	}

	public int getWidth(SimpleNode node, int level) {
		if (Objects.isNull(node))
			return 0;

		if (level == 1)
			return 1;

		if (level > 1)
			return getWidth(node.left, level - 1)
					+ getWidth(node.right, level - 1);

		return 0;
	}

	public int getHeight(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		System.out.println("Maximum width of tree is:"
				+ new MaximumWidth().getMaxWidth(BinaryTree.getTree()));
	}
}
