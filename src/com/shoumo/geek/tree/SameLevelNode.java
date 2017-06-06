package com.shoumo.geek.tree;

public class SameLevelNode {

	int data;
	SameLevelNode left, right, nextRight;

	public SameLevelNode(int data) {
		this.data = data;
		left = right = nextRight = null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(data);
	}
}
