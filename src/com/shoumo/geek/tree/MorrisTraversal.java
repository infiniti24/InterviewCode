package com.shoumo.geek.tree;

import java.util.Objects;

public class MorrisTraversal {

	SimpleNode root;

	public MorrisTraversal(SimpleNode node) {
		this.root = node;
	}

	public void doMorrisTraversal() {
		SimpleNode current, pre;
		if (Objects.isNull(this.root)) {
			return;
		}
		current = root;
		while (Objects.nonNull(current)) {
			/**
			 * The element is at leftmost node, print the node and move to the
			 * inorder successor, which has already been assigned.
			 */
			if (Objects.isNull(current.left)) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/**
				 * Find the inorder predecessor of the current
				 */
				pre = current.left;
				/**
				 * Move to the right till the rightmost child is found
				 */
				while (Objects.nonNull(pre.right) && pre.right != current)
					pre = pre.right;
				/**
				 * Assign the rightmost node to the inorder successor
				 */
				if (Objects.isNull(pre.right)) {
					pre.right = current;
					current = current.left;
				} else {
					/**
					 * Remove the inrorder successor nodes to restore the tree
					 */
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MorrisTraversal(BinaryTree.getTree()).doMorrisTraversal();
	}
}
