package com.shoumo.geek.tree;

import java.util.Objects;

public class KDistanceFromLeaf {

	public void printKDistanceFromLeaf(SimpleNode node, int distance,
			int pathLen, KDistanceFromLeaf.LevelNode[] levelNodeList) {
		if (Objects.isNull(node))
			return;

		levelNodeList[pathLen] = new LevelNode(node.data, false);
		pathLen++;

		if (Objects.isNull(node.left) && Objects.isNull(node.right)
				&& pathLen - distance - 1 >= 0
				&& !levelNodeList[pathLen - distance - 1].isVisited) {
			System.out.println("Node is:"
					+ levelNodeList[pathLen - distance - 1].data);
			levelNodeList[pathLen - distance - 1].isVisited = true;
			return;
		}

		printKDistanceFromLeaf(node.left, distance, pathLen, levelNodeList);
		printKDistanceFromLeaf(node.right, distance, pathLen, levelNodeList);
	}

	public static void main(String[] args) {
		new KDistanceFromLeaf().printKDistanceFromLeaf(BinaryTree.getTree(), 0,
				0, new KDistanceFromLeaf.LevelNode[1000]);
	}

	public static class LevelNode {
		int data;
		boolean isVisited;

		public LevelNode(int data, boolean isVisited) {
			this.data = data;
			this.isVisited = isVisited;
		}
	}
}
