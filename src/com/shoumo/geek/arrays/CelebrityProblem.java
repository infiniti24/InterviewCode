package com.shoumo.geek.arrays;

public class CelebrityProblem {

	public int[][] acquaintanceMatrix = new int[][] { { 0, 0, 1, 0 },
			{ 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	public boolean knows(int a, int b) {
		return acquaintanceMatrix[a][b] > 0;
	}

	public void findCelebrity(int n) {
		int a = 0;
		int b = n - 1;

		while (a < b) {
			if (knows(a, b)) {
				a++;
			} else {
				b--;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i != a && (knows(a, i) || !knows(i, a))) {
				System.out.println("No celebrity");
				return;
			}
		}

		System.out.println("Celebrity is:" + a);
	}

	public static void main(String[] args) {
		new CelebrityProblem().findCelebrity(4);
	}
}
