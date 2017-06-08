package com.shoumo.geek.arrays;

public class NumberOfIslands {

	public static final int MAX_ROW = 5, MAX_COL = 5;

	public boolean isSafeMove(int[][] dataArray, int row, int column,
			boolean[][] visited) {
		return (row >= 0 && row < MAX_ROW) && (column >= 0 && column < MAX_COL)
				&& (dataArray[row][column] == 1 && !visited[row][column]);
	}

	public void DFSTraverse(int[][] dataArray, int row, int column,
			boolean[][] visited) {

		int[] rowNumber = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] columnNumber = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[row][column] = true;

		for (int k = 0; k < 8; k++) {
			if (isSafeMove(dataArray, row + rowNumber[k], column
					+ columnNumber[k], visited)) {
				DFSTraverse(dataArray, row + rowNumber[k], column
						+ columnNumber[k], visited);
			}
		}
	}

	public void countIslands(int[][] dataArray) {
		boolean[][] visited = new boolean[MAX_ROW][MAX_COL];

		int count = 0;
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COL; j++) {
				if (dataArray[i][j] == 1 && !visited[i][j]) {
					DFSTraverse(dataArray, i, i, visited);
					count++;
				}
			}
		}

		System.out.println("Maximum number of islands are:" + count);
	}

	public static void main(String[] args) {
		new NumberOfIslands().countIslands(new int[][] { { 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } });
	}
}
