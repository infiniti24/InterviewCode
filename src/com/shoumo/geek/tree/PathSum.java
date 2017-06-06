package com.shoumo.geek.tree;

import java.util.Objects;

public class PathSum {

	public boolean hasPathSum(SimpleNode node, int sum) {
		if (Objects.isNull(node)) {
			return sum == 0;
		}

		boolean hasSum = false;
		int subSum = sum - node.data;

		if (subSum == 0 && Objects.isNull(node.left)
				&& Objects.isNull(node.right))
			return true;
		if (node.left != null)
			hasSum = hasSum || hasPathSum(node.left, subSum);
		if (node.right != null)
			hasSum = hasSum || hasPathSum(node.right, subSum);

		return hasSum;
	}

	public static void main(String[] args) {
		System.out.println("Has path sum:"
				+ (new PathSum().hasPathSum(BinaryTree.getTree(), 23)));
	}
}
