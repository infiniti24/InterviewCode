package com.shoumo.geek.tree;

import java.util.Objects;

public class TreeDiameter {

	public int diameter(SimpleNode node, Height height) {
		Height leftHeight = new Height();
		Height rightHeight = new Height();

		if (Objects.isNull(node)) {
			height.h = 0;
			return 0;
		}

		leftHeight.h++;
		rightHeight.h++;

		int leftDiameter = diameter(node.left, leftHeight);
		int rightDiameter = diameter(node.right, rightHeight);

		height.h = Math.max(leftHeight.h, rightHeight.h) + 1;

		return Math.max(leftHeight.h + rightHeight.h + 1,
				Math.max(leftDiameter, rightDiameter));
	}

	public static void main(String[] args) {
		System.out.println("Diameter of the tree is:"
				+ new TreeDiameter().diameter(BinaryTree.getTree(),
						new Height()));
	}

	public static class Height {
		int h;
	}
}
