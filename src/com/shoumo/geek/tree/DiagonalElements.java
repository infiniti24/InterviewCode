package com.shoumo.geek.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DiagonalElements {

	
	public void populateDiagonalMap(SimpleNode node, Map<Integer,List<Integer>> diagonalMap,int diagonalDistance) {
		if(Objects.isNull(node)) {
			return;
		}
		if(Objects.isNull(diagonalMap.get(diagonalDistance))) {
			diagonalMap.put(diagonalDistance, new ArrayList<Integer>());
		}
		diagonalMap.get(diagonalDistance).add(node.data);
		populateDiagonalMap(node.left, diagonalMap, diagonalDistance+1);
		populateDiagonalMap(node.right, diagonalMap, diagonalDistance);
	}
	
	public void printDiagonalElements(SimpleNode root) {
		Map<Integer,List<Integer>> diagonalMap = new HashMap<>();
		populateDiagonalMap(root, diagonalMap, 0);
		for(Map.Entry<Integer, List<Integer>> entry:diagonalMap.entrySet()) {
			entry.getValue().forEach(data -> System.out.print(data+" "));
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new DiagonalElements().printDiagonalElements(BinaryTree.getTree());
	}
}
