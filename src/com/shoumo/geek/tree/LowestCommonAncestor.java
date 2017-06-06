package com.shoumo.geek.tree;

import java.util.Objects;

public class LowestCommonAncestor {

	public SimpleNode findLCA(SimpleNode node, int firstNodeData,
			int secondNodeData) {
		if (Objects.isNull(node)) {
			return null;
		}

		if (node.data == firstNodeData || node.data == secondNodeData)
			return node;

		SimpleNode leftLCA = findLCA(node.left, firstNodeData, secondNodeData);
		SimpleNode rightLCA = findLCA(node.right, firstNodeData, secondNodeData);

		if (Objects.nonNull(leftLCA) && Objects.nonNull(rightLCA))
			return node;

		return Objects.nonNull(leftLCA) ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {
		System.out
				.println("LCA is:"
						+ new LowestCommonAncestor().findLCA(
								BinaryTree.getTree(), 4, 7));
	}
}
