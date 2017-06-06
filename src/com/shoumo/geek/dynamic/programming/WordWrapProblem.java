package com.shoumo.geek.dynamic.programming;

public class WordWrapProblem {

	public void solveWordWrap(int[] wordLenghtArray, int lineLength) {
		int wordArrayLength = wordLenghtArray.length;
		int[][] extraSpaces = new int[wordArrayLength + 1][wordArrayLength + 1];

		int[][] lineCount = new int[wordArrayLength + 1][wordArrayLength + 1];

		int[] optimalCostArray = new int[wordArrayLength + 1];

		int[] printArray = new int[wordArrayLength + 1];

		for (int i = 1; i <= wordArrayLength; i++) {
			extraSpaces[i][i] = lineLength - wordLenghtArray[i - 1];
			for (int j = i + 1; j <= wordArrayLength; j++) {
				extraSpaces[i][j] = extraSpaces[i][j - 1]
						- wordLenghtArray[j - 1] - 1;
			}
		}

		for (int i = 1; i <= wordArrayLength; i++) {
			for (int j = i; j <= wordArrayLength; j++) {
				if (extraSpaces[i][j] < 0) {
					lineCount[i][j] = Integer.MAX_VALUE;
				} else if (j == wordArrayLength && extraSpaces[i][j] >= 0) {
					lineCount[i][j] = 0;
				} else {
					lineCount[i][j] = (int) Math.pow(extraSpaces[i][j], 2);
				}
			}
		}

		optimalCostArray[0] = 0;

		for (int i = 1; i <= wordArrayLength; i++) {
			optimalCostArray[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (optimalCostArray[j - 1] != Integer.MAX_VALUE
						&& lineCount[j][i] != Integer.MAX_VALUE
						&& (optimalCostArray[j - 1] + lineCount[j][i] < optimalCostArray[i])) {
					optimalCostArray[i] = optimalCostArray[j - 1]
							+ lineCount[j][i];
					printArray[i] = j;
				}
			}
		}
		printSolution(printArray, wordArrayLength);
	}

	public int printSolution(int p[], int n) {
		int k;
		if (p[n] == 1)
			k = 1;
		else
			k = printSolution(p, p[n] - 1) + 1;

		System.out.println("Line number" + " " + k + ": " + "From word no."
				+ " " + p[n] + " " + "to" + " " + n);
		return k;
	}

	public static void main(String[] args) {
		WordWrapProblem w = new WordWrapProblem();
		int l[] = { 3, 2, 2, 5 };
		int M = 6;
		w.solveWordWrap(l, M);
	}

}
