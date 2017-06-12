package com.shoumo.geek.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RootToLeaf {

	public void addRouteToLeaf(SimpleNode node, List<Integer> queue, int index) {
		if (Objects.isNull(node)) {
			return;
		}
		queue.add(index++, node.data);
		if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
			printData(queue, index);
		} else {
			addRouteToLeaf(node.left, queue, index);
			addRouteToLeaf(node.right, queue, index);
		}
	}

	private void printData(List<Integer> queue, int index) {

		for (int i = 0; i < index; i++) {
			System.out.print(queue.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new RootToLeaf().addRouteToLeaf(BinaryTree.getTree(),
				new LinkedList<Integer>(), 0);

	}
}
