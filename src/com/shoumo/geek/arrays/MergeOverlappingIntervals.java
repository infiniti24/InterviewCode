package com.shoumo.geek.arrays;

public class MergeOverlappingIntervals {

	public void mergeIntervals(Interval[] dataArray) {
		sort(dataArray, 0, dataArray.length - 1);

		int index = 0;

		for (int i = 0; i < dataArray.length; i++) {
			while (index != 0 && dataArray[index - 1].start < dataArray[i].end) {
				dataArray[index - 1].end = Math.max(dataArray[index].end,
						dataArray[i].end);
				dataArray[index - 1].start = Math.min(
						dataArray[index - 1].start, dataArray[i].start);
				index--;
			}

			dataArray[index] = dataArray[i];
			index++;
		}
		System.out.println("Merged intervals are:");
		for (int i = 0; i < index; i++) {
			System.out.print(dataArray[i] + " ");
		}
	}

	public int partition(Interval[] dataArray, int low, int high) {
		Interval pivot = dataArray[high];

		int index = low - 1;

		for (int i = low; i < high; i++) {
			if (dataArray[i].compareTo(pivot) < 0) {
				index++;

				Interval temp = dataArray[index];
				dataArray[index] = dataArray[i];
				dataArray[i] = temp;
			}
		}

		Interval temp = dataArray[index + 1];
		dataArray[index + 1] = dataArray[high];
		dataArray[high] = temp;

		return index + 1;
	}

	public void sort(Interval[] dataArray, int low, int high) {
		if (low < high) {
			int partition = partition(dataArray, low, high);

			sort(dataArray, low, partition - 1);
			sort(dataArray, partition + 1, high);
		}
	}

	public static class Interval implements Comparable<Interval> {

		int start, end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval o) {
			return o.start - this.start;
		}

		@Override
		public String toString() {
			return "(" + this.start + "," + this.end + ")";
		}
	}

	public static void main(String[] args) {
		new MergeOverlappingIntervals().mergeIntervals(new Interval[] {
				new Interval(6, 8), new Interval(1, 9), new Interval(2, 4),
				new Interval(4, 7) });
	}
}
