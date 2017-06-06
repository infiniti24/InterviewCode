package com.shoumo.geek.tree;

import java.util.Objects;

public class RootLeafMaxSum {

	int maxSum = Integer.MIN_VALUE;

	public void findMaxSum(SimpleNode node, int sum) {
		if (Objects.isNull(node))
			return;

		sum = sum + node.data;

		if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
			if (sum > maxSum) {
				maxSum = sum;
			}
		}

		findMaxSum(node.left, sum);
		findMaxSum(node.right, sum);
	}

	public static void main(String[] args) {
		RootLeafMaxSum rlms = new RootLeafMaxSum();
		rlms.findMaxSum(BinaryTree.getTree(), 0);
		System.out.println("Max sum is:" + rlms.maxSum);
	}

}
