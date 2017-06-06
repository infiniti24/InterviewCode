package com.shoumo.geek.tree;

import java.util.Objects;
import java.util.Stack;

public class InorderTraversalStack {

	SimpleNode root;
	Stack<SimpleNode> stack;
	
	public InorderTraversalStack(SimpleNode root) {
		this.root = root;
		stack = new Stack<>();
	}
	
	public void traverseInorder() {
		if(root == null) {
			return;
		}
		
		pushRootAndLeft(root);
		while(stack.size()>0) {
			SimpleNode node = stack.pop();
			System.out.print(node.data+" ");
			if(node.right!=null) {
				node = node.right;
				pushRootAndLeft(node);
			}
		}
	}
	
	public void pushRootAndLeft(SimpleNode node) {
		while(Objects.nonNull(node)) {
			stack.add(node);
			node = node.left;
		}
	}

	public static void main(String[] args) {
		InorderTraversalStack inorderTraversalStack = new InorderTraversalStack(BinaryTree.getTree());
		inorderTraversalStack.traverseInorder();
	}
}
