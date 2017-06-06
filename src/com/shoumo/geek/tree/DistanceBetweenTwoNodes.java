package com.shoumo.geek.tree;

import java.util.Objects;

/**
 * 
 * @author shoumo
 *         <p>
 *         Distance between two nodes = dist(root, node1) + dist(root, node2) -
 *         2*dist(root, lca) <br>
 *         where lca = lowest common ancestor
 *         </p>
 *
 */
public class DistanceBetweenTwoNodes {

	public int getLevel(SimpleNode node, int data, int level) {
		if (Objects.isNull(node))
			return -1;

		if (node.data == data)
			return level;

		return Math.max(getLevel(node.left, data, level + 1),
				getLevel(node.right, data, level + 1));
	}

	public SimpleNode findDistance(SimpleNode node, int nodeOneData,
			int nodeTwoData, LevelOrderValues levelOrderValues, int level) {
		if (Objects.isNull(node))
			return null;

		if (node.data == nodeOneData) {
			levelOrderValues.nodeOneDistance = level;
			return node;
		}
		if (node.data == nodeTwoData) {
			levelOrderValues.nodeTwoDistance = level;
			return node;
		}

		SimpleNode leftLCA = findDistance(node.left, nodeOneData, nodeTwoData,
				levelOrderValues, level + 1);
		SimpleNode rightLCA = findDistance(node.right, nodeOneData,
				nodeTwoData, levelOrderValues, level + 1);

		if (Objects.nonNull(leftLCA) && Objects.nonNull(rightLCA)) {
			levelOrderValues.totalDistance = levelOrderValues.nodeOneDistance
					+ levelOrderValues.nodeTwoDistance - 2 * level;
			return node;
		}
		return Objects.nonNull(leftLCA) ? leftLCA : rightLCA;
	}

	public int findDistance(SimpleNode node, int nodeOneData, int nodeTwoData) {
		LevelOrderValues levelOrderValues = new LevelOrderValues();

		SimpleNode lca = findDistance(node, nodeOneData, nodeTwoData,
				levelOrderValues, 1);

		if (levelOrderValues.totalDistance > 0)
			return levelOrderValues.totalDistance;

		if (levelOrderValues.nodeOneDistance > 0)
			return getLevel(lca, nodeTwoData, 0);

		return getLevel(lca, nodeOneData, 0);
	}

	public static void main(String[] args) {
		System.out.println("Distance between two nodes is:"
				+ new DistanceBetweenTwoNodes().findDistance(
						BinaryTree.getTree(), 6, 7));
	}

	public static class LevelOrderValues {
		int nodeOneDistance, nodeTwoDistance, totalDistance;
	}
}
