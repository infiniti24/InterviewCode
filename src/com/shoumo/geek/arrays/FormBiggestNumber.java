package com.shoumo.geek.arrays;

public class FormBiggestNumber {

	public void findBiggestNumber(MyNumber[] dataArray) {
		sort(dataArray, 0, dataArray.length - 1);
		String newNumber = "";
		for (int i = dataArray.length - 1; i >= 0; i--) {
			newNumber += dataArray[i].data;
		}

		System.out.println("Biggest Number is:" + newNumber);
	}

	public int partition(MyNumber[] dataArray, int low, int high) {
		MyNumber pivot = dataArray[high];
		int index = low - 1;
		for (int i = 0; i < high; i++) {
			if (dataArray[i].compareTo(pivot) < 0) {
				index++;

				MyNumber temp = dataArray[index];
				dataArray[index] = dataArray[i];
				dataArray[i] = temp;
			}
		}

		MyNumber temp = dataArray[index + 1];
		dataArray[index + 1] = dataArray[high];
		dataArray[high] = temp;

		return index + 1;
	}

	public void sort(MyNumber[] dataArray, int low, int high) {
		if (low < high) {
			int partition = partition(dataArray, low, high);

			sort(dataArray, low, partition - 1);
			sort(dataArray, partition + 1, high);
		}
	}

	public static class MyNumber implements Comparable<MyNumber> {
		int data;

		public MyNumber(int data) {
			this.data = data;
		}

		@Override
		public int compareTo(MyNumber o) {
			int firstNumber = Integer.valueOf(this.data + "" + o.data);
			int secondNumber = Integer.valueOf(o.data + "" + this.data);

			return firstNumber - secondNumber;
		}
	}

	public static void main(String[] args) {
		new FormBiggestNumber().findBiggestNumber(new MyNumber[] {
				new MyNumber(54), new MyNumber(546), new MyNumber(548),
				new MyNumber(60) });
	}
}
