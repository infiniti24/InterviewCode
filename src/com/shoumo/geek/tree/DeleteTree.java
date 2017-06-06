package com.shoumo.geek.tree;

import java.util.Objects;

/**
 * Post order traversal to delete a node as no extra space will be required
 * 
 * @author shoumo
 *
 */
public class DeleteTree {

	public void deleteTree(SimpleNode node) {
		if (Objects.isNull(node))
			return;
		deleteTree(node.left);
		deleteTree(node.right);
		System.out.println("Node to be deleted is:" + node.data);
		node = null;
	}

	public static void main(String[] args) {
		new DeleteTree().deleteTree(BinaryTree.getTree());
	}
}
