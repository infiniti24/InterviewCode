package com.shoumo.geek.tree;

import java.util.Objects;

public class SumTree {

	public int getSum(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;

		if (Objects.isNull(node.left) && Objects.isNull(node.right))
			return node.data;

		int leftSum = getSum(node.left);
		int rightSum = getSum(node.right);

		if (leftSum == -1 || rightSum == -1 || node.data != leftSum + rightSum)
			return -1;

		return node.data + leftSum + rightSum;

	}

	public static void main(String[] args) {
		System.out.println("Is Sum tree:"
				+ (new SumTree().getSum(BinaryTree.getTree()) != -1));
	}
}
