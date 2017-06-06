package com.shoumo.geek.arrays;

import java.util.Scanner;

import com.shoumo.geek.heap.Heap;
import com.shoumo.geek.heap.MaxHeap;
import com.shoumo.geek.heap.MinHeap;

public class MedianInStream {

	public int getSign(int a, int b) {
		if (a == b)
			return 0;

		return a < b ? -1 : 1;
	}

	public int getAverage(int a, int b) {
		return (a + b) / 2;
	}

	/**
	 * The left will be max heap and the right will be min heap
	 * 
	 * @param data
	 * @param leftHeap
	 * @param rightHeap
	 * @return
	 */
	public int getMedian(int data, int median, Heap leftHeap, Heap rightHeap) {
		switch (getSign(leftHeap.getCount(), rightHeap.getCount())) {
		case 1:
			if (data < median) {
				rightHeap.insert(leftHeap.extractTop());

				leftHeap.insert(data);
			} else {
				rightHeap.insert(data);
			}
			median = getAverage(leftHeap.getTop(), rightHeap.getTop());
			break;
		case 0:
			if (data < median) {
				leftHeap.insert(data);
				median = leftHeap.getTop();
			} else {
				rightHeap.insert(data);
				median = rightHeap.getTop();
			}
			break;
		case -1:
			if (data < median) {
				leftHeap.insert(data);
			} else {
				leftHeap.insert(rightHeap.extractTop());

				rightHeap.insert(data);
			}

			median = getAverage(leftHeap.getTop(), rightHeap.getTop());
		}

		return median;
	}

	public void findMedian() {

		int median = 0;
		Heap leftHeap = new MaxHeap();
		Heap rightHeap = new MinHeap();

		System.out
				.println("Please enter stream of number, please enter exit to exit the system");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String inputData = scanner.nextLine();
			if ("exit".equals(inputData)) {
				break;
			} else {
				median = getMedian(Integer.parseInt(inputData), median,
						leftHeap, rightHeap);
				System.out.println("Median is: " + median);
			}
		}

		scanner.close();

	}

	public static void main(String[] args) {
		new MedianInStream().findMedian();
	}
}
