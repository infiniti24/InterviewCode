package com.shoumo.geek.tree;

public class SuccessorNode {

	int data;
	SuccessorNode left, right, next;

	public SuccessorNode(int data) {
		this.data = data;
		left = right = next = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.data);
	}
}
