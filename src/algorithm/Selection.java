package algorithm;

import algorithm.sort.QuickSort;

public class Selection extends QuickSort {

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		Selection selection = new Selection();
		int n = selection.select(a, 9);
		System.out.println(n);
	}

	private int select(int[] a, int k) {
		return randomSelect(a, 0, a.length - 1, k);
	}

	private int randomSelect(int[] a, int low, int high, int k) {
		if (low < high){
			int mid = partition(a, low, high);
			if (k == mid) {
				return a[mid];
			} else if (k < mid){
				return randomSelect(a, low, mid - 1, k);
			} else {
				return randomSelect(a, mid + 1, high, k);
			}
		}
		return a[low];
	}


}
