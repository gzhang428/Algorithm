package algorithm;

import algorithm.sort.QuickSort;

public class Selection extends QuickSort {

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		Selection selection = new Selection();
		int n = selection.select(a, 7);
		System.out.println(n);
	}

	private int select(int[] a, int i) {
		return randomSelect(a, 0, a.length, i);
	}

	private int randomSelect(int[] a, int low, int high, int i) {
		if (low < high - 1){
			int mid = partition(a, low, high);
			if (i == mid) {
				return a[mid];
			} else if (i < mid){
				return randomSelect(a, low, mid, i);
			} else {
				return randomSelect(a, mid + 1, high, i);
			}
		}
		return a[low];
	}


}
