package com.shoumo.geek.arrays;

import java.util.Stack;

public class NextGreaterElement {

	public void finNGE(int[] data) {
		int next = -1, element = -1;
		Stack<Integer> dataStack = new Stack<Integer>();

		dataStack.push(data[0]);

		for (int i = 1; i < data.length; i++) {
			next = data[i];

			if (!dataStack.isEmpty()) {
				element = dataStack.pop();

				while (element < next) {
					System.out.println(element + "-->" + next);
					if (dataStack.isEmpty())
						break;
					element = dataStack.pop();
				}

				if (element > next) {
					dataStack.push(element);
				}
			}

			dataStack.push(next);
		}

		while (!dataStack.isEmpty()) {
			System.out.println(dataStack.pop() + "-->-1");
		}
	}

	public static void main(String[] args) {
		new NextGreaterElement().finNGE(new int[] { 11, 13, 21, 3 });
	}
}
