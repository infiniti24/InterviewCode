package com.shoumo.geek.tree;

import java.util.Objects;
import java.util.Stack;

public class SpiralTreeIterative {

	public void printSpiral(SimpleNode node) {
		if (Objects.isNull(node))
			return;

		// for left print
		Stack<SimpleNode> stack1 = new Stack<SimpleNode>();
		// for right print
		Stack<SimpleNode> stack2 = new Stack<SimpleNode>();

		stack1.push(node);

		while (!stack1.empty() || !stack2.empty()) {
			while (!stack1.empty()) {
				SimpleNode data = stack1.pop();
				System.out.print(data.data + " ");
				if (Objects.nonNull(data.left))
					stack2.push(data.left);
				if (Objects.nonNull(data.right))
					stack2.push(data.right);
			}

			System.out.println();

			while (!stack2.empty()) {
				SimpleNode data = stack2.pop();
				System.out.print(data.data + " ");
				if (Objects.nonNull(data.left))
					stack1.push(data.left);
				if (Objects.nonNull(data.right))
					stack1.push(data.right);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new SpiralTreeIterative().printSpiral(BinaryTree.getTree());
	}
}
