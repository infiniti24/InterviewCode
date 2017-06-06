package com.shoumo.geek.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumInSlidingWindow {

	public void findMaxInSlidingWindow(int[] data, int windowSize) {
		Deque<Integer> dequeue = new ArrayDeque<Integer>();

		int i = 0;
		for (i = 0; i < windowSize; i++) {
			while (!dequeue.isEmpty() && data[i] >= data[dequeue.peekLast()])
				dequeue.pollLast();

			dequeue.addLast(i);
		}

		for (; i < data.length; i++) {
			System.out.print(data[dequeue.peekFirst()] + " ");

			while (!dequeue.isEmpty() && dequeue.peekFirst() <= i - windowSize)
				dequeue.pollFirst();

			while (!dequeue.isEmpty() && data[i] >= data[dequeue.peekLast()])
				dequeue.pollLast();

			dequeue.addLast(i);
		}

		System.out.println(data[dequeue.peekFirst()]);
	}

	public static void main(String[] args) {
		new MaximumInSlidingWindow().findMaxInSlidingWindow(new int[] { 12, 1,
				78, 90, 57, 89, 56 }, 3);
	}
}
