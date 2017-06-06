package com.shoumo.geek.tree;

import java.util.Objects;

public class EvenOddLevelDifference {

	public int getLevelDifference(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;

		return node.data - getLevelDifference(node.left)
				- getLevelDifference(node.right);
	}

	public static void main(String[] args) {
		System.out.println("Level difference is:"
				+ new EvenOddLevelDifference().getLevelDifference(BinaryTree
						.getTree()));
	}
}
