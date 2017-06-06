package com.shoumo.geek.dynamic.programming;

public class KeypadCountingProblem {

	public int getCount(char[][] keypad, int maxDisplacement) {

		if (keypad == null || maxDisplacement <= 0) {
			return 0;
		} else if (maxDisplacement == 1) {
			return 10;
		}

		int row[] = { 0, 0, -1, 0, 1 };
		int column[] = { 0, -1, 0, 1, 0 };

		int count[][] = new int[10][maxDisplacement + 1];

		for (int i = 0; i <= 9; i++) {
			count[i][0] = 0;
			count[i][1] = 1;
		}

		int num = 0, nextNum = 0, total = 0;

		for (int k = 2; k <= maxDisplacement; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (keypad[i][j] != '*' && keypad[i][j] != '#') {
						num = keypad[i][j] - '0';
						count[num][k] = 0;

						for (int move = 0; move < 5; move++) {
							int ro = i + row[move];
							int co = j + column[move];

							if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2
									&& keypad[ro][co] != '*'
									&& keypad[ro][co] != '#') {
								nextNum = keypad[ro][co] - '0';
								count[num][k] += count[nextNum][k - 1];
							}
						}
					}
				}
			}
		}

		for (int i = 0; i <= 9; i++)
			total += count[i][maxDisplacement];

		return total;
	}

	public static void main(String[] args) {
		char keypad[][] = new char[][] { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', '9' }, { '*', '0', '#' } };
		System.out.println("Count for numbers of length:"
				+ new KeypadCountingProblem().getCount(keypad, 1));
		System.out.println("Count for numbers of length:"
				+ new KeypadCountingProblem().getCount(keypad, 2));
		System.out.println("Count for numbers of length:"
				+ new KeypadCountingProblem().getCount(keypad, 3));
		System.out.println("Count for numbers of length:"
				+ new KeypadCountingProblem().getCount(keypad, 4));
		System.out.println("Count for numbers of length:"
				+ new KeypadCountingProblem().getCount(keypad, 5));
	}
}
