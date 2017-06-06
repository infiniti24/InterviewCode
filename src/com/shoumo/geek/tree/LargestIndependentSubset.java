package com.shoumo.geek.tree;

import java.util.Objects;

public class LargestIndependentSubset {

	public int calculateLargestIndependentSubset(LargestIndependentSetNode node) {
		if (Objects.isNull(node))
			return 0;

		if (node.independentSubsetValue > 0)
			return node.independentSubsetValue;

		if (Objects.isNull(node.left) && Objects.isNull(node.right))
			return node.independentSubsetValue = 1;

		int valueExecRoot = calculateLargestIndependentSubset(node.left)
				+ calculateLargestIndependentSubset(node.right);

		int valueIncRoot = 1;

		if (Objects.nonNull(node.left)) {
			valueIncRoot += calculateLargestIndependentSubset(node.left.left)
					+ calculateLargestIndependentSubset(node.left.right);
		}

		if (Objects.nonNull(node.right)) {
			valueIncRoot += calculateLargestIndependentSubset(node.right.left)
					+ calculateLargestIndependentSubset(node.right.right);
		}

		return node.independentSubsetValue = Math.max(valueExecRoot,
				valueIncRoot);

	}

	public static void main(String[] args) {
		System.out.println("The largest independent set value is:"
				+ (new LargestIndependentSubset()
						.calculateLargestIndependentSubset(BinaryTree
								.getLargestIndependentSubsetNode())));
	}
}
