package algorithm.sort;


public class QuickSort extends Sort {

	public static void main(String[] args){
		int[] a = { 2, 1, 5, 7, 3, 8, 9, 0, 4, 6 };
		QuickSort quickSort = new QuickSort();
		quickSort.sort(a);
		quickSort.print(a);
	}
	
	@Override
	public void sort(int[] a) {
		quickSort(a, 0, a.length);
	}

	private void quickSort(int[] a, int low, int high) {
		if (low < high - 1){
			int mid = partition(a, low, high);
			quickSort(a, low, mid);
			quickSort(a, mid + 1, high);
		}
	}

	protected int partition(int[] a, int low, int high) {
		int p = choosePivot(a, low, high);
		int i = low; // last element of left part
		for (int j = low + 1; j < high; j++){
			if (a[j] < p){
				i ++;
				swap(a, i, j);
			}
		}
		swap(a, i, low);
		return i;
	}

	// median of first, middle and last element
	private int choosePivot(int[] a, int low, int high) {
		int mid = (low + high - 1) / 2;
		int pivotIndex = low;
		if (a[mid] > Math.min(a[low], a[high - 1]) && a[mid] < Math.max(a[low], a[high - 1])){
			pivotIndex = mid;
		} else if (a[high - 1] > Math.min(a[low], a[mid]) && a[high - 1] < Math.max(a[low], a[mid])){
			pivotIndex = high - 1;
		}
		swap(a, low, pivotIndex);
		return a[low];
	}

}
