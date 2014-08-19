package algorithm.sort;

import algorithm.datastructure.MinHeap;

public class HeapSort extends Sort {

	@Override
	public void sort(int[] a) {
		Integer[] array = new Integer[a.length];
		for (int i = 0; i < a.length; i ++){
			array[i] = a[i];
		}
		MinHeap<Integer> heap = new MinHeap<Integer>(array);
		for (int i = 0; i < a.length; i ++){
			a[i] = heap.extractMin();
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		HeapSort heapSort = new HeapSort();
		heapSort.sort(a);
		heapSort.print(a);
	}

}
