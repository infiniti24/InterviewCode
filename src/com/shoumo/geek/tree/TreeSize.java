package com.shoumo.geek.tree;

import java.util.Objects;

public class TreeSize {

	public int size(SimpleNode node) {
		if (Objects.isNull(node))
			return 0;
		else
			return size(node.left) + 1 + size(node.right);
	}
	
	public static void main(String[] args) {
		System.out.println(new TreeSize().size(BinaryTree.getTree()));
	}
}
