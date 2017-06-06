package com.shoumo.geek.tree;

import java.util.Objects;

public class TopViewTree {

	public void printTopView(SimpleNode node, int horizontalDistance,
			int minHorizontalDistance, int maxHorizontalDistance) {
		if (Objects.isNull(node))
			return;

		if (horizontalDistance < minHorizontalDistance) {
			System.out.println(node.data);
			minHorizontalDistance = horizontalDistance;
		} else if (horizontalDistance > maxHorizontalDistance) {
			System.out.println(node.data);
			maxHorizontalDistance = horizontalDistance;
		}

		printTopView(node.left, horizontalDistance - 1, minHorizontalDistance,
				maxHorizontalDistance);
		printTopView(node.right, horizontalDistance + 1, minHorizontalDistance,
				maxHorizontalDistance);

	}

	public static void main(String[] args) {
		SimpleNode node = BinaryTree.getSkewedTree();
		if (Objects.nonNull(node)) {
			System.out.println(node.data);
			new TopViewTree().printTopView(node, 0, 0, 0);
		}
	}
}
