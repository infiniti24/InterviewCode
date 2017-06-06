package com.shoumo.geek.tree;

import java.util.Objects;

public class SpiralTreeRecursive {

	public void printSpiral(SimpleNode node) {
		int height = BinaryTree.getHeight(node);
		boolean leftPrint = true;
		for (int i = 1; i <= height; i++) {
			printGivenLevel(node, i, leftPrint);
			System.out.println();
			leftPrint = !leftPrint;
		}
	}

	public void printGivenLevel(SimpleNode node, int level, boolean leftPrint) {
		if (Objects.isNull(node))
			return;

		if (level == 1)
			System.out.print(node.data + " ");

		if (level > 1) {
			if (leftPrint) {
				printGivenLevel(node.left, level - 1, leftPrint);
				printGivenLevel(node.right, level - 1, leftPrint);
			} else {
				printGivenLevel(node.right, level - 1, leftPrint);
				printGivenLevel(node.left, level - 1, leftPrint);
			}
		}
	}

	public static void main(String[] args) {
		new SpiralTreeRecursive().printSpiral(BinaryTree.getTree());
	}
}
