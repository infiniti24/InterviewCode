package com.shoumo.geek.tree;

public class SimpleNode {

	int data;
	SimpleNode left, right;

	public SimpleNode(int data) {
		this.data = data;
		left = right = null;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}
}
