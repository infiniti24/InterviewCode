package com.shoumo.geek.heap;

public abstract class Heap {

	private int[] dataArray;
	private int heapSize = -1;
	private HeapComparator comparator;
	private static final int MAX_HEAP_SIZE = 128;

	public Heap(HeapComparator comparator) {
		dataArray = new int[MAX_HEAP_SIZE];
		this.comparator = comparator;
	}

	public abstract boolean insert(int data);

	public abstract int getTop();

	public abstract int extractTop();

	public abstract int getCount();

	protected int getLeft(int i) {
		return 2 * i + 1;
	}

	protected int getRight(int i) {
		return 2 * (i + 1);
	}

	protected int getParent(int i) {
		if (i < 0) {
			return -1;
		}

		return (i - 1) / 2;
	}

	protected int top() {
		int max = -1;

		if (heapSize >= 0) {
			max = dataArray[0];
		}

		return max;
	}

	protected int count() {
		return heapSize + 1;
	}

	protected void exchange(int indexOne, int indexTwo) {
		int temp = dataArray[indexOne];
		dataArray[indexOne] = dataArray[indexTwo];
		dataArray[indexTwo] = temp;
	}

	public void heapify(int index) {
		int p = getParent(index);

		if (p > 0 && comparator.compare(dataArray[index], dataArray[p])) {
			exchange(index, p);
			heapify(p);
		}
	}

	public int deleteTop() {
		int delete = -1;

		if (heapSize > -1) {
			delete = dataArray[0];

			exchange(0, heapSize);
			heapSize--;
			heapify(getParent(heapSize + 1));
		}

		return delete;
	}

	protected boolean insertHelper(int data) {
		boolean isAdded = false;

		if (heapSize < MAX_HEAP_SIZE) {
			isAdded = true;
			heapSize++;
			dataArray[heapSize] = data;
			heapify(heapSize);
		}

		return isAdded;
	}

}
