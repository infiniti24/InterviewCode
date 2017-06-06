package com.shoumo.geek.tree;

import java.util.Objects;

public class KDistanceFromRoot {

	public void printKDistant(SimpleNode node, int k) {
		if (Objects.isNull(node))
			return;
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}

	public static void main(String[] args) {
		new KDistanceFromRoot().printKDistant(BinaryTree.getTree(), 2);
	}
}
