package com.shoumo.geek.tree;

import java.util.Objects;

public class BinaryTree {

	public static SimpleNode getTree() {
		SimpleNode root = new SimpleNode(1);
		root.left = new SimpleNode(2);
		root.right = new SimpleNode(3);
		root.left.left = new SimpleNode(4);
		root.left.right = new SimpleNode(5);
		root.right.left = new SimpleNode(6);
		root.right.right = new SimpleNode(7);
		return root;
	}

	public static SameLevelNode getSameLevelTree() {
		SameLevelNode root = new SameLevelNode(1);
		root.left = new SameLevelNode(2);
		root.right = new SameLevelNode(3);
		root.left.left = new SameLevelNode(4);
		root.left.right = new SameLevelNode(5);
		root.right.right = new SameLevelNode(6);
		return root;
	}

	public static SuccessorNode getSuccessorNodeTree() {
		SuccessorNode root = new SuccessorNode(1);
		root.left = new SuccessorNode(2);
		root.right = new SuccessorNode(3);
		root.left.left = new SuccessorNode(4);
		root.left.right = new SuccessorNode(5);
		root.right.right = new SuccessorNode(6);
		return root;
	}

	public static LargestIndependentSetNode getLargestIndependentSubsetNode() {
		LargestIndependentSetNode root = new LargestIndependentSetNode(1);
		root.left = new LargestIndependentSetNode(2);
		root.right = new LargestIndependentSetNode(3);
		root.left.left = new LargestIndependentSetNode(4);
		root.left.right = new LargestIndependentSetNode(5);
		root.right.right = new LargestIndependentSetNode(6);
		return root;
	}

	public static SimpleNode getSkewedTree() {
		SimpleNode root = new SimpleNode(1);
		root.right = new SimpleNode(2);
		root.right.right = new SimpleNode(3);
		root.right.right.right = new SimpleNode(4);
		root.right.right.left = new SimpleNode(5);
		return root;
	}

	public static int getHeight(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	}
}
