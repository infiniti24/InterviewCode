package com.shoumo.geek.tree;

import java.util.Objects;

public class IdenticalTrees {

	public boolean isIdentical(SimpleNode node1, SimpleNode node2) {
		if (Objects.isNull(node1) && Objects.isNull(node2)) {
			return true;
		} else if (Objects.nonNull(node1) && Objects.nonNull(node2)) {
			return node1.data == node2.data
					&& isIdentical(node1.left, node2.left)
					&& isIdentical(node1.right, node2.right);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new IdenticalTrees().isIdentical(
				BinaryTree.getTree(), BinaryTree.getTree()));
	}
}
