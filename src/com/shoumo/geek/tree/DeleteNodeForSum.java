package com.shoumo.geek.tree;

import java.util.Objects;

public class DeleteNodeForSum {

	public SimpleNode deleteNode(SimpleNode node, int sum) {
		if (Objects.isNull(node)) {
			return node;
		}

		node.left = deleteNode(node.left, sum - node.data);
		node.right = deleteNode(node.right, sum - node.data);

		if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
			if (node.data < sum) {
				node = null;
				return null;
			}
		}
		return node;
	}

	public void printInoder(SimpleNode node) {
		if (Objects.isNull(node))
			return;
		printInoder(node.left);
		System.out.print(node.data + " ");
		printInoder(node.right);
	}

	public static void main(String[] args) {
		DeleteNodeForSum dnfs = new DeleteNodeForSum();
		SimpleNode root = BinaryTree.getTree();
		dnfs.printInoder(root);
		root = dnfs.deleteNode(root, 8);
		System.out.println();
		dnfs.printInoder(root);
	}
}
