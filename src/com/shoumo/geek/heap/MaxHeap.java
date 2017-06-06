package com.shoumo.geek.heap;

public class MaxHeap extends Heap {

	public MaxHeap() {
		super(new MaxHeapComparator());
	}

	@Override
	public boolean insert(int data) {
		return insertHelper(data);
	}

	@Override
	public int getTop() {
		return top();
	}

	@Override
	public int extractTop() {
		return deleteTop();
	}

	@Override
	public int getCount() {
		return count();
	}

}
