package com.shoumo.geek.tree;

import java.util.Objects;

public class InorderSuccessor {

	public void populateNext(SuccessorNode node, SuccessorNode nextNode) {
		if (Objects.nonNull(node)) {
			populateNext(node.right, nextNode);

			node.next = nextNode;

			nextNode = node;

			populateNext(node.left, nextNode);
		}
	}

	public void inorderTraversal(SuccessorNode node) {
		if (Objects.isNull(node))
			return;

		inorderTraversal(node.left);
		System.out.println("Node value:" + node + " successor node:"
				+ node.next);
		inorderTraversal(node.right);
	}

	public static void main(String[] args) {
		InorderSuccessor is = new InorderSuccessor();
		SuccessorNode sn = BinaryTree.getSuccessorNodeTree();
		is.populateNext(sn, null);
		is.inorderTraversal(sn);
	}
}
