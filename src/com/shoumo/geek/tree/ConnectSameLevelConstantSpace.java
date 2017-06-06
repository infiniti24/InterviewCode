package com.shoumo.geek.tree;

import java.util.Objects;

public class ConnectSameLevelConstantSpace {

	public SameLevelNode getNextRight(SameLevelNode node) {

		SameLevelNode temp = node.nextRight;

		while (Objects.nonNull(temp)) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.nextRight;
		}
		return null;
	}

	public void connectNodeRecursively(SameLevelNode node) {
		if (Objects.isNull(node))
			return;

		if (node.nextRight != null)
			connectNodeRecursively(node.nextRight);

		if (Objects.nonNull(node.left)) {
			if (node.right != null) {
				node.left.nextRight = node.right;
				node.right.nextRight = getNextRight(node);
			} else {
				node.left.nextRight = getNextRight(node);
			}
			connectNodeRecursively(node.left);
		} else if (node.right != null) {
			node.right = getNextRight(node);
			connectNodeRecursively(node.right);
		} else {
			connectNodeRecursively(getNextRight(node));
		}
	}

	public void printInorder(SameLevelNode node) {
		if (Objects.isNull(node))
			return;

		printInorder(node.left);
		System.out.println("Node:" + node + " rightNode:" + node.nextRight);
		printInorder(node.right);
	}

	public static void main(String[] args) {
		ConnectSameLevelConstantSpace connect = new ConnectSameLevelConstantSpace();
		SameLevelNode node = BinaryTree.getSameLevelTree();
		connect.connectNodeRecursively(node);
		connect.printInorder(node);
	}
}
