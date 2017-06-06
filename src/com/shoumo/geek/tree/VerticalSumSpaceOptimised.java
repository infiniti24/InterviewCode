package com.shoumo.geek.tree;

import java.util.Objects;

public class VerticalSumSpaceOptimised {

	public void verticalSum(SimpleNode node, DLLNode dllNode) {
		if (Objects.isNull(node))
			return;

		dllNode.data = dllNode.data + node.data;

		if (Objects.nonNull(node.left)) {
			if (Objects.isNull(dllNode.prev)) {
				dllNode.prev = new DLLNode(0);
				dllNode.prev.next = dllNode;
			}
			verticalSum(node.left, dllNode.prev);
		}

		if (Objects.nonNull(node.right)) {
			if (Objects.isNull(dllNode.next)) {
				dllNode.next = new DLLNode(0);
				dllNode.next.prev = dllNode;
			}
			verticalSum(node.right, dllNode.next);
		}
	}

	public static void main(String[] args) {
		DLLNode dllNode = new DLLNode(0);
		new VerticalSumSpaceOptimised().verticalSum(BinaryTree.getTree(),
				dllNode);
		while (dllNode.prev != null)
			dllNode = dllNode.prev;
		while (dllNode != null) {
			System.out.print(dllNode + " ");
			dllNode = dllNode.next;
		}
	}

	public static class DLLNode {
		int data;
		DLLNode prev = null, next = null;

		DLLNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(data);
		}
	}
}
