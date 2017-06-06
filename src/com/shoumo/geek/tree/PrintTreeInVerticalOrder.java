package com.shoumo.geek.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PrintTreeInVerticalOrder {

	Map<Integer, List<Integer>> horizontalDistanceMap = new HashMap<>();

	public void addVerticalNodesToMap(SimpleNode node, int horizontalDistance) {
		if (Objects.isNull(node))
			return;

		if (Objects.isNull(horizontalDistanceMap.get(horizontalDistance)))
			horizontalDistanceMap.put(horizontalDistance,
					new ArrayList<Integer>());

		horizontalDistanceMap.get(horizontalDistance).add(node.data);

		addVerticalNodesToMap(node.left, horizontalDistance - 1);
		addVerticalNodesToMap(node.right, horizontalDistance + 1);
	}

	public static void main(String[] args) {
		PrintTreeInVerticalOrder ptinvo = new PrintTreeInVerticalOrder();
		ptinvo.addVerticalNodesToMap(BinaryTree.getTree(), 0);
		System.out.println("Vertical order is:"
				+ ptinvo.horizontalDistanceMap.entrySet());
	}
}
