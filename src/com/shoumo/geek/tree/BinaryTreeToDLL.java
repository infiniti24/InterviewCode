package com.shoumo.geek.tree;

import java.util.Objects;

public class BinaryTreeToDLL {

	public SimpleNode convertToDLL(SimpleNode node) {
		if (Objects.isNull(node))
			return null;

		if (Objects.nonNull(node.left)) {
			SimpleNode left = convertToDLL(node.left);

			for (; left.right != null; left = left.right) {
			}

			left.right = node;

			node.left = left;
		}

		if (Objects.nonNull(node.right)) {
			SimpleNode right = convertToDLL(node.right);

			for (; right.left != null; right = right.left) {
			}

			right.left = node;
			node.right = right;
		}

		return node;
	}

	public static void main(String[] args) {
		BinaryTreeToDLL btdll = new BinaryTreeToDLL();
		SimpleNode node = btdll.convertToDLL(BinaryTree.getTree());
		while (node.left != null) {
			node = node.left;
		}

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}
