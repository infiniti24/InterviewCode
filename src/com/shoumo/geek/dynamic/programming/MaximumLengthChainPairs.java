package com.shoumo.geek.dynamic.programming;

public class MaximumLengthChainPairs {

	public int getLengthOfMaxChain(Pair[] chainArray) {

		int max = Integer.MIN_VALUE;
		int[] maxChainLength = new int[chainArray.length];

		for (int i = 0; i < chainArray.length; i++) {
			maxChainLength[i] = 1;
		}

		for (int i = 1; i < chainArray.length; i++) {
			for (int j = 0; j < i; j++) {
				if (chainArray[i].first > chainArray[j].second
						&& maxChainLength[i] < maxChainLength[j] + 1) {
					maxChainLength[i] = maxChainLength[j] + 1;
				}
			}
		}

		for (int i = 0; i < maxChainLength.length; i++) {
			if (maxChainLength[i] > max) {
				max = maxChainLength[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25),
				new Pair(27, 40), new Pair(50, 60) };
		System.out.println("Length of maximum size chain is "
				+ new MaximumLengthChainPairs().getLengthOfMaxChain(arr));
	}

	public static class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
