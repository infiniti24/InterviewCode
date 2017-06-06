package com.shoumo.geek.tree;

import java.util.Objects;

public class SumProperty {

	public int isSumProperty(SimpleNode node) {

		int leftData = 0, rightData = 0;

		if (Objects.isNull(node)
				|| (Objects.isNull(node.left) && Objects.isNull(node.right))) {
			return 1;
		} else {
			if (Objects.nonNull(node.left))
				leftData = node.left.data;

			if (Objects.nonNull(node.right))
				rightData = node.right.data;

			if ((node.data == leftData + rightData)
					&& (isSumProperty(node.left) != 0 && isSumProperty(node.right) != 0))
				return 1;
			else
				return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("Does given tree satisfy sum property: "
				+ (new SumProperty().isSumProperty(BinaryTree.getTree()) != 0));
	}
}
