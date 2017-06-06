package com.shoumo.geek.heap;

public class MinHeap extends Heap {

	public MinHeap() {
		super(new MinHeapComparator());
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
