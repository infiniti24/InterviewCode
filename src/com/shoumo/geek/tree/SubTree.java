package com.shoumo.geek.tree;

import java.util.Objects;

public class SubTree {

	public boolean isIdentical(SimpleNode largerTree, SimpleNode smallerTree) {
		if (Objects.isNull(largerTree) && Objects.isNull(smallerTree))
			return true;

		if (Objects.isNull(largerTree) || Objects.isNull(smallerTree))
			return false;

		return largerTree.data == smallerTree.data
				&& isIdentical(largerTree.left, smallerTree.left)
				&& isIdentical(largerTree.right, smallerTree.right);
	}

	public boolean isSubTree(SimpleNode largerTree, SimpleNode smallerTree) {
		if (Objects.isNull(smallerTree))
			return true;

		if (Objects.isNull(largerTree))
			return false;

		if (isIdentical(largerTree, smallerTree))
			return true;

		return isSubTree(largerTree.left, smallerTree)
				|| isSubTree(largerTree.right, smallerTree);
	}

	public static void main(String[] args) {
		System.out.println("Is subtree:"
				+ (new SubTree().isSubTree(BinaryTree.getTree(),
						BinaryTree.getTree())));
	}
}
