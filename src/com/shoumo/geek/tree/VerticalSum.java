package com.shoumo.geek.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VerticalSum {

	Map<Integer, Integer> horizontalDistanceMap = new HashMap<Integer, Integer>();

	public void addVerticalSum(SimpleNode node, int horizontalDistance) {

		if (Objects.isNull(node)) {
			return;
		}

		addVerticalSum(node.left, horizontalDistance - 1);
		int prevSum = (Objects.nonNull(horizontalDistanceMap
				.get(horizontalDistance))) ? horizontalDistanceMap
				.get(horizontalDistance) : 0;
		horizontalDistanceMap.put(horizontalDistance, prevSum + node.data);
		addVerticalSum(node.right, horizontalDistance + 1);
	}

	public static void main(String[] args) {
		VerticalSum vs = new VerticalSum();
		vs.addVerticalSum(BinaryTree.getTree(), 0);
		System.out.println(vs.horizontalDistanceMap.entrySet());
	}
}
