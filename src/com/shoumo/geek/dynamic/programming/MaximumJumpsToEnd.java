package com.shoumo.geek.dynamic.programming;

public class MaximumJumpsToEnd {

	public int findMinJumps(int[] jumpArray) {

		int[] jumps = new int[jumpArray.length];

		if (jumpArray.length == 0 || jumpArray[0] == 0)
			return Integer.MAX_VALUE;

		jumps[0] = 0;

		for (int i = 1; i < jumpArray.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + jumpArray[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[jumpArray.length - 1];
	}

	public static void main(String[] args) {
		System.out.println("Minimum number of jumps to reach end is"
				+ new MaximumJumpsToEnd().findMinJumps(new int[] { 1, 3, 6, 1,
						0, 9 }));
	}
}
